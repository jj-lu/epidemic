package com.epidemic.service.impl;

import com.epidemic.beans.UserInfo;
import com.epidemic.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo findByAccount(String account) {
        return null;
    }
}
