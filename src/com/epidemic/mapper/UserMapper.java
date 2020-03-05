package com.epidemic.mapper;

import com.epidemic.beans.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select(value = "select u.user_id,u.account,u.password,u.username " +
            "from users u " +
            "where u.account = #{account}" +
            "and u.del_flag is null or u.del_flag = 0")
    UserInfo findByAccount(String account);
}
