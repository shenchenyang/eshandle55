package com.plht.eshandle55.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "raw",type = "raw",shards = 5,replicas = 1,refreshInterval = "-1")
public class Raw {
    @Id
    private String id;
    private String wellDbK;
    private String simcardNr;
    private String supplier;
    private Long receiveDate;
    private String RECEIVE_CONTENT;
    private String ADMINISTRATION_ZONING;
    private String HYDROGEOLOGY_ZONING;
    private String WATERSHED_ZONING;

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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Long receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRECEIVE_CONTENT() {
        return RECEIVE_CONTENT;
    }

    public void setRECEIVE_CONTENT(String RECEIVE_CONTENT) {
        this.RECEIVE_CONTENT = RECEIVE_CONTENT;
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
}
