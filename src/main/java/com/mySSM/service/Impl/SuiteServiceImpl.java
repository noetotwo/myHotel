package com.mySSM.service.Impl;

import com.mySSM.dao.SuiteMapper;
import com.mySSM.pojo.Suite;
import com.mySSM.service.SuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SuiteServiceImpl implements SuiteService {

    @Autowired
    SuiteMapper suiteMapper;

    @Override
    public boolean addSuite(Suite suite) {
        return false;
    }

    @Override
    public boolean deleteSuiteById(int id) {
        return false;
    }

    @Override
    public boolean updateSuiteById(Suite suite) {
        return false;
    }

    @Override
    public Suite querySuiteById(Integer id) {
        return null;
    }

    @Override
    public ArrayList<Suite> queryAllSuite() {
        return null;
    }

    @Override
    public Suite querySuiteByNum(int num) {
        return null;
    }

    @Override
    public boolean updateSuite_Type(Suite suite) {
        return false;
    }
}
