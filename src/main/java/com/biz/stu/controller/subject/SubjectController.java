package com.biz.stu.controller.subject;

import com.biz.stu.common.Flag;
import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Student;
import com.biz.stu.model.Subject;
import com.biz.stu.service.score.ScoreService;
import com.biz.stu.service.student.StudentService;
import com.biz.stu.service.subject.SubjectService;
import com.biz.stu.vo.SelectCourseVo;
import com.biz.stu.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 16:02 2017/8/2
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/toSubjectList")
    public String toSubjectList() {

        return "subject/subjectList";
    }

    /**
     * 跳转到添加信息页面
     * @return
     */
    @RequestMapping("/toSave")
    public String toSave(@ModelAttribute Subject subject, Model model) {
        return "subject/saveSubject";
    }



    /**
     * 根据分页信息返回查询的课程信息
     * @param pageInfo
     * @return
     */
    @RequestMapping("/findAllByPaging")
    @ResponseBody
    public PageInfo findAllByPaging(@RequestParam("rows")Integer pageSize, PageInfo pageInfo) {
        pageInfo.setPageSize(pageSize);
        subjectService.findAllSubjectVoByPaging(pageInfo);
        return pageInfo;
    }

    /**
     * 保存或修改课程信息的方法
     * @param subject
     * @return
     */
    @RequestMapping("/save")
    public String save(Subject subject) {
        subjectService.save(subject);
        return "subject/subjectList";
    }

    @RequestMapping("/update")
    public String update(Subject subject) {
        subjectService.update(subject);
        return "subject update sucess!";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            subjectService.delete(id);
            stringBuilder.append("{\"flag\":"+ 1 +"}");
        } catch (Exception e) {
            stringBuilder.append("{\"flag\":"+ 0 +"}");
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    /**
     * 实现退课功能
     * @param studentId
     * @param subjectId
     * @param model
     * @return
     */
    @RequestMapping("/unBindingCourse")
    public String unBindingCourse(Integer studentId,Integer subjectId,Model model) {
        Flag flag = new Flag();
        try {
            subjectService.unBindingCourse(studentId,subjectId);
            flag.setUnBindingCourse("1");
        } catch (Exception e) {
            e.printStackTrace();
            flag.setUnBindingCourse("0");
        }
        model.addAttribute("flag",flag);
        Student student = studentService.findOne(studentId);
        model.addAttribute("student",student);
        return "subject/showSelectCourse";
    }

    /**
     * 当学生点击选课按钮时，实现学生选择课程并同步到数据库中
     * @param studentId
     * @param subjectId
     * @return
     */
    @RequestMapping("/selectCourse")
    public String selectCourse(Integer studentId,Integer subjectId,Model model) {
        Flag flag = new Flag();
        try {
            subjectService.selectCourse(studentId,subjectId);
            flag.setSelectedCourse("1");
        } catch (Exception e) {
            e.printStackTrace();
            flag.setSelectedCourse("0");
        }
        model.addAttribute("flag",flag);
        Student student = studentService.findOne(studentId);
        model.addAttribute("student",student);
        return "subject/showSelectCourse";
    }


    @RequestMapping("/findByPaging")
    public String findByPaging(PageInfo pageInfo) {
        Page page = subjectService.findByPaging(pageInfo);
        return "subject findByPaging sucess!";
    }

    /**
     * 获取所有课程的选课信息
     * @param studentId
     * @return
     */
    @RequestMapping("/getSelectCourseMessage")
    @ResponseBody
    public PageInfo getSelectCourseMessage(@RequestParam("rows")Integer pageSize,Integer studentId,PageInfo pageInfo) {
        pageInfo.setPageSize(pageSize);
        subjectService.findAllSelectCourseByStudentIdAndPaging(studentId,pageInfo);
        return pageInfo;
    }

    /**
     * 跳转到课程信息展示页面
     * @param
     * @return
     */
    @RequestMapping("/toSelectCourseShow")
    public String courseShow(Integer studentId,Model model) {
        //List<SelectCourseVo> subjects = subjectService.findNotSelectCourseByStudentId(studentId);
        Student student = studentService.findOne(studentId);
        model.addAttribute("studentId",studentId);
        model.addAttribute("student",student);
        return "subject/showSelectCourse";
    }


}
