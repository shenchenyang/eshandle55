package com.plht.eshandle55.controller;

import com.plht.eshandle55.service.EsService;
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
    public EsService esService;

    @PostMapping("index/receive")
    public void indexExpData(@RequestBody String body) throws ParseException {
        esService.indexExpData(body);
    }
    @PostMapping("index/count")
    public void indexCountData(@RequestBody String body) throws ParseException {
        esService.indexCountData(body);
    }
}