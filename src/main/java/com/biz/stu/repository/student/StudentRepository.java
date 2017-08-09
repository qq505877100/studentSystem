package com.biz.stu.repository.student;

import com.biz.stu.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {

    /**
     * 根据班级id查询差该班级拥有的所有学生信息
     * @param classId
     * @return
     */
    @Query("select stu from Student stu join stu.grade g where g.id=:id")
    public List<Student> findAllStudentsByClassId(@Param("id") Integer classId);

    /**
     * 根据学生id获取该学生已选的课程数目
     * @param studentId
     * @return
     */
    @Query("select count(stu.id) from Student stu join stu.subjects where stu.id=:id")
    public Integer getStudentSelectedSubjectsById(@Param("id") Integer studentId);
}
