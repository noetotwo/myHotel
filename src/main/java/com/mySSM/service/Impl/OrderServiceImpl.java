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
    public List<Order> getAll() {
        return orderMapper.getAll();
    }

    @Override
    public List<Order> getOrderByClient(int id) {
        return orderMapper.getOrderByClient(id);
    }

    @Override
    public List<Order> getOrderBySuite(int id) {
        return orderMapper.getOrderBySuite(id);
    }

    @Override
    public List<Order> getTimeInterval(String start, String end) {
        return getTimeInterval(start,end);
    }

    @Override
    public boolean UpdateOrder(Order order) {
        if(orderMapper.UpdateOrder(order) > 0){
            return true;
        }
        return false;
    }
}
