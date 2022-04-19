package com.mySSM.service.Impl;

import com.mySSM.dao.ClientMapper;
import com.mySSM.pojo.Client;
import com.mySSM.pojo.ClientTemp;
import com.mySSM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientMapper clientMapper;

    @Override
    public boolean addClient(Client client) {
        ClientTemp temp = clientMapper.Collection(client.getCard());
        if(temp == null){
            if (clientMapper.queryClientByCard(client.getCard()) == null && clientMapper.addClient(client) > 0) {
                return true;
            }
        }else{
            System.out.println(temp);
            if (clientMapper.queryClientByCard(client.getCard()) == null && clientMapper.inSitu(temp.getClient()) > 0) {

                return true;
            }
        }
        return false;
    }

    @Override
    public Client queryClientById(int id) {
        return clientMapper.queryClientById(id);
    }

    @Override
    public Client queryClientByName(String name) {
        return clientMapper.queryClientByName(name);
    }

    @Override
    public Client queryClientByCard(String card) {
        return clientMapper.queryClientByCard(card);
    }

    @Override
    public List<Client> SelectAll() {
        return clientMapper.SelectAll();
    }

    @Override
    public boolean DeleteClientById(int id) {
        if(clientMapper.DeleteClientById(id) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean DeleteClientByCard(String card) {
        if(clientMapper.DeleteClientByCard(card) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean UpdateClient(Client client) {
        if(clientMapper.queryClientByCard(client.getCard()) != null && clientMapper.UpdateClient(client) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean setIntegral(String card, int integral) {
        if(clientMapper.queryClientByCard(card) != null && clientMapper.setIntegral(card,integral) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean setVIP(String card, String type) {
        if(clientMapper.queryClientByCard(card) != null && clientMapper.setVIP(card,type) > 0){
            return true;
        }
        return false;
    }

}
