package com.plht.eshandle55.model;

import java.util.List;

public class ReceiveData {
    private String Well_DBK;
    private String SIMCARD_NR;
    private String Supplier;
    private String ADMINISTRATION_ZONING;
    private String WATERSHED_ZONING;
    private String HYDROGEOLOGY_ZONING;
    private String GROUNDWATER_TYPE;
    private String MONITOR_APPARATUS_NR;
    private String MONITOR_APPARATUS_CLASS;
    private String Monitor_Layer;
    private String STATION_NR;
    private String DEVICE_CLASS;
    private String RECEIVE_DATE;
    private String RECEIVE_CONTENT;
    private String RESULT_CONTENT;
    private List<TypeData> DataList;
    private String PORT;

    public String getWell_DBK() {
        return Well_DBK;
    }

    public void setWell_DBK(String well_DBK) {
        Well_DBK = well_DBK;
    }

    public String getSIMCARD_NR() {
        return SIMCARD_NR;
    }

    public void setSIMCARD_NR(String SIMCARD_NR) {
        this.SIMCARD_NR = SIMCARD_NR;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String getADMINISTRATION_ZONING() {
        return ADMINISTRATION_ZONING;
    }

    public void setADMINISTRATION_ZONING(String ADMINISTRATION_ZONING) {
        this.ADMINISTRATION_ZONING = ADMINISTRATION_ZONING;
    }

    public String getWATERSHED_ZONING() {
        return WATERSHED_ZONING;
    }

    public void setWATERSHED_ZONING(String WATERSHED_ZONING) {
        this.WATERSHED_ZONING = WATERSHED_ZONING;
    }

    public String getHYDROGEOLOGY_ZONING() {
        return HYDROGEOLOGY_ZONING;
    }

    public void setHYDROGEOLOGY_ZONING(String HYDROGEOLOGY_ZONING) {
        this.HYDROGEOLOGY_ZONING = HYDROGEOLOGY_ZONING;
    }

    public String getGROUNDWATER_TYPE() {
        return GROUNDWATER_TYPE;
    }

    public void setGROUNDWATER_TYPE(String GROUNDWATER_TYPE) {
        this.GROUNDWATER_TYPE = GROUNDWATER_TYPE;
    }

    public String getMONITOR_APPARATUS_NR() {
        return MONITOR_APPARATUS_NR;
    }

    public void setMONITOR_APPARATUS_NR(String MONITOR_APPARATUS_NR) {
        this.MONITOR_APPARATUS_NR = MONITOR_APPARATUS_NR;
    }

    public String getMONITOR_APPARATUS_CLASS() {
        return MONITOR_APPARATUS_CLASS;
    }

    public void setMONITOR_APPARATUS_CLASS(String MONITOR_APPARATUS_CLASS) {
        this.MONITOR_APPARATUS_CLASS = MONITOR_APPARATUS_CLASS;
    }

    public String getMonitor_Layer() {
        return Monitor_Layer;
    }

    public void setMonitor_Layer(String monitor_Layer) {
        Monitor_Layer = monitor_Layer;
    }

    public String getSTATION_NR() {
        return STATION_NR;
    }

    public void setSTATION_NR(String STATION_NR) {
        this.STATION_NR = STATION_NR;
    }

    public String getDEVICE_CLASS() {
        return DEVICE_CLASS;
    }

    public void setDEVICE_CLASS(String DEVICE_CLASS) {
        this.DEVICE_CLASS = DEVICE_CLASS;
    }

    public String getRECEIVE_DATE() {
        return RECEIVE_DATE;
    }

    public void setRECEIVE_DATE(String RECEIVE_DATE) {
        this.RECEIVE_DATE = RECEIVE_DATE;
    }

    public String getRECEIVE_CONTENT() {
        return RECEIVE_CONTENT;
    }

    public void setRECEIVE_CONTENT(String RECEIVE_CONTENT) {
        this.RECEIVE_CONTENT = RECEIVE_CONTENT;
    }

    public String getRESULT_CONTENT() {
        return RESULT_CONTENT;
    }

    public void setRESULT_CONTENT(String RESULT_CONTENT) {
        this.RESULT_CONTENT = RESULT_CONTENT;
    }

    public List<TypeData> getDataList() {
        return DataList;
    }

    public void setDataList(List<TypeData> dataList) {
        DataList = dataList;
    }

    public String getPORT() {
        return PORT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }
}
