package com.mySSM.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface LoginMapper {

    /**
     * 数据库Login操作
     * @param name 用户名
     * @param pwd 用户密码
     * @return 返回在数据中查询的用户信息
     */
    Map Login(@Param("name") String name, @Param("pwd")String pwd);

}

