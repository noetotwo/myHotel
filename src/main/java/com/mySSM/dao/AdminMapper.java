package com.mySSM.dao;

import com.mySSM.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    /**
     * 更新账号dao
     * @param now 新的对象
     * @return 更新成功返回改变行数
     */
    int UpdateAdmin(@Param("now") User now);

    /**
     * 增加管理者
     * @param user 管理对象
     * @return 添加成功返回改变行数
     */
    int addAdmin(User user);

    /**
     * 删除管理者
     * @param user 管理对象
     * @return 删除成功返回改变行数
     */
    int DeleteAdmin(User user);

    /**
     * 查询管理者
     * @param user 管理对象
     * @return 查询成功返回对象列表
     */
    List<User> SelectAdmin(User user);
}