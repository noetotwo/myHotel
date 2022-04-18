package com.mySSM.service.Impl;

import com.mySSM.Utils.DateUtil;
import com.mySSM.dao.OrderMapper;
import com.mySSM.pojo.Client;
import com.mySSM.pojo.Order;
import com.mySSM.service.ClientService;
import com.mySSM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ClientService clientService;

    @Override
    public boolean addOrder(Order order) {

        if(clientService.queryClientByCard(order.getCard()) == null){
            Client client = new Client(order.getName(),order.getSex(),order.getCard(),order.getPhone(),"白银","",DateUtil.getNowDate());
            clientService.addClient(client);
        }
        if(orderMapper.addOrder(order) > 0){
            return true;
        }
        return false;
    }

    @Override
    public Order getOrderID(Integer id){
        return orderMapper.getOrderID(id);
    }

    @Override
    public List<Order> getAll() {
        return orderMapper.getAll();
    }

    @Override
    public List<Order> getOrderByCard(String card) {
        return orderMapper.getOrderByCard(card);
    }

    @Override
    public Order getOrderBySuiteNum(int num) {
        return orderMapper.getOrderBySuiteNum(num);
    }

    @Override
    public List<Order> getTimeInterval(String start, String end) {
        return null;
    }

    @Override
    public boolean Finish(Order order) {
        if(orderMapper.Finish(order) > 0){
            return true;
        }
        return false;
    }


    @Override
    public boolean UpdateOrder(Order order) {
        if(orderMapper.UpdateOrder(order) > 0){
            return true;
        }
        return false;
    }
}
