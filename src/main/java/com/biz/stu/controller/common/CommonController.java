package com.biz.stu.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 21:14 2017/8/6
 */
@Controller
public class CommonController {
    @RequestMapping("/index.do")
    public String index() {
        return "student/studentList";
    }
}
