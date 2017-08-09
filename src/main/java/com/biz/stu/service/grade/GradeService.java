package com.biz.stu.service.grade;

import com.biz.stu.model.Grade;
import com.biz.stu.model.PageInfo;
import com.biz.stu.model.Student;
import com.biz.stu.service.BaseService;
import com.biz.stu.vo.GradeVo;

import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 13:57 2017/8/2
 */
public interface GradeService extends BaseService<Grade,Integer>{
    public List<GradeVo> findAllVo();
    public PageInfo findAllGradeVoByPaging(PageInfo pageInfo);
    public boolean existsByClassName(String className);

}
