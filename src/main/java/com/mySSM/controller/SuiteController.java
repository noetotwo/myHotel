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

    SuiteMonitor suiteMonitor = SuiteMonitor.getMonitor();

    ConcurrentHashMap<Integer, onlySuite> suiteCache = suiteMonitor.getSuiteCache();

    @RequestMapping("/list")
    public String getList(){
        return "suiteList";
    }

    @RequestMapping("/addSuite")
    public synchronized String addSuite(){
        return "addSuite";
    }

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

    @RequestMapping("/all")
    @ResponseBody
    public List<Suite> getAll(){
        return suiteService.queryAllSuite();
    }

    @RequestMapping("/type")
    @ResponseBody
    public List<Suite> getType(String type) {
        return suiteService.querySuiteByType(type);
    }

    @RequestMapping("/num")
    @ResponseBody
    public Suite getNum(int num){
        return suiteService.querySuiteByNum(num);
    }

    @RequestMapping(value  = "/add",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String add(@RequestBody Suite suite){
        System.out.println(suite);
        if(suiteService.addSuite(suite)){
            return "200";
        }
        return "100";
    }

    @RequestMapping(value  = "/submit",method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public String submit(@RequestBody Suite suite){
        if(suiteService.updateSuiteById(suite)){
            return "200";
        }
        return "100";
    }

    @RequestMapping("/EndUpdate")
    @ResponseBody
    public String endUp(int id){
        suiteCache.put(id, new onlySuite(id));
        return "200";
    }
}
