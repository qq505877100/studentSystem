package com.biz.stu.controller.grade;

import com.biz.stu.common.Flag;
import com.biz.stu.model.Grade;
import com.biz.stu.model.PageInfo;
import com.biz.stu.service.grade.GradeService;
import com.biz.stu.vo.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 14:32 2017/8/2
 */
@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/toGradeList")
    public String toGradeList() {
        return "grade/gradeList";
    }

    @RequestMapping("/toSave")
    public String toSave(@ModelAttribute Grade grade) {
        return "grade/saveGrade";
    }

    @RequestMapping("/save")
    public String save(Grade grade, Model model) {
        /*for (int i = 1; i <= 15; i++) {
            Grade grade1 = new Grade();
            grade1.setClassName("终极"+i+"班");
            gradeService.save(grade);
        }*/
        gradeService.save(grade);
        return "grade/gradeList";
    }

    @RequestMapping("/update")
    public String update(Grade grade, Model model) {
        gradeService.save(grade);
        return "";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            gradeService.delete(id);
            stringBuilder.append("{\"flag\":"+ 1 +"}");
        } catch (Exception e) {
            e.printStackTrace();
            stringBuilder.append("{\"flag\":"+ 0 +"}");
        }
        return stringBuilder.toString();
    }

    @RequestMapping("/find")
    public Grade find(Integer id) {
        Grade grade = gradeService.findOne(id);
        return grade;
    }

    @RequestMapping("/testClassName")
    @ResponseBody
    public Flag testClassName(String className) {
        Flag flag = new Flag();
        boolean exists = gradeService.existsByClassName(className);
        if (exists) {
            flag.setClassExist("1");
        } else {
            flag.setClassExist("0");
        }
        return flag;
    }

    @RequestMapping("/findAllByPaging")
    @ResponseBody
    public PageInfo findAllByPaging(@RequestParam("rows")Integer pageSize, PageInfo pageInfo) {
        pageInfo.setPageSize(pageSize);
        gradeService.findAllGradeVoByPaging(pageInfo);
        return pageInfo;
    }


}
