package com.epidemic.controller;

import com.epidemic.beans.*;
import com.epidemic.service.EpidemicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/epidemicData")
public class EpidemicController {
    private Logger logger = Logger.getLogger(EpidemicController.class);

    @Autowired
    private EpidemicService epidemicService;

    @PostMapping("/ajax/input")
    @ResponseBody
    public AjaxResponseInfo inputData(@RequestBody DaliyEpidemicInfo daliyEpidemicInfo, Model model, HttpSession session){
        logger.debug(daliyEpidemicInfo);
        //获取输入数据的用户信息
        UserInfo userInfo = (UserInfo) session.getAttribute("loginuser");
        AjaxResponseInfo ajaxResponseInfo = new AjaxResponseInfo();
        //用户为空
        if(userInfo == null){
            ajaxResponseInfo.setCode(-2);
            ajaxResponseInfo.setMsg("你还没有登录");
        }else{
            List<ProvinceInfo> list = epidemicService.saveData(daliyEpidemicInfo,userInfo.getUserId());
            ajaxResponseInfo.setCode(0);
            ajaxResponseInfo.setData(list);
        }
        return ajaxResponseInfo;
    }

    @RequestMapping("ajax/lastestData")
    @ResponseBody
    public AjaxResponseInfo findLastestData(){
        logger.debug("查询最新疫情");
        AjaxResponseInfo responseInfo = new AjaxResponseInfo();
        List<EpidemicDetailInfo> list = epidemicService.findLastestData();
        responseInfo.setData(list);
        return responseInfo;
    }
}
