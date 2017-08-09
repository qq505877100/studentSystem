package com.biz.stu.service;

import com.biz.stu.model.PageInfo;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 14:03 2017/8/2
 */
public interface BaseService<T,ID extends Serializable> {
    public T save(T t);
    public T update(T t);
    public Iterable<T> save(Iterable<T> var1);
    public void delete(ID id);
    public void deleteAll();
    public T findOne(ID id);
    public List<T> findAll();
    public Page findByPaging(PageInfo pageInfo);
}
