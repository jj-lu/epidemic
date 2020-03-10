package com.epidemic.service;

import com.epidemic.beans.ProvinceInfo;

import java.util.List;

public interface ProvinceService {
    //获取还未录入数据的省份列表
    List<ProvinceInfo> findNoDataProvinces(String date);
}
