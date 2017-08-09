package com.biz.stu.service.score;

import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Score;
import com.biz.stu.model.Student;
import com.biz.stu.repository.Score.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 16:59 2017/8/2
 */
@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public Score update(Score score) {
        //只修改分数而已
        Score persist = scoreRepository.findOne(score.getId());
        persist.setScore(score.getScore());
        //persist.setSubjectName(score.getSubjectName());
        return persist;
    }

    public Iterable<Score> save(Iterable<Score> var1) {
        return null;
    }

    public void delete(Integer integer) {

    }

    public void deleteAll() {

    }

    public Score findOne(Integer id) {
        return scoreRepository.findOne(id);
    }

    public List<Score> findAll() {
        return null;
    }

    public Page findByPaging(PageInfo pageInfo) {
        return null;
    }

    /**
     *使用内连接完成查询,返回学生所有选课成绩记录
     * @param id 接受学生的id查询出该学生的所有选课成绩
     * @return 返回该学生的所有选课科目的分数记录，以便学生进行修改
     */
    public List<Score> findAllScoreByStudentId(Integer id) {
        List<Score> scores = scoreRepository.findAll(getSpecification(id));
        return scores;
    }

    /**
     * 根据学生id和课程名称查找该学生这门课程的成绩
     * @param studentId
     * @param subjectName
     * @return 返回该学生该门课程的成绩
     */
    public Score findScoreByStudentIdAndSubjectName(Integer studentId, String subjectName) {
        Score score = scoreRepository.findScoreByStudentIdAndSubjectName(studentId, subjectName);
        return score;
    }


    public Specification<Score> getSpecification(final Integer id) {
        Specification specification = new Specification() {
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //联合查询,默认进行内连接查询了
                Join<Score,Student> studentJoin = root.join("student", JoinType.INNER);
                Predicate predicate = criteriaBuilder.equal(studentJoin.<Integer>get("id"), id);
                criteriaQuery.where(predicate);
                return null;
            }
        };
        return specification;
    }
}
