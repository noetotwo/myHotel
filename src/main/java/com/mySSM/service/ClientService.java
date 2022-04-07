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

    Client queryClientById(int  id);

    Client queryClientByName(String name);

    Client queryClientByCard(String card);

    List<Client> SelectAll();

    boolean DeleteClientById(int id);

    boolean DeleteClientByCard(String card);

    boolean UpdateClient(Client client);

    boolean setIntegral(String card,int integral);

    boolean setVIP(String card,String type);
}
