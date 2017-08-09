package com.biz.stu.controller.score;

import com.biz.stu.model.Score;
import com.biz.stu.model.Student;
import com.biz.stu.service.score.ScoreService;
import com.biz.stu.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 0:43 2017/8/8
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;
    /**
     * 实现分数持久化到数据库
     * @param score
     * @return
     */
    @RequestMapping("/save")
    public String save(Score score) {
        scoreService.save(score);
        return "score/scoreShow";
    }

    @RequestMapping("/update")
    public String update(Score score) {
        scoreService.update(score);
        return "score/scoreShow";
    }

    /**
     * 跳转到分数录入页面
     * @param studentId
     * @param
     * @return
     */
    @RequestMapping("/toScorePage")
    public String toScorePage(Integer studentId,Model model) {
        model.addAttribute("studentId",studentId);
        Student student = studentService.findOne(studentId);
        model.addAttribute("student",student);
        return "score/scoreShow";
    }


    @RequestMapping("/getStudentScoreMessage")
    @ResponseBody
    public List<Score> getStudentScoreMessage(Integer studentId,Model model) {
        //List<SelectCourseVo> subjects = subjectService.findNotSelectCourseByStudentId(studentId);
        //model.addAttribute("studentId",studentId);
        List<Score> scores = scoreService.findAllScoreByStudentId(studentId);
        return scores;
    }

}
