package com.biz.stu.service.student;

import com.biz.stu.model.*;
import com.biz.stu.repository.student.StudentRepository;
import com.biz.stu.service.score.ScoreService;
import com.biz.stu.service.subject.SubjectService;
import com.biz.stu.util.NumberFormat;
import com.biz.stu.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ScoreService scoreService;

    /**
     * 判断是保存还是修改操作，执行对应的操作
     * @param student
     * @return
     */

    public Student save(Student student) {
        //这里实现save/update两个方法
        Student persist = null;
        //这里使用自动更新完成修改操作
        if (student.getId() == null) {
            //执行保存操作
            studentRepository.save(student);
            persist = student;
        } else {
            //执行修改操作
            persist = studentRepository.findOne(student.getId());
            persist.setStudentName(student.getStudentName());
            persist.setStudentNum(student.getStudentNum());
            if (student.getBirthday() != null ) {
                persist.setBirthday(student.getBirthday());
            }

            persist.setGender(student.getGender());

            if (student.getPicture() != null && !"".equals(student.getPicture().trim()) ) {
                persist.setPicture(student.getPicture());
            }
            //注意，可能之前该学生就没有班级信息，即grade对象为空，而此时使用到班级的对象
            // 显然不行，要进行判断处理
            if (persist.getGrade() != null) {
                persist.getGrade().setId(student.getGrade().getId());
            } else {
                //自己创建一个班级，把id添加上
                Grade grade = new Grade();
                persist.setGrade(grade);
                //如果说student也没有班级信息（说明没有要设置班级信息），所以还有对班级进行判断才可以，
                //否则也会出现空指针异常
                if (student.getGrade() != null) {
                    persist.getGrade().setId(student.getGrade().getId());
                } else {
                    //即不绑定班级关系，设置为null
                    persist.setGrade(null);
                }

            }
        }

        return persist;

    }

    public Student update(Student student) {
        //这里实现save/update两个方法
        Student persist = studentRepository.findOne(student.getId());
        //这里使用自动更新完成修改操作
        if (persist == null) {
            save(student);
            persist = student;
        } else {
            persist.setStudentName(student.getStudentName());
            persist.setStudentNum(student.getStudentNum());
            persist.setBirthday(student.getBirthday());
            persist.setGender(student.getGender());
            persist.setPicture(student.getPicture());
            persist.getGrade().setId(student.getGrade().getId());
        }

        return persist;
    }

    public Iterable<Student> save(Iterable<Student> var1) {

        return studentRepository.save(var1);
    }

    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public Student findOne(Integer id) {
        return studentRepository.findOne(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * 分页查询学生信息,并按照学生的科目平均分降序返回
     * @param pageInfo 分页信息
     * @return 返回page对象，该对象封装了查询后的结果
     */
    public Page findByPaging(PageInfo pageInfo) {
        //Sort sort = new Sort(Sort.Direction.DESC,"avg");
        PageRequest pageRequest = new PageRequest(pageInfo.getPage() - 1,pageInfo.getPageSize());
        Page<Student> page = studentRepository.findAll(pageRequest);
        return page;
    }

    /**
     * 获取该学生选择的所有科目的平均分，算出只有打分的才算入计算平均分
     * @param studentId
     * @return
     */
    public Float getStudentAllSubjectsAvgById(Integer studentId) {
        //获取学生已经选的所有课程的分数信息
        List<Score> scores = scoreService.findAllScoreByStudentId(studentId);
        //计算平均分
        Float avg = 0f;
        Float sum = 0f;
        Integer count = 0;
        for (Score score: scores) {
            if (score.getScore() != null) {
                count++;
                sum += score.getScore();
            }
        }
        //注意如果count等于0，说明该学生的所有课程没有打分，那么设置平均分为0
        if (count != 0) {
            avg = sum / count;
            avg = NumberFormat.floatFormat(avg,2);
        }

        return avg;
    }

    /**
     * 获取所有学生的具体信息，包括姓名，学号，平均分等等
     * @return 返回学生的具体信息列表集合
     */
    public PageInfo findAllStudentVoByPaging(PageInfo pageInfo) {
        Page<Student> page = findByPaging(pageInfo);
        pageInfo.setTotalPages(page.getTotalPages());
        pageInfo.setTotalElements(page.getTotalElements());
        List<Student> students = page.getContent();
        List<StudentVo> studentVos = new ArrayList<StudentVo>();

        for (Student student : students) {
            StudentVo studentVo = new StudentVo();
            List<Score> scores = scoreService.findAllScoreByStudentId(student.getId());
            //设置学生选课总数目
            Integer subjectNum = getStudentSelectedSubjectsById(student.getId());
            studentVo.setSubjectNum(subjectNum);
            //设置总学科平均分
            Float avg = 0f;
            Float sum = 0f;
            for (Score score : scores) {
                //如果学科分数为null，设置默认值为0
                if (score.getScore() == null) {
                    sum += 0;
                } else {
                    sum += score.getScore();
                }
            }
            if (sum != 0f) {
                avg = sum / subjectNum;
                avg = NumberFormat.floatFormat(avg,2);
            }
            studentVo.setAvg(avg);
            //设置班级,如果班级不存在设置为空
            if (student.getGrade() == null) {
                studentVo.setClassName("");
            } else {
                studentVo.setClassName(student.getGrade().getClassName());
            }
            //设置学生信息，不能这么做
            /*student.setSubjects(null);
            student.setScores(null);
            student.setGrade(null);*/
            studentVo.setId(student.getId());
            studentVo.setStudentName(student.getStudentName());
            studentVo.setStudentNum(student.getStudentNum());
            studentVo.setPicture(student.getPicture());
            studentVo.setGender(student.getGender());
            studentVo.setBirthday(student.getBirthday());
            studentVos.add(studentVo);
        }
        pageInfo.setRows(studentVos);
        return pageInfo;
    }

    public List<Student> findAllStudentsByClassId(Integer classId) {
        return studentRepository.findAllStudentsByClassId(classId);
    }



    /**
     * 查找指定学生已选择的课程
     * @param studentId
     * @return 返回学生已经选择的课程信息
     */
    public Integer getStudentSelectedSubjectsById(Integer studentId) {
        return studentRepository.getStudentSelectedSubjectsById(studentId);
    }
}
