package com.plht.eshandle55;

import com.plht.eshandle55.model.CountByDateParams;
import com.plht.eshandle55.model.ExpParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;


public class Eshandle55ApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();



    @Test
    public void testIndexExp(){
        String s = "{\"Well_DBK\":\"331004210028\",\"SIMCARD_NR\":\"331004210011\",\"Supplier\":\"九恒水环\",\"ADMINISTRATION_ZONING\":\"331004\",\"WATERSHED_ZONING\":\"210000\",\"HYDROGEOLOGY_ZONING\":\"260000\",\"GROUNDWATER_TYPE\":\"2101\",\"MONITOR_APPARATUS_NR\":\"AM1611827\",\"MONITOR_APPARATUS_CLASS\":\"ZKGD2000-MD\",\"Monitor_Layer\":\"0\",\"STATION_NR\":\"GB1611798\",\"DEVICE_CLASS\":\"ZKGD2000-MB\",\"RECEIVE_DATE\":\"2018/5/5 19:18:59\",\"RECEIVE_CONTENT\":\"7E 7E 16 33 10 04 21 00 11 0C 50 32 02 2E 02 01 F4 18 05 05 08 00 44 F1 F1 33 10 04 21 00 11 47 18 05 04 09 00 01 79 43 01 95 01 00 02 24 45 01 03 95 01 86 06 19 18 05 04 10 00 01 79 45 01 95 01 00 02 24 41 01 03 93 01 87 06 19 18 05 04 11 00 01 79 45 01 95 01 00 02 24 37 01 03 89 01 89 06 19 18 05 04 12 00 01 79 43 01 95 01 00 02 24 33 01 03 83 01 92 06 19 18 05 04 13 00 01 79 43 01 95 01 00 02 24 29 01 03 79 01 95 06 19 18 05 04 14 00 01 79 40 01 95 01 00 02 24 27 01 03 74 01 97 06 19 18 05 04 15 00 01 79 40 01 95 01 00 02 24 22 01 03 69 01 99 06 19 18 05 04 16 00 01 79 38 01 95 01 00 02 24 23 01 03 68 02 00 06 19 18 05 04 17 00 01 79 38 01 95 01 00 02 24 26 01 03 71 02 02 06 19 18 05 04 18 00 01 79 38 01 95 01 00 02 24 27 01 03 72 02 02 06 19 18 05 04 19 00 01 79 39 01 95 01 00 02 24 29 01 03 75 02 03 06 19 18 05 04 20 00 01 79 40 01 95 01 00 02 24 34 01 03 81 02 03 06 19 18 05 04 21 00 01 79 41 01 95 01 00 02 24 33 01 03 81 02 04 06 19 18 05 04 22 00 01 79 43 01 95 01 00 02 24 31 01 03 81 02 04 06 19 18 05 04 23 00 01 79 42 01 95 01 00 02 24 29 01 03 78 02 04 06 19 18 05 05 00 00 01 79 43 01 95 01 00 02 24 25 01 03 75 02 04 06 19 18 05 05 01 00 01 79 40 01 95 01 00 02 24 19 01 03 66 02 05 06 19 18 05 05 02 00 01 79 39 01 95 01 00 02 24 17 01 03 63 02 05 06 19 18 05 05 03 00 01 79 38 01 95 01 00 02 24 18 01 03 63 02 05 06 19 18 05 05 04 00 01 79 37 01 95 01 00 02 24 20 01 03 64 02 04 06 19 18 05 05 05 00 01 79 34 01 95 01 00 02 24 20 01 03 61 02 03 06 19 18 05 05 06 00 01 79 35 01 95 01 00 02 24 25 01 03 67 02 03 06 19 18 05 05 07 00 01 79 35 01 95 01 00 02 24 29 01 03 7 1 02 02 06 19 18 05 05 08 00 01 79 36 01 95 01 00 02 24 30 01 03 73 02 02 06 19 38 12 05 99 7A 10 00 96 FF 66 11 02 02 17 65 CC\",\"RESULT_CONTENT\":\"解析结果:上/下行:上行, 中心站地址:16, 遥测站地址:331004210011, 通信密码:0C50, 功能码:32,长度:576,流水号:01F4,发报时间:2018-5-5 8:00:44,遥测站地址:331004210011,\\r\\n数据监测内容：\\r\\n观测时间:2018-5-4 9:00:00;水位埋深:17.943;水温:19.5;水位传感器电量:100;探头压力:22.445;大气压:10.395;气温:18.6;数传电压:6.19;\\r\\n观测时间:2018-5-4 10:00:00;水位埋深:17.945;水温:19.5;水位传感器电量:100;探头压力:22.441;大气压:10.393;气温:18.7;数传电压:6.19;\\r\\n观测时间:2018-5-4 11:00:00;水位埋深:17.945;水温:19.5;水位传感器电量:100;探头压力:22.437;大气压:10.389;气温:18.9;数传电压:6.19;\\r\\n观测时间:2018-5-4 12:00:00;水位埋深:17.943;水温:19.5;水位传感器电量:100;探头压力:22.433;大气压:10.383;气温:19.2;数传电压:6.19;\\r\\n观测时间:2018-5-4 13:00:00;水位埋深:17.943;水温:19.5;水位传感器电量:100;探头压力:22.429;大气压:10.379;气温:19.5;数传电压:6.19;\\r\\n观测时间:2018-5-4 14:00:00;水位埋深:17.94;水温:19.5;水位传感器电量:100;探头压力:22.427;大气压:10.374;气温:19.7;数传电压:6.19;\\r\\n观测时间:2018-5-4 15:00:00;水位埋深:17.94;水温:19.5;水位传感器电量:100;探头压力:22.422;大气压:10.369;气温:19.9;数传电压:6.19;\\r\\n观测时间:2018-5-4 16:00:00;水位 埋深:17.938;水温:19.5;水位传感器电量:100;探头压力:22.423;大气压:10.368;气温:20;数传电压:6.19;\\r\\n观测时间:2018-5-4 17:00:00;水位埋深:17.938;水温:19.5;水位传感器电量:100;探头压力:22.426;大气压:10.371;气温:20.2;数传电压:6.19;\\r\\n观测时间:2018-5-4 18:00:00;水位埋深:17.938;水温:19.5;水位传感器电量:100;探头压力:22.427;大气压:10.372;气温:20.2;数传电压:6.19;\\r\\n观测时间:2018-5-4 19:00:00;水位埋深:17.939;水温:19.5;水位传感器电量:100;探头压力:22.429;大气压:10.375;气温:20.3;数传电压:6.19;\\r\\n观测时间:2018-5-4 20:00:00;水位埋深:17.94;水温:19.5;水位传感器电量:100;探头压力:22.434;大气压:10.381;气温:20.3;数传电压:6.19;\\r\\n观测时间:2018-5-4 21:00:00;水位埋深:17.941;水温:19.5;水位传感器电量:100;探头压力:22.433;大气压:10.381;气温:20.4;数传电压:6.19;\\r\\n观测时间:2018-5-4 22:00:00;水位埋深:17.943;水温:19.5;水位传感器电量:100;探头压力:22.431;大气压:10.381;气温:20.4;数传电压:6.19;\\r\\n观测时间:2018-5-4 23:00:00;水位埋深:17.942;水温:19.5;水位传感器电量:100;探头压力:22.429;大气压:10.378;气温:20.4;数传电压:6.19;\\r\\n观测时间:2018-5-5 0:00:00;水位埋深:17.943;水温:19.5;水位传感器电量:100;探头压力:22.425;大气压:10.375;气温:20.4;数传电压:6.19;\\r\\n观测时间:2018-5-5 1:00:00;水位埋深:17.94;水温:19.5;水位传感器电量:100;探头压力:22.419;大气压:10.366;气温:20.5;数传电压:6.19;\\r\\n观测时间:2018-5-5 2:00:00;水位埋深:17.939;水温 :19.5;水位传感器电量:100;探头压力:22.417;大气压:10.363;气温:20.5;数传电压:6.19;\\r\\n观测时间:2018-5-5 3:00:00;水位埋深:17.938;水温:19.5;水位传感器电量:100;探头压力:22.418;大气压:10.363;气温:20.5;数传电压:6.19;\\r\\n观测时间:2018-5-5 4:00:00;水位埋深:17.937;水温:19.5;水位传感器电量:100;探头压力:22.42;大气压:10.364;气温:20.4;数传电压:6.19;\\r\\n观测时间:2018-5-5 5:00:00;水位埋深:17.934;水温:19.5;水位传感器电量:100;探头压力:22.42;大气压:10.361;气温:20.3;数传电压:6.19;\\r\\n观测时间:2018-5-5 6:00:00;水位埋深:17.935;水温:19.5;水位传感器电量:100;探头压力:22.425;大气压:10.367;气温:20.3;数传电压:6.19;\\r\\n观测时间:2018-5-5 7:00:00;水位埋深:17.935;水温:19.5;水位传感器电量:100;探头压力:22.429;大气压:10.371;气温:20.2;数传电压:6.19;\\r\\n观测时间:2018-5-5 8:00:00;水位埋深:17.936;水温:19.5;水位传感器电量:100;探头压力:22.43;大气压:10.373;气温:20.2;数传电压:6.19;\\r\\n,电压:5.99,信号质量百分比:96,数传气温:20.2,帧结束符:17,CS校验:65CC\\r\\n服务器：192.168.31.106发送:\\r\\n回复帧：\\r\\n7E7E331004210011160C503280080201F418050519185906DFA1\\r\\n状态:正常\",\"DataList\":[{\"DataType\":\"11\",\"DATA_TAKING_DATE\":\"2018/5/5 8:00:00\",\"Value\":96.0},{\"DataType\":\"1\",\"DATA_TAKING_DATE\":\"2018/5/5 8:00:00\",\"Value\":96.0},{\"DataType\":\"2\",\"DATA_TAKING_DATE\":\"2018/5/5 8:00:00\",\"Value\":96.0},{\"DataType\":\"3\",\"DATA_TAKING_DATE\":\"2018/5/5 8:00:00\",\"Value\":96.0},{\"DataType\":\"4\",\"DATA_TAKING_DATE\":\"2018/5/2 8:00:00\",\"Value\":96.0},{\"DataType\":\"5\",\"DATA_TAKING_DATE\":\"2018/5/2 8:00:00\",\"Value\":96.0}],\"PORT\":\"2021\",\"REMARK\":\"\"}";
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity entity = new HttpEntity(s);
        ResponseEntity<String> response=restTemplate.exchange("http://172.101.0.73:8080/api/index/receive", HttpMethod.POST,entity,String.class);
    }

    @Test
    public void testIndexCount(){
        String str ="{\"SIMCARD_NR\":\"331004210011\",\"DATA_TAKING_DATE\":\"2017/5/4 9:00:00\",\"Exp_Sucess_Count\":1,\"ADMINISTRATION_ZONING\":\"331004\",\"WELL_DBK\":\"331004210011\",\"Rec_Count\":1,\"TableName\":\"TB_Rec_Count\",\"ID\":\"0e9a7dd7-ea6f-49c1-a33d-12f084de6ac9\",\"Supplier\":\"九恒水环\",\"Exp_Fail_Count\":0}";
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity entity = new HttpEntity(str);
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8081/api/index/count", HttpMethod.POST,entity,String.class);
    }

    @Test
    public void testSearchExp(){
        ExpParams params = new ExpParams();
        params.setPageIndex(1);
        params.setPageSize(10);
//        params.setSelType("统一编号");
//        params.setSelNeirong("650109211310");
        params.setStartTime("2016/07/07 00:00:00");
        params.setEndTime("2018/07/07 23:59:59");
        params.setCode("0");
        params.setChart(false);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity entity = new HttpEntity(params);
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8081/api/expData/get", HttpMethod.POST,entity,String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void testSearchCount1(){
        CountByDateParams params = new CountByDateParams();
//		params.setWellDbk("310115210060");
        params.setCode("0");
        params.setTime("2019/5/4 9:00:00");
//		params.setSupplier("中科光大");
        params.setPageSize(10);
        params.setPageIndex(167);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity entity = new HttpEntity(params);
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8081/api/countData/date", HttpMethod.POST,entity,String.class);
        System.out.println(response.getBody());
    }
}
