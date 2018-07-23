package com.plht.eshandle55.service;


import com.alibaba.fastjson.JSON;
import com.plht.eshandle55.dao.CountDao;
import com.plht.eshandle55.dao.ExpDao;
import com.plht.eshandle55.dao.RawDao;
import com.plht.eshandle55.model.*;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.tophits.TopHits;
import org.elasticsearch.search.aggregations.metrics.tophits.TopHitsAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.PipelineAggregatorBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Service
public class SearchService {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @Resource
    private ExpDao expDao;
    @Resource
    private RawDao rawDao;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Resource
    private CountDao countDao;

    public List<Exp> getExps(ExpParams expParams) throws ParseException {
        Date start = sdf.parse(expParams.getStartTime());
        Date end = sdf.parse(expParams.getEndTime());
        String code = expParams.getCode();
        String dataType = expParams.getDataType();
        String SelType = formtString(expParams.getSelType());
        String SelNeirong = expParams.getSelNeirong();
        Boolean isChart = expParams.getChart();

        String types[] = null;
        if (dataType != null) {
            if (dataType.contains(",")) {
                types = dataType.split(",");
            } else {
                String[] a = {dataType};
                types = a;
            }
        }

        RangeQueryBuilder timeRange = QueryBuilders
                .rangeQuery("dataTakingDate").from(start.getTime()).to(end.getTime());
        QueryBuilder qb2 = null;
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(timeRange);
        if (!code.equals("0")) {
            PrefixQueryBuilder codeMatch = QueryBuilders.prefixQuery("aDMINISTRATION_ZONING", handleCode(code));
            boolQueryBuilder.must(codeMatch);
        }

        if (!StringUtils.isEmpty(SelType)) {
            WildcardQueryBuilder queryParam = QueryBuilders
                    .wildcardQuery(SelType, SelNeirong);
            boolQueryBuilder.must(queryParam);
        }
        qb2 = boolQueryBuilder;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(qb2);
        Page<Exp> exps = expDao.search(qb2, new PageRequest(expParams.getPageIndex() - 1, expParams.getPageSize()));

        List<Exp> expDatas = exps.getContent();

        if (dataType != null && !dataType.equals("")) {
            for (Exp data : expDatas) {
                List<TypeData> typeDatas = new ArrayList<>();
                for (TypeData typeData : data.getValues()) {
                    for (String type : types) {
                        if (typeData.getDataType().equals(type)) {
                            typeDatas.add(typeData);
                        }
                    }
                }
                data.setValues(typeDatas);
            }
        }
        return exps.getContent();
    }


    public List<Raw> getRaws(RawParams params) throws ParseException {
        Date start = sdf.parse(params.getStartTime());
        Date end = sdf.parse(params.getEndTime());
        String code = params.getCode();
        String SelType = formtString(params.getSelType());
        String SelNeirong = params.getSelNeirong();
        QueryBuilder qb2 = null;
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();


        RangeQueryBuilder timeRange = QueryBuilders
                .rangeQuery("receiveDate").from(start.getTime()).to(end.getTime());
        boolQueryBuilder.must(timeRange);
        if (!code.equals("0")) {
            PrefixQueryBuilder codeMatch = QueryBuilders.prefixQuery("aDMINISTRATION_ZONING", handleCode(code));
            boolQueryBuilder.must(codeMatch);
        }

        if (!org.springframework.util.StringUtils.isEmpty(SelType)) {
            WildcardQueryBuilder queryParam = QueryBuilders
                    .wildcardQuery(SelType, SelNeirong);
            boolQueryBuilder.must(queryParam);
        }

        qb2 = boolQueryBuilder;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(qb2);
        Page<Raw> raws = rawDao.search(qb2, new PageRequest(params.getPageIndex() - 1, params.getPageSize()));

        return raws.getContent();
    }

    public com.plht.eshandle55.model.Page getCountByArea(CountByArea params) throws ParseException {
        Date start = sdf.parse(params.getStart());
        Date end =sdf.parse(params.getEnd());
        String code = params.getCode();
        String SelType = formtString2(params.getSelType());
        String SelNeirong = params.getSelNeirong();
        String WellDbk = params.getWellDbk();
        String Supplier = params.getSupplier();
        QueryBuilder qb2 = null;

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        RangeQueryBuilder timeRange = QueryBuilders.rangeQuery("data_TAKING_DATE").from(start.getTime()).to(end.getTime());
        if (!StringUtils.isEmpty(Supplier)) {
            for (String str : Supplier.split("")) {
                WildcardQueryBuilder sup = QueryBuilders.wildcardQuery("supplier", str);
                boolQueryBuilder.must(sup);
            }
        }
        boolQueryBuilder.must(timeRange);
        if (!code.equals("0")) {
            PrefixQueryBuilder codeMatch = QueryBuilders.prefixQuery("aDMINISTRATION_ZONING", handleCode(code));
            boolQueryBuilder.must(codeMatch);
        }
        if (!StringUtils.isEmpty(WellDbk)) {
            TermQueryBuilder termQuery = QueryBuilders.termQuery("well_DBK", WellDbk);
            boolQueryBuilder.must(termQuery);
        }
        if (!StringUtils.isEmpty(SelType)) {
            WildcardQueryBuilder queryParam = QueryBuilders
                    .wildcardQuery(SelType, SelNeirong);
            boolQueryBuilder.must(queryParam);
        }
        qb2 = boolQueryBuilder;
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_by").field("well_DBK").size(100000);

        TopHitsAggregationBuilder topHitsAggregationBuilder = AggregationBuilders.topHits("top").sort("data_TAKING_DATE", SortOrder.DESC).size(getSize(start.getTime(),end.getTime()));
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(qb2)
                .withIndices("count")
                .withTypes("count")
                .addAggregation(termsAggregationBuilder
                        .subAggregation(topHitsAggregationBuilder)).build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse searchResponse) {
                return searchResponse.getAggregations();
            }
        });
        Terms terms = aggregations.get("group_by");
        List<Count> countDatas = new ArrayList<>();
        for (Terms.Bucket bucket : terms.getBuckets()) {
            TopHits tops = bucket.getAggregations().get("top");
            for (SearchHit hit : tops.getHits().getHits()) {
                Count countData = JSON.parseObject(hit.getSourceAsString(), Count.class);
                countDatas.add(countData);
            }
        }
        return pageUil2(countDatas,params.getPageIndex(),params.getPageSize());
    }

    public List<Count> getCountByDate(CountByDateParams params) throws ParseException {
        Date time = sdf.parse(params.getTime());
        String code = params.getCode();
        String SelType = formtString2(params.getSelType());
        String SelNeirong = params.getSelNeirong();
        String WellDbk = params.getWellDbk();
        String Supplier = params.getSupplier();
        QueryBuilder qb2 = null;

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        RangeQueryBuilder timeRange = QueryBuilders.rangeQuery("data_TAKING_DATE").from(0).to(time.getTime());
        if (!StringUtils.isEmpty(Supplier)) {
            for (String str : Supplier.split("")) {
                WildcardQueryBuilder sup = QueryBuilders.wildcardQuery("supplier", str);
                boolQueryBuilder.must(sup);
            }
        }
        boolQueryBuilder.must(timeRange);
        if (!code.equals("0")) {
            PrefixQueryBuilder codeMatch = QueryBuilders.prefixQuery("aDMINISTRATION_ZONING", handleCode(code));
            boolQueryBuilder.must(codeMatch);
        }
        if (!StringUtils.isEmpty(WellDbk)) {
            TermQueryBuilder termQuery = QueryBuilders.termQuery("well_DBK", WellDbk);
            boolQueryBuilder.must(termQuery);
        }
        if (!StringUtils.isEmpty(SelType)) {
            WildcardQueryBuilder queryParam = QueryBuilders
                    .wildcardQuery(SelType, SelNeirong);
            boolQueryBuilder.must(queryParam);
        }
        qb2 = boolQueryBuilder;
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_by").field("well_DBK").size(100000);
        TopHitsAggregationBuilder topHitsAggregationBuilder = AggregationBuilders.topHits("top").sort("data_TAKING_DATE", SortOrder.DESC).size(1);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(qb2)
                .withIndices("count")
                .withTypes("count")
                .addAggregation(termsAggregationBuilder
                        .subAggregation(topHitsAggregationBuilder)).build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse searchResponse) {
                return searchResponse.getAggregations();
            }
        });
        Terms terms = aggregations.get("group_by");
        List<Count> countDatas = new ArrayList<>();
        for (Terms.Bucket bucket : terms.getBuckets()) {
            TopHits tops = bucket.getAggregations().get("top");
            for (SearchHit hit : tops.getHits().getHits()) {
                Count countData = JSON.parseObject(hit.getSourceAsString(), Count.class);
                countDatas.add(countData);
            }
        }
        return pageUtil(countDatas,params.getPageIndex(),params.getPageSize());
    }


    public String handleCode(String code) {
        String pre = code.substring(0, 2);
        return pre;
    }

    private String formtString(String var) {
        if (var == null) {
            return null;
        }
        if (var.equals("统一编号")) {
            return "wellDbK";
        }
        if (var.equals("物联卡号")) {
            return "simcardNr";
        }
        if (var.equals("供应厂商")) {
            return "supplier";
        }
        if (var.equals("地理位置")) {
            return "aDMINISTRATION_ZONING";
        }
        return null;
    }

    public String formtString2(String var) {
        if (var == null) {
            return null;
        }
        if (var.equals("统一编号")) {
            return "wELL_DBK";
        }
        if (var.equals("物联卡号")) {
            return "sIMCARD_NR";
        }
        if (var.equals("供应厂商")) {
            return "supplier";
        }
        if (var.equals("地理位置")) {
            return "aDMINISTRATION_ZONING";
        }
        return null;
    }
    private com.plht.eshandle55.model.Page pageUil2 (List list,Integer index,Integer pageSize){
        com.plht.eshandle55.model.Page page = new com.plht.eshandle55.model.Page();
        page.setCurrPage(index);
        page.setPageSize(pageSize);

        List newList = new LinkedList();
        Integer start=(index-1)*pageSize;
        Integer end =(start+pageSize);
        end=end>list.size()?list.size():end;
        if (!(list.size()<=0 )&&!(list.size()<start)) {
            newList.addAll(list.subList(start,end));
        }
        page.setObjects(newList);
        page.setTotal(list.size());
        return page;
    }
    private List pageUtil(List list,Integer index,Integer pageSize){
        List newList = new LinkedList();
        Integer start=(index-1)*pageSize;
        Integer end =(start+pageSize);
        end=end>list.size()?list.size():end;
        if (!(list.size()<=0 )&&!(list.size()<start)) {
            newList.addAll(list.subList(start,end));
        }
        return newList;
    }

    public int getSize(long start,long end){
        int a = (int) (end-start) / (1000*3600*24);
        return a*100;
    }


}
