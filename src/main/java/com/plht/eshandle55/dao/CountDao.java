package com.plht.eshandle55.dao;

import com.plht.eshandle55.model.Count;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CountDao extends ElasticsearchRepository<Count,String> {
}
