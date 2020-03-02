package com.epidemic.controller;

import com.epidemic.beans.UserInfo;
import com.epidemic.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user")
public class UserController {

    public static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(UserInfo userInfo, Model model){
        logger.debug("login()方法被執行了。。。account="+userInfo.getAccount()+"passowrd"+userInfo.getPassword());
        //通過業務邏輯層
        UserInfo user = this.userService.findByAccount(userInfo.getAccount());
        if(user == null){
            //账号不正确
            model.addAttribute("msg","账号不正确");
            return "login";
        }
        if(user.getPassword().equals(userInfo.getPassword())){
            //登录成功
            return "main";
        }else{
            //登录失败
            model.addAttribute("msg","密码不正确");
            return "login";
        }
    }
}
