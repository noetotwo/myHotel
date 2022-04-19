package com.mySSM.TestService;

import com.mySSM.pojo.Suite;
import com.mySSM.pojo.User;
import com.mySSM.service.Impl.SuiteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class SuiteTest {

    @Autowired
    SuiteServiceImpl suiteService;

    @Test
    public void addSuite(){
        if(suiteService.addSuite(new Suite(888,"速8大床房",888,"未入住","",""))){
            System.out.println("添加成功");
        }else{
            System.out.println("权限不够");
        }
    }

    @Test
    public void deleteSuite(){
        if(suiteService.deleteSuiteByNum(new User("8","1",8),888)){
            System.out.println("删除成功");
        }else{
            System.out.println("权限不够");
        }
    }

    @Test
    public void updateSuite(){
        if(suiteService.updateSuiteById(new Suite(13,888,"速8大床房",998,"未入住","",""))){
            System.out.println("更新成功");
        }else{
            System.out.println("权限不够");
        }
    }

    @Test
    public void IDSelect(){
        if (suiteService.querySuiteById(58) != null){
            System.out.println("查询成功");
        }else{
            System.out.println("用户不存在");
        }
    }
    @Test
    public void AllSelect(){
        List<Suite> list = suiteService.queryAllSuite();;
        if (list != null){
            System.out.println("查询成功");
        }else{
            System.out.println("查询失败");
        }
    }

    @Test
    public void NumSelect(){
        if (suiteService.querySuiteByNum(888) != null){
            System.out.println("查询成功");
        }else{
            System.out.println("查询失败");
        }
    }

    @Test
    public void State(){
        if(suiteService.updateState(208,"已入住")){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }
    @Test
    public void isNull(){
        if(suiteService.isNull(208)){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }

}
