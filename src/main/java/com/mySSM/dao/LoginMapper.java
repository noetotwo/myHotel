package com.mySSM.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface LoginMapper {

    Map Login(@Param("name") String name, @Param("pwd")String pwd);

}
