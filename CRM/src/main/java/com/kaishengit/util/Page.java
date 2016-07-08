package com.kaishengit.util;

import java.util.List;

public class Page<T> {

    private Integer pageNo;
    private Integer totalPage;
    private Integer pageSize;
    private Integer totalSize;
    private Integer start;
    private List<T> items;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Page(Integer pageNo, Integer pageSize, Integer totalSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalSize = totalSize;

        totalPage = totalSize / pageSize;
        if(totalSize % pageSize != 0){
            totalPage++;
        }

        if(pageNo > totalPage){
            this.pageNo = totalPage;
        }
        if(this.pageNo<=0){
            this.pageNo = 1;
        }
        start = (this.pageNo - 1)*pageSize;



    }
}
