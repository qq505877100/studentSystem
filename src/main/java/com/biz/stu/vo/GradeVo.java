package com.biz.stu.vo;

import com.biz.stu.model.Grade;

/**
 * @author fuxianhui
 * @Description: 班级的视图对象用于展示数据给用户看
 * @Date: create in 0:08 2017/8/2
 */
public class GradeVo {
    private Integer id;
    private String className;
    private Float classAvg;
    private Integer totalStus;

    public GradeVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Float getClassAvg() {
        return classAvg;
    }

    public void setClassAvg(Float classAvg) {
        this.classAvg = classAvg;
    }

    public Integer getTotalStus() {
        return totalStus;
    }

    public void setTotalStus(Integer totalStus) {
        this.totalStus = totalStus;
    }
}
