package com.epidemic.service.impl;

import com.epidemic.beans.ProvinceInfo;
import com.epidemic.mapper.ProvinceMapper;
import com.epidemic.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<ProvinceInfo> findNoDataProvinces(String date) {
        short year=0,month=0,day=0;
        String[] arr = date.split("-");
        List<ProvinceInfo> list = null;
        if(arr.length >= 3){
            year = Short.parseShort(arr[0]);
            month = Short.parseShort(arr[1]);
            day = Short.parseShort(arr[2]);
            list = provinceMapper.findNoDataProvinces(year,month,day);
        }
        return list;
    }
}
