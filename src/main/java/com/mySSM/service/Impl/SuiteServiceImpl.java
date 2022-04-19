package com.mySSM.service.Impl;

import com.mySSM.dao.AdminMapper;
import com.mySSM.dao.SuiteMapper;
import com.mySSM.pojo.Suite;
import com.mySSM.pojo.User;
import com.mySSM.service.SuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SuiteServiceImpl implements SuiteService {

    @Autowired
    SuiteMapper suiteMapper;

    @Autowired
    AdminMapper adminMapper;


    @Override
    public boolean addSuite(Suite suite) {
        if(suiteMapper.querySuiteByNum(suite.getRoomNum()) == null && suiteMapper.addSuite(suite) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSuiteByNum(User user, int num) {
        if(adminMapper.ComparedAdmin(user) != null && user.getLevel() > 5){
            if(suiteMapper.deleteSuiteByNum(num) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateSuiteById(Suite suite) {
        if(suiteMapper.updateSuiteById(suite) > 0){
            return true;
        }
        return false;
    }

    @Override
    public Suite querySuiteById(int id) {
        return suiteMapper.querySuiteById(id);
    }

    @Override
    public ArrayList<Suite> querySuiteByType(String sType) {
        return suiteMapper.querySuiteByType(sType);
    }

    @Override
    public ArrayList<Suite> queryAllSuite() {
        return suiteMapper.queryAllSuite();
    }

    @Override
    public ArrayList<Suite> queryNullSuite() {
        return suiteMapper.queryNullSuite();
    }

    @Override
    public Suite querySuiteByNum(int num) {
        return suiteMapper.querySuiteByNum(num);
    }

    @Override
    public boolean updateState(int num,String state) {
        if(suiteMapper.updateState(num,state) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isNull(int num) {
        if(suiteMapper.isNull(num) != null){
            return true;
        }
        return false;
    }

}
