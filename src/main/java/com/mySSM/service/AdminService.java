package com.mySSM.service;

import com.mySSM.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminService {
    /**
     * 更新账号dao
     * @param now 新的对象
     * @return 更新成功返回true 反之false
     */
    boolean UpdateAdmin(User now);

    /**
     * 添加管理者
     * @param user 管理对象
     * @return 添加成功返回true 反之false
     */
    boolean addAdmin(User user);

    /**
     * 删除管理者
     * @param user 管理对象
     * @return 删除成功返回true 反之false
     */
    boolean DeleteAdmin(User user);

    /**
     * 查询管理者
     * @param user 管理对象
     * @return 查询成功返回对象列表
     */
    List<User> SelectAdmin(User user);
}
