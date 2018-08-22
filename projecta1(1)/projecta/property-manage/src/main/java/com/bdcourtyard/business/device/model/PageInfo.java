package com.bdcourtyard.business.device.model;

import java.util.List;

/**
 * Created by zaz on 2018/7/13.
 */
public class PageInfo<T> {

    private Long total;
    private List<T> rows;
    private int page;
    private int pageSize;

    public PageInfo() {
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}


