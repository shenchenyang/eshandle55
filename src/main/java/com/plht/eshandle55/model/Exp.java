package com.plht.eshandle55.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(indexName = "exp",type = "exp",shards = 5,replicas = 1,refreshInterval = "-1")
public class Exp {
    @Id
    private String id;
    @Field
    private String wellDbK;
    private String simcardNr;
    @Field
    private Long dataTakingDate;
    @Field
    private Long receiveDate;
    @Field
    private String ADMINISTRATION_ZONING;
    @Field
    private String HYDROGEOLOGY_ZONING;
    @Field
    private String WATERSHED_ZONING;
    private String supplier;
    private List<TypeData> values=new ArrayList();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWellDbK() {
        return wellDbK;
    }

    public void setWellDbK(String wellDbK) {
        this.wellDbK = wellDbK;
    }

    public String getSimcardNr() {
        return simcardNr;
    }

    public void setSimcardNr(String simcardNr) {
        this.simcardNr = simcardNr;
    }

    public Long getDataTakingDate() {
        return dataTakingDate;
    }

    public void setDataTakingDate(Long dataTakingDate) {
        this.dataTakingDate = dataTakingDate;
    }

    public Long getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Long receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getADMINISTRATION_ZONING() {
        return ADMINISTRATION_ZONING;
    }

    public void setADMINISTRATION_ZONING(String ADMINISTRATION_ZONING) {
        this.ADMINISTRATION_ZONING = ADMINISTRATION_ZONING;
    }

    public String getHYDROGEOLOGY_ZONING() {
        return HYDROGEOLOGY_ZONING;
    }

    public void setHYDROGEOLOGY_ZONING(String HYDROGEOLOGY_ZONING) {
        this.HYDROGEOLOGY_ZONING = HYDROGEOLOGY_ZONING;
    }

    public String getWATERSHED_ZONING() {
        return WATERSHED_ZONING;
    }

    public void setWATERSHED_ZONING(String WATERSHED_ZONING) {
        this.WATERSHED_ZONING = WATERSHED_ZONING;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public List<TypeData> getValues() {
        return values;
    }

    public void setValues(List<TypeData> values) {
        this.values = values;
    }
}
