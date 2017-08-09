package com.biz.stu.service.subject;

import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Score;
import com.biz.stu.model.Student;
import com.biz.stu.model.Subject;
import com.biz.stu.repository.Score.ScoreRepository;
import com.biz.stu.repository.student.StudentRepository;
import com.biz.stu.repository.subject.SubjectRepository;
import com.biz.stu.service.score.ScoreService;
import com.biz.stu.service.student.StudentService;
import com.biz.stu.service.subject.SubjectService;
import com.biz.stu.util.NumberFormat;
import com.biz.stu.vo.SelectCourseVo;
import com.biz.stu.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 14:25 2017/8/2
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 判断条件，执行保存或者修改操作
     * @param subject
     * @return
     */
    public Subject save(Subject subject) {
        Subject persist = null;
        //这里实现save/update两个方法
        if (subject.getId() == null) {
            //执行保存操作
            subjectRepository.save(subject);
            persist = subject;
        } else {


            persist = subjectRepository.findOne(subject.getId());
            String subjectName = persist.getSubjectName();
            persist.setId(subject.getId());
            persist.setSubjectName(subject.getSubjectName());
            persist.setLimitStu(subject.getLimitStu());
            //在更改学科信息的同时需要修改存储该学生分数表中的课程名
            List<Score> scores = scoreRepository.findAllScoreBySubjectName(subjectName);
            for (Score score : scores) {
                score.setSubjectName(subject.getSubjectName());
            }
        }

        //这里使用自动更新完成修改操作
        return persist;

    }

    public Subject update(Subject subject) {
        Subject persist = subjectRepository.findOne(subject.getId());
        persist.setLimitStu(subject.getLimitStu());
        persist.setSubjectName(subject.getSubjectName());
        return persist;
    }

    public Iterable<Subject> save(Iterable<Subject> var1) {
        return subjectRepository.save(var1);
    }

    public void delete(Integer id) {
        subjectRepository.delete(id);
    }

    public void deleteAll() {
        subjectRepository.findAll();
    }

    public Subject findOne(Integer id) {
        return subjectRepository.findOne(id);
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    /**
     * 实现分页并按照选课上限排序
     * @param pageInfo
     * @return
     */
    public Page findByPaging(PageInfo pageInfo) {
        Sort sort = new Sort(Sort.Direction.DESC,"limitStu");
        PageRequest pageRequest = new PageRequest(pageInfo.getPage() - 1,pageInfo.getPageSize(),sort);
        Page<Subject> page = subjectRepository.findAll(pageRequest);
        return page;
    }

    /**
     * 查找该学生可选择的所有课程
     * @param studentId 学生ID
     * @return 返回指定学生可选的所有课程
     */
    public PageInfo findAllSelectCourseByStudentIdAndPaging(Integer studentId,PageInfo pageInfo) {
        Page page = findByPaging(pageInfo);
        pageInfo.setTotalPages(page.getTotalPages());
        pageInfo.setTotalElements(page.getTotalElements());
        List<Subject> subjects = page.getContent();
        //这里进行视图模型的拼装
        List<SelectCourseVo> selectCourseVos = new ArrayList<SelectCourseVo>();
        for (Subject subject : subjects) {
            SelectCourseVo selectCourseVo = new SelectCourseVo();
            selectCourseVo.setStudentId(studentId);
            selectCourseVo.setSubjectId(subject.getId());
            //获取课程上限人数
            Integer selectedStudent = subject.getLimitStu();
            selectCourseVo.setLimitStu(selectedStudent);
            //设置该学生是否选择该课程的标记,通过一个方法查询即可
            Subject subj = subjectRepository.whetherSelectedTheSubjectByStudentAndSubjectId(studentId, subject.getId());
            if (subj != null) {
                //说明选了该课程
                selectCourseVo.setSelectFlag("1");
            } else {
                selectCourseVo.setSelectFlag("0");
            }
            //设置课程名称
            selectCourseVo.setSubjectName(subject.getSubjectName());
            //获取该课程已选学生的人数
            int selectedCourse = this.getSelectedStudentsNumBySubjectId(subject.getId());
            selectCourseVo.setTotalStus(selectedCourse);
            if (selectedStudent > selectedCourse) {
                selectCourseVo.setState(true);
            } else if (selectedStudent <= selectedCourse){
                selectCourseVo.setState(false);
            }
            selectCourseVos.add(selectCourseVo);
        }
        pageInfo.setRows(selectCourseVos);
        return pageInfo;
        /*//第一，先封装该学生已选课程信息
        List<Subject> selectedCourses = subjectRepository.findAllSelectedCourseByStudentId(studentId);
        if (selectCourseVos != null && selectCourseVos.size() >0) {
            for (Subject subject : selectedCourses) {
                SelectCourseVo selectCourseVo = new SelectCourseVo();
                selectCourseVo.setStudentId(studentId);
                selectCourseVo.setSubjectId(subject.getId());
                //获取课程上限人数
                Integer selectedStudent = subject.getLimitStu();
                selectCourseVo.setLimitStu(selectedStudent);
                //设置该学生选择该课程的标记
                selectCourseVo.setSelectFlag("1");
                //设置课程名称
                selectCourseVo.setSubjectName(subject.getSubjectName());
                //获取该课程已选学生的人数

                int selectedCourse = this.getSelectedStudentsNumBySubjectId(subject.getId());
                selectCourseVo.setTotalStus(selectedCourse);
                if (selectedStudent > selectedCourse) {
                    selectCourseVo.setState(true);
                } else if (selectedStudent <= selectedCourse){
                    selectCourseVo.setState(false);
                }
                selectCourseVos.add(selectCourseVo);
            }
        }

        //第二，封装该学生未选择的课程信息
        List<Subject> notSelectedCourses = subjectRepository.findAllNotSelectedCourseByStudentId(studentId);
        if (notSelectedCourses != null && notSelectedCourses.size() > 0) {
            for (Subject subject : selectedCourses) {
                SelectCourseVo selectCourseVo = new SelectCourseVo();
                selectCourseVo.setStudentId(studentId);
                selectCourseVo.setSubjectId(subject.getId());
                //获取课程上限人数
                Integer selectedStudent = subject.getLimitStu();
                selectCourseVo.setLimitStu(selectedStudent);
                //设置该学生选择该课程的标记
                selectCourseVo.setSelectFlag("0");
                //设置课程名称
                selectCourseVo.setSubjectName(subject.getSubjectName());
                //获取该课程已选学生的人数

                int selectedCourse = this.getSelectedStudentsNumBySubjectId(subject.getId());
                selectCourseVo.setTotalStus(selectedCourse);
                if (selectedStudent > selectedCourse) {
                    selectCourseVo.setState(true);
                } else if (selectedStudent <= selectedCourse){
                    selectCourseVo.setState(false);
                }
                selectCourseVos.add(selectCourseVo);
            }
        }*/

    }




    /**
     * 返回所有学科的所有信息集合，包括课程名称，选择该课程的学生总数，课程的平均分等等。
     * @return 返回所有学科的信息列表
     */
    public PageInfo findAllSubjectVoByPaging(PageInfo pageInfo) {
        //注意这里需要根据分页信息查询，明天补
        Page page = findByPaging(pageInfo);
        pageInfo.setTotalPages(page.getTotalPages());
        pageInfo.setTotalElements(page.getTotalElements());
        List<Subject> subjects = page.getContent();
        List<SubjectVo> subjectVos = new ArrayList<SubjectVo>();
        for (Subject subject : subjects) {
            SubjectVo subjectVo = new SubjectVo();
            //设置选择该课程的学生人数
            Set<Student> students = subject.getStudents();
            Integer stuNumber = subject.getStudents().size();
            subjectVo.setTotalStus(stuNumber);
            //设置课程平均分
            Float sum = 0f;
            Float avg = 0f;
            //这里需要注意，可能students为空，那么遍历空会报空指针异常，所有要进行判断在遍历。
            if (students != null && students.size() != 0) {
                for (Student student : students) {
                    Score score = scoreRepository.findScoreByStudentIdAndSubjectName(student.getId(), subject.getSubjectName());
                    if (score != null) {
                        if (score.getScore() == null) {
                            sum += 0;
                        } else {
                            sum += score.getScore();
                        }

                    }
                }
            }

            if (stuNumber != 0) {
                avg = sum / stuNumber;
                avg = NumberFormat.floatFormat(avg,2);
            }
            subjectVo.setSubjectAvg(avg);
            //设置课程信息,不能这么做会把学生和班级的关系解除
            //subject.setStudents(null);
            subjectVo.setId(subject.getId());
            subjectVo.setSubjectName(subject.getSubjectName());
            subjectVo.setLimitStu(subject.getLimitStu());
            subjectVos.add(subjectVo);
        }
        pageInfo.setRows(subjectVos);
        return pageInfo;
    }

    /**
     * 获取该课程已经选择的人数
     * @param subjectId 传入的课程id
     * @return 返回一个该课程已选的人数
     */
    public Integer getSelectedStudentsNumBySubjectId(Integer subjectId) {
        return subjectRepository.getSelectedStudentsNumBySubjectId(subjectId);
    }


    public Subject whetherSelectedTheSubjectByStudentAndSubjectId(Integer studentId, Integer subjectId) {
        return subjectRepository.whetherSelectedTheSubjectByStudentAndSubjectId(studentId,subjectId);
    }

    /**
     * 实现退课功能
     * @param studentId
     * @param subjectId
     */
    public void unBindingCourse(Integer studentId, Integer subjectId) {
        Student student = studentRepository.findOne(studentId);
        Subject subject = subjectRepository.findOne(subjectId);
        student.getSubjects().remove(subject);
        //z在退课成功时，同时将分数表里删除对应的一条分数记录，
        Score score = scoreRepository.findScoreByStudentIdAndSubjectName(studentId, subject.getSubjectName());
        scoreRepository.delete(score);
    }

    /**
     * 该方法是实现学生选课的功能。即在中间表中插入一个表示学生选择课程的记录
     * @param studentId 学生的id
     * @param subjectId 课程的id
     *
     */
    public void selectCourse(Integer studentId, Integer subjectId) {
        Student student = studentRepository.findOne(studentId);
        Subject subject = subjectRepository.findOne(subjectId);
        student.getSubjects().add(subject);
        //z在选课成功时，同时向分数表里插入一条记录，以便给科目打分。
        Score score = new Score();
        score.setStudent(student);
        score.setSubjectName(subject.getSubjectName());
        scoreRepository.save(score);
    }

   /* *
     * 查找该学生选课的相关信息，即查询已选择的和未选择课程的信息。
     * @param studentId
     * @return 返回学生的所有选课信息（包括已选择和未选择的信息）
    public List<Subject> findSelectCourseInfoByStudentId(Integer studentId) {
        List<Subject> subjects = subjectRepository.findSelectCourseInfoByStudentId(studentId);
        return subjects;
    }*/
}
