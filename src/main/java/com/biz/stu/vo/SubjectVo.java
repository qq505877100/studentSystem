package com.biz.stu.vo;

import com.biz.stu.model.Subject;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 0:15 2017/8/2
 */
public class SubjectVo {
    private Integer id;
    private String subjectName;
    //每个科目选课上限
    private Integer limitStu;
    private Float subjectAvg = 0f;
    private Integer totalStus;

    public SubjectVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Float getSubjectAvg() {
        return subjectAvg;
    }

    public void setSubjectAvg(Float subjectAvg) {
        this.subjectAvg = subjectAvg;
    }

    public Integer getTotalStus() {
        return totalStus;
    }

    public void setTotalStus(Integer totalStus) {
        this.totalStus = totalStus;
    }
}
