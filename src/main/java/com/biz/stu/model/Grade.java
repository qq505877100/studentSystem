package com.biz.stu.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author fuxianhui
 * @Description: 班级实体
 * @Date: create in 23:47 2017/8/1
 */
@Entity
@Table(name = "grade_tbl")
public class Grade {
    private Integer id;
    private String className;
    private Set<Student> students;

    public Grade() {
    }

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}
    ,mappedBy = "grade")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
