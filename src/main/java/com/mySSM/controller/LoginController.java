package com.mySSM.controller;

import com.mySSM.pojo.User;
import com.mySSM.service.Impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
/**
 * @RestController 注解会使 springmvc 将返回的对象或者 Map自 动转 json 返回给前端（底层默认是使用jsckson来实现数据格式转换的
 */
@RequestMapping("/xian")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    /**
     *@ResponseBody 是用来响应数据的，如果是对象类型或者 Map 类型的方法，
     * 则 springmvc 会将结果对象转成 json 格式输出给前端。
     * （将 controller 的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到 response 对象的 body 区）
     *
     * @RequestBody 是用来接受request中body区的数据
     *
     * Login页面的数据处理
     */
    @RequestMapping(value = "/Login" ,method = RequestMethod.POST ,consumes="application/json")
    @ResponseBody
    public Map Login(@RequestBody User user, HttpSession session, HttpServletResponse response){
        Map map = new HashMap();
        if(loginService.Login(user.getName(), user.getPassword())){
            map.put("value","/xian/Home");
            map.put("username",user.getName());
            // 登录成功，将用户信息保存到session对象中
            session.setAttribute("user", user.getName());

            //将对象cookie转给jsp
            Cookie k1 = new Cookie("name",user.getName());
            k1.setSecure(true);
            response.addCookie(k1);
        } else {
            map.put("value","/xian/error");
        }
        return map;
    }

    @RequestMapping("/Home")
    public String getHomePage(){
        return "Home";
    }

    @RequestMapping("/error")
    public String getErrorPage(){
        return "error";
    }

    @RequestMapping("/EndLogin")
    public String EndLogin(HttpSession session){
        session.invalidate();
        return "End";
    }

    @RequestMapping("/again")
    public void again(){}
}
