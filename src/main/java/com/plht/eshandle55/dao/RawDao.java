package com.plht.eshandle55.dao;

import com.plht.eshandle55.model.Raw;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RawDao extends ElasticsearchRepository<Raw,String> {
}
