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

    @RequestMapping("/all")
    @ResponseBody
    public List<Client> getAll(){
        return clientService.SelectAll();
    }

    @RequestMapping("/list")
    public String getList(){
        return "ClientList";
    }

}
