package com.kaishengit.util;

import java.util.List;

public class Page<T> {
    private Integer totalSize;
    private Integer totalPages;
    private Integer pageSize;
    private Integer pageNo;
    private List<T> items;
    private Integer start;

    public Page(Integer totalSize, Integer pageSize, Integer pageNo) {
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.pageNo = pageNo;

        totalPages = totalSize / pageSize;
        if (totalSize % pageSize != 0) {
            totalPages++;

        }
        if (pageNo > totalPages) {
            this.pageNo = totalPages;
        }
        if(pageNo <= 0){

            this.pageNo = 1;
        }
        start = (this.pageNo - 1) * pageSize;


    }

    public Integer getStart() {
        return start;
    }

    public Integer getTotalSize() {
        return totalSize;
    }


    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
