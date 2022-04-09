package com.mySSM.dao;


import com.mySSM.pojo.Client;
import com.mySSM.pojo.ClientTemp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientMapper {

    int addClient(Client client);

    Client queryClientById(int  id);

    Client queryClientByName(String name);

    Client queryClientByCard(String card);

    List<Client> SelectAll();

    int DeleteClientById(int id);

    int DeleteClientByCard(String card);

    int UpdateClient(Client client);

    int setIntegral(@Param("card")String card,@Param("integral")int integral);

    int setVIP(@Param("card")String card,@Param("vip")String type);

    ClientTemp Collection(String card);

    int inSitu(Client client);

}
