package com.mySSM.dao;

import com.mySSM.pojo.Suite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface SuiteMapper {
    /**
     * 添加新的房间
     * @param suite 房间对象
     * @return 返回sql影响的行数
     */
    int addSuite(Suite suite);

    /**
     * 删除房间
     * @param num 要删除的房间num
     * @return 返回sql影响的行数
     */
    int deleteSuiteByNum(int num);

    /**
     * 更新房间信息
     * @param suite 更新房间的对象
     * @return 返回sql影响的行数
     */
    int updateSuiteById(Suite suite);

    /**
     * 查询房间对象
     * @param id 要查询的房间对象的ID
     * @return 返回要查询的房间对象
     */
    Suite querySuiteById(int  id);

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
     * 更新房间的状态
     * @param num 要更新房间的类型的房间对象的房号
     * @param state 新的状态
     * @return 返回sql影响的行数
     */
    int updateState(@Param("num") int num, @Param("state") String state);
}
