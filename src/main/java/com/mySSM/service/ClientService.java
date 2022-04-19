package com.mySSM.service;


import com.mySSM.pojo.Client;

import java.util.List;

public interface ClientService {

    /**
     * 添加客户信息
     * @param client 客户信息体
     * @return
     */
    boolean addClient(Client client);

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
    boolean DeleteClientById(int id);

    /**
     * 删除身份证为card的客户信息
     * @param card 客户身份证号
     * @return
     */
    boolean DeleteClientByCard(String card);

    /**
     * 更新客户信息
     * @param client 客户信息实体类
     * @return
     */
    boolean UpdateClient(Client client);

    /**
     * 修改身份证号为card的积分
     * @param card 客户身份证号
     * @param integral 积分
     * @return
     */
    boolean setIntegral(String card,int integral);

    /**
     * 修改身份证号为card的vip级别
     * @param card 客户身份证号
     * @param type vip级别
     * @return
     */
    boolean setVIP(String card,String type);
}
