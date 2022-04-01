package com.mySSM.service.Impl;

import com.mySSM.dao.LoginMapper;
import com.mySSM.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginDao;

    @Override
    public boolean Login(String name,String pwd) {
        Map user =  loginDao.Login(name,pwd);
        System.out.println(user);
        if(user != null){
            return true;
        }
        return false;
    }
}
