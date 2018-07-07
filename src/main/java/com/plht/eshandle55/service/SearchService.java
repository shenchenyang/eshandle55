package com.plht.eshandle55.service;


import com.alibaba.fastjson.JSON;
import com.plht.eshandle55.dao.ExpDao;
import com.plht.eshandle55.model.Exp;
import com.plht.eshandle55.model.ExpParams;
import com.plht.eshandle55.model.TypeData;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SearchService {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @Resource
    private ExpDao expDao;

    public Page<Exp> getExps(ExpParams expParams) throws ParseException {
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
        BoolQueryBuilder boolQueryBuilder =QueryBuilders.boolQuery();
        boolQueryBuilder.must(timeRange);
        if (!code.equals("0")){
            PrefixQueryBuilder codeMatch = QueryBuilders.prefixQuery("aDMINISTRATION_ZONING", handleCode(code));
            boolQueryBuilder.must(codeMatch);
        }

        if (!StringUtils.isEmpty(SelType)){
            WildcardQueryBuilder queryParam = QueryBuilders
                    .wildcardQuery(SelType, SelNeirong);
            boolQueryBuilder.must(queryParam);
        }
        qb2=boolQueryBuilder;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(qb2);
        System.out.println(sourceBuilder.toString());

        Page<Exp> exps = expDao.search(qb2,new PageRequest(expParams.getPageIndex()-1,expParams.getPageSize()));

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
        return exps;
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

}
