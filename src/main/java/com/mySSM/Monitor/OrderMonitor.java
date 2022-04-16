package com.mySSM.Monitor;

import com.mySSM.Utils.DateUtil;
import com.mySSM.pojo.onlyCode;

import java.util.concurrent.ConcurrentHashMap;

public class OrderMonitor extends Thread{

    private static final OrderMonitor monitor = new OrderMonitor();

    private static ConcurrentHashMap<Integer, onlyCode> orderCache = new ConcurrentHashMap();

    public static ConcurrentHashMap<Integer, onlyCode> getOrderCache() {
        return orderCache;
    }

    public static OrderMonitor getMonitor(){
        monitor.start();
        return monitor;
    }

    public void run(){
        while (true) {
            for (Integer id : orderCache.keySet()) {
                if(DateUtil.isTimeOut(orderCache.get(id).getDate()) >= 2){
                    orderCache.remove(id);
                }
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
