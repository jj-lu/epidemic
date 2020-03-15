package com.epidemic.service;

import com.epidemic.beans.DaliyEpidemicInfo;
import com.epidemic.beans.EpidemicDetailInfo;
import com.epidemic.beans.ProvinceInfo;
import com.epidemic.beans.UserInfo;

import java.util.List;

public interface EpidemicService {

    /**
     * 保持当日
     * @param daliyEpidemicInfo
     * @return
     */
    List<ProvinceInfo> saveData(DaliyEpidemicInfo daliyEpidemicInfo,Integer userId);

    /**
     * 获取最新疫情数据
     * @return
     */
    List<EpidemicDetailInfo> findLastestData();
}
