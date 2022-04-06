package com.mySSM.service.Impl;

import com.mySSM.dao.AdminMapper;
import com.mySSM.pojo.User;
import com.mySSM.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public boolean UpdateAdmin(User now) {
        return false;
    }

    @Override
    public boolean addAdmin(User user) {
        return false;
    }

    @Override
    public boolean DeleteAdmin(User user) {
        return false;
    }

    @Override
    public List<User> SelectAdmin(User user) {
        return null;
    }
}
