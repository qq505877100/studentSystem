package com.biz.stu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "student_tbl")
//这里不解析这三个属性，避免无限解析jackson
@JsonIgnoreProperties({"subjects","grade","scores"})
public class Student {
    private Integer id;
    private String studentName;
    //学号
    private String studentNum;
    //照片存储的是服务器上的地址值
    private String picture;
    //0代表女，1代表男
    private Integer gender ;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;
    private Set<Score> scores;
    @JsonIgnore
    private Grade grade;
    private Set<Subject> subjects;

    public Student() {
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_subject",
            joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id",referencedColumnName = "id")})
    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "grade_id")
    @JsonBackReference
    public Grade getGrade() {
        return grade;
    }

    @JsonBackReference
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "student")
    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
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
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Column(length = 18)
    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    @Column(length = 64)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(length = 1)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column()
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
