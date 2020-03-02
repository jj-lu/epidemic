package com.epidemic.service;

import com.epidemic.beans.UserInfo;

public interface UserService {
    //根据账号获取用户信息
    UserInfo findByAccount(String account);
}
