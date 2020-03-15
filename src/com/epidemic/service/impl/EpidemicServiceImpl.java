package com.epidemic.service.impl;

import com.epidemic.beans.DaliyEpidemicInfo;
import com.epidemic.beans.EpidemicDetailInfo;
import com.epidemic.beans.EpidemicInfo;
import com.epidemic.beans.ProvinceInfo;
import com.epidemic.mapper.EpidemicMapper;
import com.epidemic.mapper.ProvinceMapper;
import com.epidemic.service.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EpidemicServiceImpl implements EpidemicService {

    @Autowired
    private EpidemicMapper epidemicMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<ProvinceInfo> saveData(DaliyEpidemicInfo daliyEpidemicInfo,Integer userId) {
        //获取当前时间
        Date current = new Date();
        //数据的日期
        String[] ymd = daliyEpidemicInfo.getDate().split("-");
        Short year=0,month=0,day=0;
        year = Short.parseShort(ymd[0]);
        month = Short.parseShort(ymd[1]);
        day = Short.parseShort(ymd[2]);
        //遍历每一天输入数据
        for(EpidemicInfo epidemicInfo : daliyEpidemicInfo.getArray()){
            //设置输入日期
            epidemicInfo.setInputDate(current);
            //设置录入该数据的用户id
            epidemicInfo.setUserId(userId);
            //设置数据对应的日期
            epidemicInfo.setDataYear(year);
            epidemicInfo.setDataMonth(month);
            epidemicInfo.setDataDay(day);
            epidemicMapper.saveInfo(epidemicInfo);
        }
        return provinceMapper.findNoDataProvinces(year,month,day);
    }

    @Override
    public List<EpidemicDetailInfo> findLastestData() {
        //定义年月日
        short year=0,month=0,day=0;
        //calendar获得当前日期年月日
        Calendar calendar = new GregorianCalendar();
        year = (short) calendar.get(Calendar.YEAR);
        month = (short) (calendar.get(Calendar.MONTH)+1);
        day = (short) (calendar.get(Calendar.DATE));
        //Map封住查询条件
        Map<String,Short> condition = new HashMap<>();
        condition.put("year",year);
        condition.put("month",month);
        condition.put("day",day);
        //查询每个省份的累计数量和当日新增数量
        List<EpidemicDetailInfo> list = epidemicMapper.findLastestData(condition);
        return list;
    }
}
