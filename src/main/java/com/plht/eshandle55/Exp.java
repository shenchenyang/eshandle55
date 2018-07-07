package com.plht.eshandle55;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "exp",type = "exp",shards = 5,replicas = 1,refreshInterval = "-1")
public class Exp implements Serializable {
    private static final long serialVersionUID = 551589397625941750L;
    @Id
    private Long id;
    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Exp{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
