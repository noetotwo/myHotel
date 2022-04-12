package com.mySSM.dao;

import com.mySSM.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {

    int addOrder(Order order);

    Order getOrderID(Integer id);

    List<Order> getAll();

    List<Order> getOrderByCard(String card);

    List<Order> getOrderBySuiteNum(String num);

    List<Order> getTimeInterval(String start,String end);

    int UpdateOrder(Order order);

}
