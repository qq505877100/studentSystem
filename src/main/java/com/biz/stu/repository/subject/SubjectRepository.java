package com.biz.stu.repository.subject;

import com.biz.stu.model.Student;
import com.biz.stu.model.Subject;
import com.biz.stu.vo.SelectCourseVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 13:54 2017/8/2
 */
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    /*
    //本意是查找指定学生已选的课程信息和未选的课程信息，但是实现不了
    @Modifying
    @Query(nativeQuery = true,value = "select sub.* from student_tbl stu INNER JOIN " +
            "student_subject stu_sub ON stu.id=stu_sub.student_id AND stu.id=?1 " +
            "RIGHT JOIN subject_tbl sub ON stu_sub.subject_id=sub.id")
    public List<Subject> findSelectCourseInfoByStudentId(Integer id);*/

    @Modifying
    @Query(nativeQuery = true,value = "SELECT sub.* from subject_tbl sub where id NOT IN " +
            "(select stu_sub.subject_id from student_tbl stu " +
            "INNER JOIN student_subject stu_sub " +
            "ON stu.id=stu_sub.student_id AND stu.id=:id);")
    public List<Subject> findNotSelectCourseByStudentId(@Param("id") Integer studentId);

    /**
     * 根据课程id获取选择该课程的学生人数
     * @param subjectId
     * @return
     */
    @Query("select count(sub.id) from Subject sub join sub.students stu where sub.id=:id")
    public Integer getSelectedStudentsNumBySubjectId(@Param("id") Integer subjectId);

    /**
     * 通过学生id查找出该学生的所有课程信息（包括已选/未选的课程信息）
     * @param studentId
     * @return
     */
/*    @Query(nativeQuery = true,value = "select stu.id studentId,sub.id subjectId,sub.subjectName subjectName,\n" +
            "sub.limitStu limitStu from subject_tbl sub LEFT JOIN student_subject stu_subj ON \n" +
            "sub.id=stu_subj.subject_id \n" +
            "LEFT JOIN student_tbl stu on \n" +
            "stu_subj.student_id=stu.id where stu.id=:studentId or stu.id is NULL")*/
/*   @Query("select sub from Subject sub left join sub.students stu where stu.id=:studentId or stu.id is null")
    public List<Subject> findAllSubjectMessageByStudentId(@Param("studentId") Integer studentId);*/

    /**
     * 根据學生的id和课程id查询出该学生是否选择了该课程，
     * @param studentId
     * @param subjectId
     * @return
     */
  @Query("select sub from Subject sub join sub.students stu where stu.id=:studentId and sub.id=:subjectId")
  public Subject whetherSelectedTheSubjectByStudentAndSubjectId(@Param("studentId") Integer studentId,@Param("subjectId") Integer subjectId);

    /**
     * 根据学生id查询出该学生所有已选课程的信息
     * @param studentId
     * @return
     */
  @Query("select sub from Subject sub join sub.students stu where stu.id=:studentId")
  public List<Subject>  findAllSelectedCourseByStudentId(Integer studentId);

    /**
     * 根据学生id查询出该学生所有未选课程的信息
     * @param studentId
     * @return
     */
    @Query("select sub from Subject sub where sub.id not in (select sub.id from Subject sub join sub.students stu where stu.id=:studentId)")
    public List<Subject>  findAllNotSelectedCourseByStudentId(Integer studentId);


}
