package com.plht.eshandle55.controller;

import com.alibaba.fastjson.JSON;
import com.plht.eshandle55.model.Exp;
import com.plht.eshandle55.model.ExpParams;
import com.plht.eshandle55.service.EsService;
import com.plht.eshandle55.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;

@RestController
@RequestMapping("api")
public class EsController {
    @Resource
    private EsService esService;
    @Resource
    private SearchService searchService;

    @PostMapping("index/receive")
    public void indexExpData(@RequestBody String body)  {
        try {
            esService.indexExpData(body);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @PostMapping("index/count")
    public void indexCountData(@RequestBody String body) {
        try {
            esService.indexCountData(body);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("expData/get")
    public Page<Exp> getExpDataByCondition(@RequestBody String body) {
        Page<Exp> page= null;
        try {
            ExpParams params = JSON.parseObject(body,ExpParams.class);
            page=searchService.getExps(params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return page;
    }
}