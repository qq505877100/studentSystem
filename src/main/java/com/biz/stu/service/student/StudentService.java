package com.biz.stu.service.student;

import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Score;
import com.biz.stu.model.Student;
import com.biz.stu.service.BaseService;
import com.biz.stu.vo.StudentVo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService extends BaseService<Student,Integer>{


    public Float getStudentAllSubjectsAvgById(Integer studentId);
    public PageInfo findAllStudentVoByPaging(PageInfo pageInfo);
    public List<Student> findAllStudentsByClassId(Integer classId);
    public Integer getStudentSelectedSubjectsById(Integer studentId);

}
