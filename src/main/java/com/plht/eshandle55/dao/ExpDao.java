package com.plht.eshandle55.dao;

import com.plht.eshandle55.model.Exp;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ExpDao extends ElasticsearchRepository<Exp,String> {
}
