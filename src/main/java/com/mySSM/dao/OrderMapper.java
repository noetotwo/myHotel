package com.mySSM.dao;

import com.mySSM.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {

    int addOrder(Order order);

    List<Order> getAll();

    List<Order> getOrderByClient(int id);

    List<Order> getOrderBySuite(int id);

    List<Order> getTimeInterval(String start,String end);

    int UpdateOrder(Order order);

}
