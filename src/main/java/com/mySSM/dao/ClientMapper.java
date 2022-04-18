package com.mySSM.dao;


import com.mySSM.pojo.Client;
import com.mySSM.pojo.ClientTemp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientMapper {

    /**
     * 添加一个新客户信息
     * @param client 客户信息实体类
     * @return
     */
    int addClient(Client client);

    /**
     * 返回表id为id的客户信息
     * @param id 客户id
     * @return
     */
    Client queryClientById(int  id);

    /**
     * 返回名字为name的客户信息
     * @param name 客户名字
     * @return
     */
    Client queryClientByName(String name);

    /**
     * 返回身份证为card的客户信息
     * @param card 客户身份证号
     * @return
     */
    Client queryClientByCard(String card);

    /**
     * 返回所有的客户信息
     * @return
     */
    List<Client> SelectAll();

    /**
     * 删除表id为id的客户信息
     * @param id 客户信息id
     * @return
     */
    int DeleteClientById(int id);

    /**
     * 删除身份证为card的客户信息
     * @param card 客户身份证号
     * @return
     */
    int DeleteClientByCard(String card);

    /**
     * 更新客户信息
     * @param client 客户信息实体类
     * @return
     */
    int UpdateClient(Client client);

    /**
     * 修改身份证号为card的积分
     * @param card 客户身份证号
     * @param integral 积分
     * @return
     */
    int setIntegral(@Param("card")String card,@Param("integral")int integral);

    /**
     * 修改身份证号为card的vip级别
     * @param card 客户身份证号
     * @param type vip级别
     * @return
     */
    int setVIP(@Param("card")String card,@Param("vip")String type);

    /**
     * 将一个Client实体类转换为ClientTemp实体类
     * @param card Client实体类的身份证号card
     * @return
     */
    ClientTemp Collection(String card);

    /**
     * 将Client添加表中
     * @param client
     * @return
     */
    int inSitu(Client client);

}
