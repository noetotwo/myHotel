package com.mySSM.service;

import com.mySSM.pojo.Order;
import java.util.List;

public interface OrderService {

    boolean addOrder(Order order);

    Order getOrderID(Integer id);

    List<Order> getAll();

    List<Order> getOrderByCard(String card);

    List<Order> getOrderBySuiteNum(String num);

    List<Order> getTimeInterval(String start,String end);

    boolean UpdateOrder(Order order);
}
