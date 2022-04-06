package com.mySSM.service;

public interface LoginService {

    /**
     * LoginService的具体业务
     * @param name login用户名
     * @param pwd login用户密码
     * @return 登录成功返回true 否之返回false
     */
    public boolean Login(String name,String pwd);
}
