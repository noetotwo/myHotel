package com.mySSM.controller;


import com.mySSM.Utils.OrderMonitor;
import com.mySSM.pojo.Order;
import com.mySSM.pojo.onlyCode;
import com.mySSM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    OrderService orderService;

    OrderMonitor orderMonitor = OrderMonitor.getMonitor();

    ConcurrentHashMap<Integer, onlyCode> orderCache = OrderMonitor.getOrderCache();

    @RequestMapping("/list")
    public String getList(){
        return "OrderList";
    }

    @RequestMapping("/addOrder")
    public synchronized String addOrder(){
        return "addOrder";
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @RequestMapping("/update")
    public synchronized ModelAndView update(int id){
        ModelAndView mv = new ModelAndView();
        Order order;
        onlyCode code;
        System.out.println(id);
        if(orderCache.get(id) == null || !orderCache.get(id).isOnly()){
            order = orderService.getOrderID(id);
            code = new onlyCode(id);
            order.setCode(code.hashCode());
            System.out.println(order);
            mv.addObject("o",order);
            mv.setViewName("order");
            code.setOnly(true);
            orderCache.put(id, code);
        }else {
            mv.setViewName("Occupy");
        }
        return mv;
    }

    @RequestMapping("/EndUpdate")
    public void endUp(int id){
        orderCache.put(id, new onlyCode(id));
    }

}
