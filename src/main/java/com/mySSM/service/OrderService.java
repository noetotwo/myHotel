package com.mySSM.service;

import com.mySSM.pojo.Order;
import java.util.List;

public interface OrderService {

    boolean addOrder(Order order);

    List<Order> getAll();

    List<Order> getOrderByClient(int id);

    List<Order> getOrderBySuite(int id);

    List<Order> getTimeInterval(String start,String end);

    boolean UpdateOrder(Order order);
}
