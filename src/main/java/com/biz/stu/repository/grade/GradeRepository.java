package com.biz.stu.repository.grade;

import com.biz.stu.model.Grade;
import com.biz.stu.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 13:53 2017/8/2
 */
public interface GradeRepository extends JpaRepository<Grade,Integer> {
    /*@Query("select g from Grade g join g.students stu where g.id=:id ")
    public List<Grade> findAllStudentByGradeId(@Param("id") Integer gradeId);*/

    @Query("select g from Grade g where g.className=:name")
    public Grade findGradeByClassName(@Param("name") String className);

}
