package com.biz.stu.controller.student;

import com.biz.stu.common.Flag;
import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Student;
import com.biz.stu.model.Subject;
import com.biz.stu.service.student.StudentService;
import com.biz.stu.service.subject.SubjectService;
import com.biz.stu.util.PojoUtils;
import com.biz.stu.vo.SelectCourseVo;
import com.biz.stu.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author fuxianhui
 * @version
 * @Description:
 * @Date: create in ${TIME} ${DATE}
 */
//@RestController
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired SubjectService subjectService;


    /**
     * 这是可以实现保存和修改学生信息的方法，在service中判断id是否存在，从而实现是新建学生信息还是
     * 修改学生信息。
     * @param picture
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/save")
    public String save(MultipartFile picture, HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        //手动封装
        Student student = PojoUtils.bindParamsToStudent(multipartHttpServletRequest);
        //实现上传图片
        if (picture != null && picture.getOriginalFilename() != null
                && !picture.getOriginalFilename().equals("")) {

            //获取图片原始名称，目标要从原始名称中获取文件的扩展名
            String originalFilename = picture.getOriginalFilename();
            //新文件名称
            String fileName_new = UUID.randomUUID().toString().replace("-","")
                    + originalFilename.substring(originalFilename
                    .lastIndexOf("."));
            //工程根路径
           String realPath = request.getSession().getServletContext().getRealPath("/");
           String ralativePath = "/picture/" +fileName_new;
            File parent = new File(realPath + "/picture/");
            File newFile = null;
            if (parent.exists()) {
                newFile = new File(parent,fileName_new);
            } else {
                parent.mkdirs();
                newFile = new File(parent,fileName_new);
            }

            //将内存中的文件内容写入磁盘上
            picture.transferTo(newFile);
            //将新的文件路径更新到学生实体中
            student.setPicture(ralativePath);
            //items.setPic(fileName_new);
        } else {
            student.setPicture("");
        }
        studentService.save(student);
        return "student/studentList";
    }

    @RequestMapping("/toSave")
    public String toSave(Integer studentId,Model model) {
        if (studentId == null) {
        } else {
            //用作数据回显
            Student student = studentService.findOne(studentId);
            model.addAttribute("student",student);
        }
        return "student/saveStudent";
    }

    /**
     *
     * @param id 传入学生的id删除指定学生信息
     * @return 返回删除成功后跳转的页面
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            studentService.delete(id);
            stringBuilder.append("{\"flag\":"+ 1 +"}");
        } catch (Exception e) {
            stringBuilder.append("{\"flag\":"+ 0 +"}");
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 由于jqgrid控件的添加修改方法提交的是同一个地址，所以在update方法里实现了根据传来的
     * 信息判断执行相应的保存、修改操作
     * @param student
     * @return
     */
    @RequestMapping("/update")
    public String update(Student student) {
        studentService.update(student);
        return "student/studentList";
    }

    /**
     * 按照前段传来的分页信息查找符合条件的学生信息
     * @param pageSize
     * @param pageInfo
     * @return
     */
    @RequestMapping("/findAllByPage")
    @ResponseBody
    public PageInfo findAllByPage(@RequestParam("rows")Integer pageSize, PageInfo pageInfo) {
        pageInfo.setPageSize(pageSize);
        studentService.findAllStudentVoByPaging(pageInfo);
        return pageInfo;
    }
}
