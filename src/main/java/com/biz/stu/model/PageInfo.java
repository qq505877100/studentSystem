package com.biz.stu.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 1:05 2017/8/1
 */
public class PageInfo {
    private Integer pageSize;
    private Integer page;
    private Integer totalPages;
    private Long totalElements;
    private List rows;

    public PageInfo() {
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
