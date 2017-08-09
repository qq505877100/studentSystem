package com.biz.stu.util;

import com.biz.stu.model.Grade;
import com.biz.stu.model.Student;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 17:48 2017/8/7
 */
public class PojoUtils {
    public static Student bindParamsToStudent(MultipartHttpServletRequest multipart) {
        String id = multipart.getParameter("id");
        String studentName = multipart.getParameter("studentName");
        String studentNum = multipart.getParameter("studentNum");
        String birthday = multipart.getParameter("birthday");
        String gradeId = multipart.getParameter("grade.id");
        String gender = multipart.getParameter("gender");
        //参数绑定
        Student student = new Student();
        if (id != null && !"".equals(id.trim())) {
            student.setId(Integer.parseInt(id));
        }
        student.setStudentName(studentName);
        student.setStudentNum(studentNum);
        student.setBirthday(DateFormatUtils.stringToDate(birthday));
        student.setGender(Integer.parseInt(gender));
        if (gradeId != null && !"".equals(gradeId.trim())) {
            Grade grade = new Grade();
            grade.setId(Integer.parseInt(gradeId));
            student.setGrade(grade);
        }
        return student;
    }
}
