package com.mySSM.TestService;

import com.mySSM.pojo.User;
import com.mySSM.service.Impl.AdminServiceImpl;
import com.mySSM.service.Impl.LoginServiceImpl;
import com.mySSM.service.Impl.SuiteServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
//@RunWith是JUnit的一个注解, 用来告诉JUnit不要使用内置的方式进行单元测试, 而应该使用指定的类做单元测试 对于Spring单元测试总是要使用SpringJUnit4ClassRunner.class
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
//如果有多个配置文件他的value是接受一个String数组 String支持通配符
//@ContextConfiguration({"classpath:application.xml","classpath:spring-mvc.xml"})
//@ContextConfiguration("classpath:spring-*.xml")
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class AdminTest {
    @Autowired
    LoginServiceImpl loginService;

    @Autowired
    AdminServiceImpl adminService;


    Logger logger = Logger.getLogger(AdminTest.class);

    @Test
    public void Login(){
        if(loginService.Login("1","1")){
           logger.info("用户登录成功");
        }else{
            logger.info("用户没有登录成功");
        }
    }

    @Test
    public void adminSelect(){
        List<User> list = adminService.SelectAdmin(new User("3","1",6));
        if(list == null){
            System.out.println("用户无权查询");
        }else{
            System.out.println(list);
        }
    }

    @Test
    public void addAdmin(){
        if (adminService.addAdmin(new User("8","1",8),new User("3","1",1))){
            System.out.println("添加成功");
        }else{
            System.out.println("无权操作");
        }
    }

    @Test
    public void DeleteAdmin(){
        if (adminService.DeleteAdmin(new User("8","1",8),new User("3"))) {
            System.out.println("删除成功");
        }else{
            System.out.println("无权操作");
        }
    }

    @Test
    public void updateAdmin(){
        if (adminService.UpdateAdmin(new User("8","1",8),new User("3","1",6))) {
            System.out.println("更新成功");
        }else{
            System.out.println("无权操作");
        }
    }
}
