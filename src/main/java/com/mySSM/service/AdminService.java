package com.mySSM.service;

import com.mySSM.pojo.User;

import java.util.List;

public interface AdminService {
    /**
     * 更新账号dao
     * @param user 管理对象
     * @param now 新的对象
     * @return 更新成功返回true 反之false
     */
    boolean UpdateAdmin(User user,User now);

    /**
     * 添加管理者
     * @param user 管理对象
     * @param addUser 要添加的管理者
     * @return 添加成功返回true 反之false
     */
    boolean addAdmin(User user,User addUser);

    /**
     * 删除管理者
     * @param user 管理对象
     * @param removeUser 要删除的用户
     * @return 删除成功返回true 反之false
     */
    boolean DeleteAdmin(User user,User removeUser);

    /**
     * 查询管理者
     * @param user 管理对象
     * @return 查询成功返回对象列表
     */
    List<User> SelectAdmin(User user);
}

