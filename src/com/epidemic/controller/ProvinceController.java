package com.epidemic.controller;

import com.epidemic.beans.AjaxResponseInfo;
import com.epidemic.beans.ProvinceInfo;
import com.epidemic.service.ProvinceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {

    private Logger logger = Logger.getLogger(ProvinceController.class);

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/ajax/noDataList")
    @ResponseBody
    public AjaxResponseInfo noDataProvinceList(String date){
        logger.debug("date:"+date);
        List<ProvinceInfo> list = null;
        AjaxResponseInfo<List<ProvinceInfo>> ajaxResponseInfo = new AjaxResponseInfo<>();
        if(!StringUtils.isEmpty(date)){
            list = provinceService.findNoDataProvinces(date);
            ajaxResponseInfo.setData(list);
        }else{
            ajaxResponseInfo.setCode(-1);
            ajaxResponseInfo.setMsg("参数不足");
        }
        return ajaxResponseInfo;
    }
}
