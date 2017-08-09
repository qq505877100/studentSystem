package com.biz.stu.vo;

import com.biz.stu.model.Student;

import java.util.Date;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 0:24 2017/8/2
 */
public class StudentVo {
    private Integer id;
    private String studentName;
    //学号
    private String studentNum;
    //照片存储的是服务器上的地址值
    private String picture;
    private Integer gender;
    private Date birthday;
    private Float avg;
    private Integer subjectNum;
    //这里使用班级名称保存一个学生所在班级，而不是使用一个班级对象保存
    private String className;

    public StudentVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Float getAvg() {
        return avg;
    }

    public void setAvg(Float avg) {
        this.avg = avg;
    }

    public Integer getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(Integer subjectNum) {
        this.subjectNum = subjectNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
