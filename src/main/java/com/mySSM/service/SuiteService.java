package com.mySSM.service;

import com.mySSM.pojo.Suite;
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
     * @param id 要删除的房间ID
     * @return 删除成功返回true 反之false
     */
    boolean deleteSuiteById(int id);

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
    Suite querySuiteById(Integer  id);

    /**
     * 查询所有的房间对象
     * @return 返回房间对象的列表
     */
    ArrayList<Suite> queryAllSuite();

    /**
     * 查询房号为num的房间对象
     * @param num 要查询的房间的房号
     * @return 返回查询的房间对象
     */
    Suite querySuiteByNum(int num);

    /**
     * 更新房间的类型
     * @param suite 要更新房间的类型的房间对象
     * @return 更新成功返回true 反之false
     */
    boolean updateSuite_Type(Suite suite);
}
