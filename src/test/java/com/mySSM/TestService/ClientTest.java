package com.mySSM.TestService;


import com.mySSM.Utils.DateUtil;
import com.mySSM.pojo.Client;
import com.mySSM.service.Impl.ClientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class ClientTest {

    @Autowired
    ClientServiceImpl clientService;

    @Test
    public void add(){
        if(clientService.addClient(new Client("吴家聪","男","123456789012345678","12345678901","白银","",DateUtil.getNowDate()))) {
            System.out.println("添加客户成功");
        }else {
            System.out.println("添加客户失败");
        }
    }

    @Test
    public void selectID(){
        if(clientService.queryClientById(1) != null){
            System.out.println("查询客户成功");
        }else{
            System.out.println("查询客户失败");
        }
    }

    @Test
    public void selectName(){
        if(clientService.queryClientByName("贤哲") != null){
            System.out.println("查询客户成功");
        }else{
            System.out.println("查询客户失败");
        }
    }

    @Test
    public void selectCard(){
        if(clientService.queryClientByCard("123456789012345678") != null){
            System.out.println("查询客户成功");
        }else{
            System.out.println("查询客户失败");
        }
    }

    @Test
    public void getAll(){
        if(clientService.SelectAll() != null){
            System.out.println("查询客户成功");
        }else{
            System.out.println("查询客户失败");
        }
    }


    @Test
    public void deleteID(){
        if(clientService.DeleteClientById(1)){
            System.out.println("删除客户成功");
        }else {
            System.out.println("删除客户失败");
        }
    }

    @Test
    public void deleteCard(){
        if(clientService.DeleteClientByCard("123456789012345678")){
            System.out.println("删除客户成功");
        }else {
            System.out.println("删除客户失败");
        }
    }

    @Test
    public void update(){
        if(clientService.UpdateClient(new Client("贤哲","男","123456789012345678","12345678901",""))){
            System.out.println("更新客户成功");
        }else {
            System.out.println("更新客户失败");
        }
    }

    @Test
    public void updateIntegral(){
        if(clientService.setIntegral("123456789012345678",400)){
            System.out.println("更新客户成功");
        }else {
            System.out.println("更新客户失败");
        }
    }

    @Test
    public void updateVIP(){
        if(clientService.setVIP("123456789012345678","白金")){
            System.out.println("更新客户成功");
        }else {
            System.out.println("更新客户失败");
        }
    }

}
