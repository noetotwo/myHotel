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
    public boolean UpdateAdmin(User user,User now) {
        if(adminMapper.ComparedAdmin(user) != null && user == now){
            if(adminMapper.UpdateAdmin(now) > 0){
                return true;
            }
        }
        if(adminMapper.ComparedAdmin(user) != null && user.getLevel() > 3 && user.getLevel() > now.getLevel()){
            if(adminMapper.UpdateAdmin(now) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAdmin(User user,User addUser) {
        if(adminMapper.ComparedAdmin(user) != null && user.getLevel() > 4 && user.getLevel() > addUser.getLevel()){
            if(adminMapper.ComparedAdmin(addUser) == null && adminMapper.addAdmin(addUser) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DeleteAdmin(User user,User removeName) {
        if(adminMapper.ComparedAdmin(user) != null && user.getLevel() >= 7 && user.getLevel() > removeName.getLevel()){
            if(adminMapper.DeleteAdmin(removeName) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> SelectAdmin(User user) {
        List<User> list = null;
        if (adminMapper.ComparedAdmin(user) != null && user.getLevel() >= 5){
            list = adminMapper.SelectAdmin();
        }
        return list;
    }
}
