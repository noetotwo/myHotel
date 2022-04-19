package com.mySSM.controller;


import com.mySSM.Monitor.OrderMonitor;
import com.mySSM.pojo.Order;
import com.mySSM.pojo.onlyCode;
import com.mySSM.service.ClientService;
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

    /**
     * 订单监听器
     */
    OrderMonitor orderMonitor = OrderMonitor.getMonitor();

    /**
     * 监听器中存储加锁的订单号
     */
    ConcurrentHashMap<Integer, onlyCode> orderCache = OrderMonitor.getOrderCache();

    /**
     * 订单全部数据页面的请求处理
     * @return
     */
    @RequestMapping("/list")
    public String getList(){
        return "OrderList";
    }

    /**
     * 添加订单页面的请求处理
     * @return
     */
    @RequestMapping("/addOrder")
    public synchronized String addOrder(){
        return "addOrder";
    }

    /**
     * 要添加订单的信息，添加成功返回200，否之100
     * @param order
     * @return
     */
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

    /**
     * 未结当的订单数据接口
     * @return
     */
    @RequestMapping("/all")
    @ResponseBody
    public List<Order> getAll(){
        return orderService.getAll();
    }

    /**
     * 修改订单页面的请求，并对要修改的订单进行加锁，避免同时修改
     * @param id 要修改订单的id号
     * @return 返回修改订单页面和一个Order对象
     */
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

    /**
     * 修改订单数据的请求接口
     * @param order 要修改的订单对象
     * @return 修改成功返回200否之100
     */
    @RequestMapping(value  = "/submit",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String submit(@RequestBody Order order){
        if(orderService.UpdateOrder(order)){
            return "200";
        }
        return "100";
    }

    /**
     * 结束修改订单的请求，并释放订单的锁
     * @param id 要结束修改的订单id
     * @return
     */
    @RequestMapping("/EndUpdate")
    @ResponseBody
    public String endUp(int id){
        orderCache.put(id, new onlyCode(id));
        return "200";
    }

    /**
     * 退房页面的请求处理
     * @return
     */
    @RequestMapping("/check")
    public String check(){
        return "check";
    }

    /**
     * 退房订单中房间号的数据请求
     * @return 要退房间订单数据
     */
    @RequestMapping("/checkNum")
    @ResponseBody
    public Order checkNum(int num){
        return orderService.getOrderBySuiteNum(num);
    }

    /**
     * 退房请求，并将要订单状态设置为结单房间状态为未打扫
     * @param order 要退房的订单数据
     * @return
     */
    @RequestMapping(value  = "/Finish",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String Finish(@RequestBody Order order){
        System.out.println(order);
        if(suiteService.updateState(Integer.parseInt(order.getSuiteNum()),"未打扫") && orderService.Finish(order)){
            return "200";
        }
        return "100";
    }


}
