package com.kaishengit.dto;

import java.util.List;

public class DataTableResult<T> {

    private String draw;
    private List<T> data;
    private Long recodesTotle;
    private Long recodesFiltered;

    public DataTableResult(String draw, List<T> data, Long recodesTotle, Long recodesFiltered) {
        this.draw = draw;
        this.data = data;
        this.recodesTotle = recodesTotle;
        this.recodesFiltered = recodesFiltered;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getRecodesTotle() {
        return recodesTotle;
    }

    public void setRecodesTotle(Long recodesTotle) {
        this.recodesTotle = recodesTotle;
    }

    public Long getRecodesFiltered() {
        return recodesFiltered;
    }

    public void setRecodesFiltered(Long recodesFiltered) {
        this.recodesFiltered = recodesFiltered;
    }
}
