package com.biz.stu.vo;

import com.biz.stu.model.Subject;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 17:32 2017/8/2
 */
public class SelectCourseVo {
    private Integer studentId;
    private Integer subjectId;
    private String subjectName;
    private Integer limitStu;
    private Integer totalStus;
    //该学生选课的状态，true为已经选择，false未选择。
    private Boolean state;
    //判断学生是否选择该课程的标志1代表选择，0代表为选择
    private String selectFlag;

    public String getSelectFlag() {
        return selectFlag;
    }

    public void setSelectFlag(String selectFlag) {
        this.selectFlag = selectFlag;
    }

    public SelectCourseVo() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getLimitStu() {
        return limitStu;
    }

    public void setLimitStu(Integer limitStu) {
        this.limitStu = limitStu;
    }

    public Integer getTotalStus() {
        return totalStus;
    }

    public void setTotalStus(Integer totalStus) {
        this.totalStus = totalStus;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
