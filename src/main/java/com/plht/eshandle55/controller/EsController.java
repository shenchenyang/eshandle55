package com.plht.eshandle55.controller;

import com.alibaba.fastjson.JSON;
import com.plht.eshandle55.model.*;
import com.plht.eshandle55.service.EsService;
import com.plht.eshandle55.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

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
            System.out.println("exp数据入库成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("index/receives")
    public void indexExpDatas(@RequestBody String body)  {
        try {
            List<String> jsonDatas=JSON.parseArray(body,String.class);
            esService.indexExpData(body);
            System.out.println("exp: "+jsonDatas.size()+"数据入库成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("index/counts")
    public void indexCountDatas(@RequestBody String body) {
        try {
            List<String> jsonDatas=JSON.parseArray(body,String.class);
            esService.indexCountDatas(jsonDatas);
            System.out.println("count: "+jsonDatas.size()+"数据入库成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @PostMapping("index/count")
    public void indexCountData(@RequestBody String body) {
        try {
            esService.indexCountData(body);
            System.out.println("count数据入库成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    @PostMapping("rawData/get")
    public List<Raw> getRawDataByCondition(@RequestBody String body) throws ParseException {
        List<Raw> page= null;
        try {
            RawParams params = JSON.parseObject(body,RawParams.class);
            page=searchService.getRaws(params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return page;
    }

    @PostMapping("expData/get")
    public String getExpDataByCondition(@RequestBody String body) {
       String  str= null;
        try {
            ExpParams params = JSON.parseObject(body,ExpParams.class);
            str = JSON.toJSONString(searchService.getExps(params));
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    @PostMapping("countData/date")
    public List<Count> getLastRecCountByDate(@RequestBody String body) throws ParseException {
        List<Count> counts=null;
        CountByDateParams countByDateParams = JSON.parseObject(body,CountByDateParams.class);
        try {
            counts=searchService.getCountByDate(countByDateParams);
        }catch (Exception e){
            e.printStackTrace();
        }
        return counts;
    }

    @PostMapping("countData/area")
    public com.plht.eshandle55.model.Page getAreaRecCountByDate(@RequestBody String body) throws ParseException {
        com.plht.eshandle55.model.Page counts=null;
        CountByArea countByArea = JSON.parseObject(body,CountByArea.class);
        try {
            counts=searchService.getCountByArea(countByArea);
        }catch (Exception e){
            e.printStackTrace();
        }
        return counts;
    }
}