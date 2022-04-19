package com.mySSM.service;

import com.mySSM.pojo.Suite;
import com.mySSM.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface SuiteService {
    /**
     * 添加新的房间
     * @param suite 房间对象
     * @return 添加成功返回true 反之false
     */
    boolean addSuite(Suite suite);

    /**
     * 删除房间
     * @param user 管理员
     * @param num 要删除的房间num
     * @return 删除成功返回true 反之false
     */
    boolean deleteSuiteByNum(User user,int num);

    /**
     * 更新房间信息
     * @param suite 更新房间的对象
     * @return 更新成功返回true 反之false
     */
    boolean updateSuiteById(Suite suite);

    /**
     * 查询房间对象
     * @param id 要查询的房间对象的ID
     * @return 返回要查询的房间对象
     */
    Suite querySuiteById(int  id);

    /**
     * 查询房间对象
     * @param SType 要查询的房间对象的类型
     * @return 返回要查询的房间对象
     */
    ArrayList<Suite> querySuiteByType(String  SType);

    /**
     * 查询所有的房间对象
     * @return 返回房间对象的列表
     */
    ArrayList<Suite> queryAllSuite();

    /**
     * 查询空房的房间对象
     * @return 返回房间对象的列表
     */
    ArrayList<Suite> queryNullSuite();

    /**
     * 查询房号为num的房间对象
     * @param num 要查询的房间的房号
     * @return 返回查询的房间对象
     */
    Suite querySuiteByNum(int num);

    /**
     * 更新房间的状态
     * @param num 要更新房间的类型的房间对象的房号
     * @param state 新的状态
     * @return 更新成功返回true 反之false
     */
    boolean updateState( int num, String state);

    /**
     * 判断房间是否为空
     * @param num 房间号
     * @return
     */
    boolean isNull(int num);
}
