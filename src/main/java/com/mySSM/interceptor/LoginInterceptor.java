package com.mySSM.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class LoginInterceptor implements HandlerInterceptor {
    /**
     *preHandle( )：该方法在控制器的处理请求方法前执行，其返回值表示是否中断后续操作，返回 true 表示继续向下执行，返回 false 表示中断后续操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取请求的URL
        String url = request.getRequestURI();

        // 获取 session
        HttpSession session = request.getSession();

        // login.jsp或登录请求放行，不拦截
        if (url.indexOf("/Login") >= 0) {
            System.out.println("h2");
            return true;
        }
        if (url.indexOf("/error") >= 0) {
            return true;
        }
        if (url.indexOf("/again") >= 0) {
            //注销会话
            session.invalidate();
        }else {
            Object obj = session.getAttribute("user");
            if (obj != null) return true;
        }
        // 没有登录且不是登录页面，转发到登录页面
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    /**
     *afterCompletion( )：该方法在控制器的处理请求方法执行完成后执行，即视图渲染结束后执行，可以通过此方法实现一些资源清理、记录日志信息等工作
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }
    /**
     *postHandle( )：该方法在控制器的处理请求方法调用之后、解析视图之前执行，可以通过此方法对请求域中的模型和视图做进一步的修改
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }

}