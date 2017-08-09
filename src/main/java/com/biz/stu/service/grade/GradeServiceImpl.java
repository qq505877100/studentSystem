package com.biz.stu.service.grade;

import com.biz.stu.model.Grade;
import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Student;
import com.biz.stu.model.Subject;
import com.biz.stu.repository.Score.ScoreRepository;
import com.biz.stu.repository.grade.GradeRepository;
import com.biz.stu.repository.student.StudentRepository;
import com.biz.stu.service.score.ScoreService;
import com.biz.stu.service.student.StudentService;
import com.biz.stu.util.NumberFormat;
import com.biz.stu.vo.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 13:57 2017/8/2
 */
@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public Grade save(Grade grade) {
        //这里实现save/update两个方法
        Grade persist = null;
        Integer id = grade.getId();
        if (id == null) {
            //执行保存操作
            gradeRepository.save(grade);
            persist = grade;
        } else {
            //执行修改操作
            persist = gradeRepository.findOne(id);
            persist.setClassName(grade.getClassName());
        }

        return persist;
    }

    public Grade update(Grade grade) {
        Grade persist = gradeRepository.findOne(grade.getId());
        persist.setClassName(grade.getClassName());
        return persist;
    }

    public Iterable<Grade> save(Iterable<Grade> var1) {
        List<Grade> grades = gradeRepository.save(var1);
        return grades;
    }

    /**
     * 删除一个班级首先要解除与该班级关联的学生表外键关系，即设置为null即可
     * @param id
     */
    public void delete(Integer id) {
        List<Student> students = studentService.findAllStudentsByClassId(id);
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        //解除所有有关该班级的学生信息
        for (Student student : students) {
            student.setGrade(null);
            /*studentService.save(student);
            entityManager.flush();*/
        }

        gradeRepository.delete(id);
    }

    public void deleteAll() {
        gradeRepository.deleteAll();
    }

    public Grade findOne(Integer id) {
        return gradeRepository.findOne(id);
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    /**
     * 实现分页查询，并按照班级平均分降序排序
     * @param pageInfo
     * @return
     */
    public Page findByPaging(PageInfo pageInfo) {
        //这里需要注意，jap的页数是从0开始的，所以需要减一处理
        //Sort sort = new Sort(Sort.Direction.DESC,"classAvg");
        PageRequest pageRequest = new PageRequest((pageInfo.getPage()) - 1,pageInfo.getPageSize());
        Page<Grade> page = gradeRepository.findAll(pageRequest);
        return page;
    }

    /**
     * 返回所有班级的所有信息情况（包括班级名称，班级平均分，班级人数等）
     * @return
     */
    public List<GradeVo> findAllVo() {
        List<Grade> grades = findAll();
        List<GradeVo> gradeVos = new ArrayList<GradeVo>();
        for (Grade grade : grades) {
            GradeVo gradeVo = new GradeVo();
            //求班级平均分
            Float sum = 0f;
            Integer stuNumber = grade.getStudents().size();
            Float avg = 0f;
            for (Student student : grade.getStudents()) {
                Float stuAvg = studentService.getStudentAllSubjectsAvgById(student.getId());
                sum += stuAvg;
            }
            //判断班级人数，如果人数为0，设置平均分为0
            if (stuNumber != 0) {
                avg = sum / stuNumber;
            }
            gradeVo.setClassAvg(avg);
            //设置班级总人数
            gradeVo.setTotalStus(stuNumber);
            //前段不需要学生的详细信息，因此设置为null垃圾回收。
            //grade.setStudents(null);
            gradeVo.setId(grade.getId());
            gradeVo.setClassName(grade.getClassName());
            gradeVos.add(gradeVo);
        }
        return gradeVos;
    }

    public PageInfo findAllGradeVoByPaging(PageInfo pageInfo) {
        Page page = findByPaging(pageInfo);
        List<Grade> grades = page.getContent();
        pageInfo.setTotalPages(page.getTotalPages());
        pageInfo.setTotalElements(page.getTotalElements());
        List<GradeVo> gradeVos = new ArrayList<GradeVo>();
        for (Grade grade : grades) {
            GradeVo gradeVo = new GradeVo();
            //求班级平均分
            Float sum = 0f;
            Integer stuNumber = grade.getStudents().size();
            Float avg = 0f;
            for (Student student : grade.getStudents()) {
                Float stuAvg = studentService.getStudentAllSubjectsAvgById(student.getId());
                sum += stuAvg;
            }
            //判断班级人数，如果人数为0，设置平均分为0
            if (stuNumber != 0) {
                avg = sum / stuNumber;
                avg = NumberFormat.floatFormat(avg,2);
            }
            gradeVo.setClassAvg(avg);
            //设置班级总人数
            gradeVo.setTotalStus(stuNumber);
            //前段不需要学生的详细信息，因此设置为null垃圾回收。
            //grade.setStudents(null);
            gradeVo.setId(grade.getId());
            gradeVo.setClassName(grade.getClassName());
            gradeVos.add(gradeVo);
        }
        pageInfo.setRows(gradeVos);
        return pageInfo;
    }

    public boolean existsByClassName(String className) {
        Grade grade = gradeRepository.findGradeByClassName(className);
        if (grade != null) {
            return true;
        }
        return false;
    }

}
