package com.mySSM.controller;

import com.mySSM.Monitor.SuiteMonitor;
import com.mySSM.pojo.Suite;
import com.mySSM.pojo.onlySuite;
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
@RequestMapping("/suite")
public class SuiteController {

    @Autowired
    SuiteService suiteService;

    /**
     * 房间修改监听器
     */
    SuiteMonitor suiteMonitor = SuiteMonitor.getMonitor();

    /**
     * 监听器中存储加锁的房间号
     */
    ConcurrentHashMap<Integer, onlySuite> suiteCache = suiteMonitor.getSuiteCache();

    /**
     * 房间全部数据页面的请求处理
     * @return
     */
    @RequestMapping("/list")
    public String getList(){
        return "suiteList";
    }

    /**
     * 添加房间页面的请求处理
     * @return
     */
    @RequestMapping("/addSuite")
    public synchronized String addSuite(){
        return "addSuite";
    }


    /**
     * 修改房间页面的请求，并对要修改的订单进行加锁，避免同时修改
     * @param id 要修改订单的id号
     * @return 返回修改订单页面和一个Suite对象
     */
    @RequestMapping("/update")
    public synchronized ModelAndView update(Integer id){
        ModelAndView mv = new ModelAndView();
        Suite suite;
        onlySuite code;
        if(suiteCache.get(id) == null || !suiteCache.get(id).isOnly()){
            suite = suiteService.querySuiteById(id);
            code = new onlySuite(id);
            System.out.println(suite);
            mv.addObject("s",suite);
            mv.setViewName("suite");
            code.setOnly(true);
            suiteCache.put(id, code);
        }else {
            mv.setViewName("Occupy");
        }
        return mv;
    }

    /**
     * 所有房间数据接口
     * @return
     */
    @RequestMapping("/all")
    @ResponseBody
    public List<Suite> getAll(){
        return suiteService.queryAllSuite();
    }

    /**
     * 通过房间类型返回房间数据接口
     * @param type
     * @return
     */
    @RequestMapping("/type")
    @ResponseBody
    public List<Suite> getType(String type) {
        return suiteService.querySuiteByType(type);
    }

    /**
     * 通过房间号返回房间数据接口
     * @param num
     * @return
     */
    @RequestMapping("/num")
    @ResponseBody
    public Suite getNum(int num){
        return suiteService.querySuiteByNum(num);
    }

    /**
     * 添加房间请求接口，添加成功返回200，否之返回100
     * @param suite
     * @return
     */
    @RequestMapping(value  = "/add",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String add(@RequestBody Suite suite){
        System.out.println(suite);
        if(suiteService.addSuite(suite)){
            return "200";
        }
        return "100";
    }

    /**
     * 修改房间数据的请求接口
     * @param suite 要修改的订单对象
     * @return 修改成功返回200否之100
     */
    @RequestMapping(value  = "/submit",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String submit(@RequestBody Suite suite){
        if(suiteService.updateSuiteById(suite)){
            return "200";
        }
        return "100";
    }

    /**
     * 结束修改房间的请求，并释放订单的锁
     * @param id 要结束修改的房间id
     * @return
     */
    @RequestMapping("/EndUpdate")
    @ResponseBody
    public String endUp(int id){
        suiteCache.put(id, new onlySuite(id));
        return "200";
    }
}
