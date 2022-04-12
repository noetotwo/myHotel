package com.mySSM.service.Impl;

import com.mySSM.dao.OrderMapper;
import com.mySSM.pojo.Order;
import com.mySSM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean addOrder(Order order) {
        if(orderMapper.addOrder(order) > 1){
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
    public List<Order> getOrderBySuiteNum(String num) {
        return orderMapper.getOrderBySuiteNum(num);
    }

    @Override
    public List<Order> getTimeInterval(String start, String end) {
        return null;
    }


    @Override
    public boolean UpdateOrder(Order order) {
        if(orderMapper.UpdateOrder(order) > 0){
            return true;
        }
        return false;
    }
}
