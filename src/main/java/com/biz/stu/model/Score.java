package com.biz.stu.model;

import com.biz.stu.model.Student;

import javax.persistence.*;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 0:30 2017/8/2
 */
@Entity
@Table(name = "score_tbl")
public class Score {

    private Integer id;
    //学科名字
    private String subjectName;
    private Integer score = 0;
    private Student student;

    public Score() {
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

    @Column(length = 3)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
