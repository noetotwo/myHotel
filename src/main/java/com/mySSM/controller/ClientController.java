package com.mySSM.controller;

import com.mySSM.pojo.Client;
import com.mySSM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Client")
public class ClientController {

    @Autowired
    ClientService clientService;

    /**
     * 所有客户数据接口
     * @return
     */
    @RequestMapping("/all")
    @ResponseBody
    public List<Client> getAll(){
        return clientService.SelectAll();
    }

    /**
     * 客户全部数据页面的请求处理
     * @return
     */
    @RequestMapping("/list")
    public String getList(){
        return "ClientList";
    }

}

