package com.plht.eshandle55.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "count",type = "count",shards = 5,replicas = 1,refreshInterval = "-1")
public class Count {
    private String SIMCARD_NR;
    @Field
    private Long DATA_TAKING_DATE;
    private String ADMINISTRATION_ZONING;
    @Field
    private String WELL_DBK;
    private String TableName;
    @Id
    private String id;
    private String c_ID;
    private String Supplier;
    private Integer Exp_Sucess_Count;
    private Integer Rec_Count;
    private Integer Exp_Fail_Count;

    public String getC_ID() {
        return c_ID;
    }

    public void setC_ID(String c_ID) {
        this.c_ID = c_ID;
    }

    public String getSIMCARD_NR() {
        return SIMCARD_NR;
    }

    public void setSIMCARD_NR(String SIMCARD_NR) {
        this.SIMCARD_NR = SIMCARD_NR;
    }

    public Long getDATA_TAKING_DATE() {
        return DATA_TAKING_DATE;
    }

    public void setDATA_TAKING_DATE(Long DATA_TAKING_DATE) {
        this.DATA_TAKING_DATE = DATA_TAKING_DATE;
    }

    public String getADMINISTRATION_ZONING() {
        return ADMINISTRATION_ZONING;
    }

    public void setADMINISTRATION_ZONING(String ADMINISTRATION_ZONING) {
        this.ADMINISTRATION_ZONING = ADMINISTRATION_ZONING;
    }

    public String getWELL_DBK() {
        return WELL_DBK;
    }

    public void setWELL_DBK(String WELL_DBK) {
        this.WELL_DBK = WELL_DBK;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public Integer getExp_Sucess_Count() {
        return Exp_Sucess_Count;
    }

    public void setExp_Sucess_Count(Integer exp_Sucess_Count) {
        Exp_Sucess_Count = exp_Sucess_Count;
    }

    public Integer getRec_Count() {
        return Rec_Count;
    }

    public void setRec_Count(Integer rec_Count) {
        Rec_Count = rec_Count;
    }

    public Integer getExp_Fail_Count() {
        return Exp_Fail_Count;
    }

    public void setExp_Fail_Count(Integer exp_Fail_Count) {
        Exp_Fail_Count = exp_Fail_Count;
    }
}
