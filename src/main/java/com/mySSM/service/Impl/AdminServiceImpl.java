package com.mySSM.service.Impl;

import com.mySSM.pojo.User;
import com.mySSM.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
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
