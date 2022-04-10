package com.mySSM.TestService;

import com.mySSM.Utils.DateUtil;
import com.mySSM.pojo.Order;
import com.mySSM.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    public void addTest(){
        if(orderService.addOrder(new Order(1,1, DateUtil.getNowDate(), "普通大床房","1", 100,"入住中",""))) {
            System.out.println("添加客户成功");
        }else {
            System.out.println("添加客户失败");
        }
    }

    @Test
    public void getAll(){
        orderService.getAll();
    }

    @Test
    public void getOrderByClient(){
        if(orderService.getOrderByClient(1) != null){
            System.out.println("查询客户成功");
        }else{
            System.out.println("查询客户失败");
        }
    }

    @Test
    public void getOrderBySuite(){
        if(orderService.getOrderBySuite(1) != null){
            System.out.println("查询客户成功");
        }else{
            System.out.println("查询客户失败");
        }
    }

    @Test
    public void getTimeInterval(){
        if(orderService.getTimeInterval("","") != null){
            System.out.println("查询客户成功");
        }else{
            System.out.println("查询客户失败");
        }
    }

    @Test
    public void update(){
        if(orderService.UpdateOrder(new Order())){
            System.out.println("更新客户成功");
        }else {
            System.out.println("更新客户失败");
        }
    }

}
