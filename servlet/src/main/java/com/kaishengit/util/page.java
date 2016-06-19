package com.kaishengit.util;

import java.util.List;

public class Page<T> {
    private Integer totalSize;
    private Integer pageNo;
    private Integer pageSize;
    private List<T> items;
    private Integer totalPage;
    private Integer start;

    public Page(Integer totalSize, Integer pageNo, Integer pageSize) {
        this.totalSize = totalSize;
        this.pageNo = pageNo;
        this.pageSize = pageSize;

        totalPage = totalSize / pageSize;
        if (totalSize % pageSize != 0) {
            totalPage++;

        }
        if(this.pageNo>totalPage){
            this.pageNo = totalPage;
        }
        start = (this.pageNo - 1) * pageSize;


    }

    public Integer getStart() {
        return start;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
