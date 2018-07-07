package com.plht.eshandle55.model;

public class ExpParams {
    private Integer pageIndex;
    private Integer pageSize;
    private String StartTime;
    private String EndTime;
    private String code;
    private String SelType;
    private String SelNeirong;
    private String DataType;
    private Boolean isChart;

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

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
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

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public Boolean getChart() {
        return isChart;
    }

    public void setChart(Boolean chart) {
        isChart = chart;
    }
}
