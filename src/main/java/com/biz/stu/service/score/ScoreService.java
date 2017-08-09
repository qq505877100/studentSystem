package com.biz.stu.service.score;

import com.biz.stu.model.Score;
import com.biz.stu.service.BaseService;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 16:58 2017/8/2
 */
public interface ScoreService extends BaseService<Score,Integer>{
    public List<Score> findAllScoreByStudentId(Integer id);
    public Score findScoreByStudentIdAndSubjectName(Integer studentId,String subjectName);

}
