package com.plht.eshandle55.model;

import com.alibaba.fastjson.annotation.JSONField;

public class TypeData {
    @JSONField(ordinal = 0)
    private String DataType;
    @JSONField(ordinal = 2)
    private String DATA_TAKING_DATE;
    @JSONField(ordinal = 1)
    private String  Value;

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public String getDATA_TAKING_DATE() {
        return DATA_TAKING_DATE;
    }

    public void setDATA_TAKING_DATE(String DATA_TAKING_DATE) {
        this.DATA_TAKING_DATE = DATA_TAKING_DATE;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
