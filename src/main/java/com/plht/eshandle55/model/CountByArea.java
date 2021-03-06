package com.plht.eshandle55.model;

public class CountByArea {
    private Integer pageIndex;
    private Integer pageSize;
    private String start;
    private String end;
    private String code;
    private String SelType;
    private String SelNeirong;
    private String WellDbk;
    private Boolean isChart;
    private String Supplier;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSelType() {
        return SelType;
    }

    public void setSelType(String selType) {
        SelType = selType;
    }

    public String getSelNeirong() {
        return SelNeirong;
    }

    public void setSelNeirong(String selNeirong) {
        SelNeirong = selNeirong;
    }

    public String getWellDbk() {
        return WellDbk;
    }

    public void setWellDbk(String wellDbk) {
        WellDbk = wellDbk;
    }

    public Boolean getChart() {
        return isChart;
    }

    public void setChart(Boolean chart) {
        isChart = chart;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }
}
