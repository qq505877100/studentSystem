package com.biz.stu.service.subject;

import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Subject;
import com.biz.stu.service.BaseService;
import com.biz.stu.vo.SelectCourseVo;
import com.biz.stu.vo.SubjectVo;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 13:56 2017/8/2
 */
public interface SubjectService extends BaseService<Subject,Integer> {
   /* public List<Subject> findSelectCourseInfoByStudentId(Integer studentId);*/
    public PageInfo findAllSubjectVoByPaging(PageInfo pageInfo);
    public Integer getSelectedStudentsNumBySubjectId(Integer subjectId);
    public Subject whetherSelectedTheSubjectByStudentAndSubjectId(Integer studentId,Integer subjectId);
    public void unBindingCourse(Integer studentId,Integer subjectId);
    public void selectCourse(Integer studentId,Integer subjectId);
    public PageInfo findAllSelectCourseByStudentIdAndPaging(Integer studentId,PageInfo pageInfo);
}
