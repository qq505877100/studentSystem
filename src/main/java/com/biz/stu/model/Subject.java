package com.biz.stu.model;

import javax.persistence.*;
import java.awt.datatransfer.FlavorEvent;
import java.util.Set;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 0:12 2017/8/2
 */
@Entity
@Table(name = "subject_tbl")
public class Subject {
    private Integer id;
    private String subjectName;
    //每个科目选课上限
    private Integer limitStu = 0;
    private Set<Student> students;

    public Subject() {
    }

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "subjects")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


    @Column(length = 3)
    public Integer getLimitStu() {
        return limitStu;
    }

    public void setLimitStu(Integer limitStu) {
        this.limitStu = limitStu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 32,nullable = false)
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
