package com.biz.stu.repository.Score;

import com.biz.stu.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 16:57 2017/8/2
 */
public interface ScoreRepository extends JpaRepository<Score,Integer>,JpaSpecificationExecutor<Score> {
    @Query("select s from Score s join s.student stu where stu.id=:stuId and s.subjectName=:subjectName")
    public Score findScoreByStudentIdAndSubjectName(@Param("stuId") Integer studentId,@Param("subjectName") String subjectName);

    /**
     * 通过课程名称查询车
     * @param subjectName
     * @return
     */
    @Query("select s from Score s where s.subjectName=:subjectName")
    public List<Score> findAllScoreBySubjectName(@Param("subjectName") String subjectName);

    /**
     * 根据学生id和课程名称删除学生的某一科课程分数信息
     * @param studentId
     * @param subjectName
     * @return
     */
    @Query(nativeQuery = true,value = "DELETE from score_tbl where subjectName=:sbujectName AND student_id=:studentId;")
    public Score deleteScoreByStudentIdAndSubjectName(@Param("studentId") Integer studentId,@Param("sbujectName") String subjectName);


}
