package com.plht.eshandle55.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.plht.eshandle55.common.Random;
import com.plht.eshandle55.dao.CountDao;
import com.plht.eshandle55.dao.ExpDao;
import com.plht.eshandle55.dao.RawDao;
import com.plht.eshandle55.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EsService {
    @Autowired
    private RawDao rawDao;
    @Autowired
    private ExpDao expDao;
    @Autowired
    private CountDao countDao;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public void indexExpData(String jsonData)  {
        ReceiveData receiveData = JSON.parseObject(jsonData, ReceiveData.class);
        Raw rawData = new Raw();
        rawData.setWellDbK(receiveData.getWell_DBK());
        rawData.setADMINISTRATION_ZONING(receiveData.getADMINISTRATION_ZONING());
        rawData.setHYDROGEOLOGY_ZONING(receiveData.getHYDROGEOLOGY_ZONING());
        rawData.setReceiveDate(data2Long(receiveData.getRECEIVE_DATE()));
        rawData.setRECEIVE_CONTENT(receiveData.getRECEIVE_CONTENT());
        rawData.setSimcardNr(receiveData.getSIMCARD_NR());
        rawData.setSupplier(receiveData.getSupplier());
        rawData.setId(Random.genUUID());
        rawDao.save(rawData);
        List<TypeData> typeDatas = receiveData.getDataList();
        Set<String> set = new HashSet();
        for (TypeData typeData : typeDatas) {
            set.add(typeData.getDATA_TAKING_DATE());
        }
        List<Exp> exps = new ArrayList<>();
        for (String time : set) {
            Exp data = new Exp();
            for (TypeData typeData : receiveData.getDataList()) {
                if (time.equals(typeData.getDATA_TAKING_DATE())) {
                    data.setWellDbK(receiveData.getWell_DBK());
                    data.setSimcardNr(receiveData.getSIMCARD_NR());
                    data.setADMINISTRATION_ZONING(receiveData.getADMINISTRATION_ZONING());
                    data.setWATERSHED_ZONING(receiveData.getWATERSHED_ZONING());
                    data.setHYDROGEOLOGY_ZONING(receiveData.getHYDROGEOLOGY_ZONING());
                    data.setReceiveDate(data2Long(receiveData.getRECEIVE_DATE()));
                    data.setDataTakingDate(data2Long(typeData.getDATA_TAKING_DATE()));
                    data.getValues().add(typeData);
                    data.setSupplier(receiveData.getSupplier());
                    data.setId(Random.genUUID());
                }
            }
            exps.add(data);
        }
        expDao.saveAll(exps);
    }




    public void indexCountData(String jsonData){
        Count data = new Count();
        JSONObject obj = JSON.parseObject(jsonData);
        data.setADMINISTRATION_ZONING(obj.getString("ADMINISTRATION_ZONING"));
        data.setDATA_TAKING_DATE(data2Long(obj.getString("DATA_TAKING_DATE")));
        data.setExp_Fail_Count(obj.getInteger("Exp_Fail_Count"));
        data.setC_ID(obj.getString("ID"));
        data.setRec_Count(obj.getInteger("Rec_Count"));
        data.setSIMCARD_NR(obj.getString("SIMCARD_NR"));
        data.setSupplier(obj.getString("Supplier"));
        data.setTableName(obj.getString("TableName"));
        data.setWELL_DBK(obj.getString("WELL_DBK"));
        data.setExp_Sucess_Count(obj.getInteger("Exp_Sucess_Count"));
        data.setId(Random.genUUID());
        countDao.save(data);
    }


    private Long data2Long(String date){
        if (date.equals("")){
            return null;
        }
        Long time = null;
        try {
            time = sdf.parse(date).getTime();
        } catch (ParseException e) {
            try {
                time=sdf2.parse(date).getTime();
            } catch (ParseException e1) {
                try {
                    time=sdf3.parse(date).getTime();
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return time;
    }


}
