package com.mySSM.Monitor;

import com.mySSM.Utils.DateUtil;
import com.mySSM.pojo.onlySuite;

import java.util.concurrent.ConcurrentHashMap;

public class SuiteMonitor extends Thread{
    private static final SuiteMonitor monitor = new SuiteMonitor();

    private static ConcurrentHashMap<Integer, onlySuite> suiteCache = new ConcurrentHashMap();

    public static ConcurrentHashMap<Integer, onlySuite> getSuiteCache() {
        return suiteCache;
    }

    public static SuiteMonitor getMonitor(){
        monitor.start();
        return monitor;
    }

    public void run(){
        while (true) {

            for (Integer id : suiteCache.keySet()) {
                if(DateUtil.isTimeOut(suiteCache.get(id).getDate()) >= 2){
                    suiteCache.remove(id);
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
