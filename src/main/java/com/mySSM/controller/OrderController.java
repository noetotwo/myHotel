package com.mySSM.controller;


import com.mySSM.Monitor.OrderMonitor;
import com.mySSM.pojo.Order;
import com.mySSM.pojo.onlyCode;
import com.mySSM.service.OrderService;
import com.mySSM.service.SuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    SuiteService suiteService;

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
    public synchronized ModelAndView update(Integer id){
        ModelAndView mv = new ModelAndView();
        Order order;
        onlyCode code;
        if(orderCache.get(id) == null || !orderCache.get(id).isOnly()){
            order = orderService.getOrderID(id);
            code = new onlyCode(id);
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

    @RequestMapping(value  = "/submit",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String submit(@RequestBody Order order){
        if(orderService.UpdateOrder(order)){
            return "200";
        }
        return "100";
    }
    @RequestMapping("/check")
    public String check(){
        return "check";
    }

    @RequestMapping("/checkNum")
    @ResponseBody
    public Order checkNum(int num){
        return orderService.getOrderBySuiteNum(num);
    }

    @RequestMapping(value  = "/Finish",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String Finish(@RequestBody Order order){
        System.out.println(order);
        if(suiteService.updateState(Integer.parseInt(order.getSuiteNum()),"未打扫") && orderService.Finish(order)){
            return "200";
        }
        return "100";
    }

    @RequestMapping(value  = "/add",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String add(@RequestBody Order order){
        if(suiteService.isNull(Integer.parseInt(order.getSuiteNum())) && suiteService.updateState(Integer.parseInt(order.getSuiteNum()),"已入住")){
            if (orderService.addOrder(order)) {
                return "200";
            }
        }
        return "100";
    }

    @RequestMapping("/EndUpdate")
    @ResponseBody
    public String endUp(int id){
        orderCache.put(id, new onlyCode(id));
        return "200";
    }

}
