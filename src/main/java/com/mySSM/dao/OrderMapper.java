package com.mySSM.dao;

import com.mySSM.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {

    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 得到订单id为id的订单信息
     * @param id
     * @return
     */
    Order getOrderID(Integer id);

    /**
     * 得到所有未结单的订单信息
     * @return
     */
    List<Order> getAll();

    /**
     * 得到客户身份证号为card的所有订单信息
     * @param card
     * @return
     */
    List<Order> getOrderByCard(String card);

    /**
     * 得到房间号为num的所有订单信息
     * @param num
     * @return
     */
    Order getOrderBySuiteNum(int num);

    /**
     * 得到时间从start到end的订单信息
     * @param start
     * @param end
     * @return
     */
    List<Order> getTimeInterval(String start,String end);

    /**
     * 结单
     * @param order 要结单的订单信息
     * @return
     */
    int Finish(Order order);

    /**
     * 更新订单信息
     * @param order 要更新的订单信息
     * @return
     */
    int UpdateOrder(Order order);

}
