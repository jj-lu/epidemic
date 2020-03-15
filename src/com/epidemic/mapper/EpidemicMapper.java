package com.epidemic.mapper;

import com.epidemic.beans.EpidemicDetailInfo;
import com.epidemic.beans.EpidemicInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EpidemicMapper {
    /**
     * 保存疫情记录
     *
     * @param
     * @return
     */
    @Insert(value = "INSERT INTO epidemics (province_id,data_year,data_month,data_day,affirmed,suspected,isolated,dead,cured,user_id,input_date) " +
            "VALUE (#{provinceId},#{dataYear},#{dataMonth},#{dataDay},#{affirmed},#{suspected},#{isolated},#{dead},#{cured},#{userId},#{inputDate})")
    int saveInfo(EpidemicInfo epidemicInfo);

    @Select(value = "SELECT e1.`province_id`,e1.`affirmed`,e1.`suspected`,e1.`isolated`,e1.`cured`,e1.`dead`, " +
            "temp.province_name, " +
            "temp.affirmed_total, " +
            "temp.suspected_total, " +
            "temp.isolated_total, " +
            "temp.cured_total, " +
            "temp.dead_total " +
            "FROM epidemics e1 RIGHT JOIN (SELECT e.`province_id`,p.`province_name`,SUM(e.`affirmed`) affirmed_total,SUM(e.`suspected`) suspected_total,SUM(e.`isolated`) isolated_total,SUM(e.`cured`) cured_total, " +
            "SUM(e.`dead`) dead_total " +
            "FROM epidemics e RIGHT JOIN provinces p ON p.`province_id` = e.`province_id` " +
            "GROUP BY e.`province_id`,p.`province_name`) temp ON e1.`province_id` = temp.province_id " +
            "WHERE e1.`data_year` = 2020 " +
            "AND e1.`data_month` = 3 " +
            "AND e1.`data_day` = 14")
    List<EpidemicDetailInfo> findLastestData(Map<String,Short> condition);
}
