package com.blog.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  首页拦截器
 *
 * @Author Suvan
 * @Date 2017-09-12 00:08
 */
public class IndexInterceptor implements HandlerInterceptor{

    //执行前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
        System.out.println("IndexInterceptor******************preHandle()");


        //1.获取Session
        Boolean loginState = (Boolean)request.getSession().getAttribute("loginState");
        if(loginState == null){

            //2.判断Cookie,是否自动登录
            Cookie[] cookies = request.getCookies();
            String username = null;
            String password = null;

            for(int i = 0,len = cookies.length; i < len; i++){
                if("blogUserNameCookie".equals(cookies[i].getName())){
                    username = cookies[i].getValue();
                }
                if("blogPasswordCookie".equals(cookies[i].getName())){
                    password = cookies[i].getValue();
                }
            }

            //System.out.println(username+"-"+password);
            if(username != null && password != null){
                request.getSession().setAttribute("loginState",true); //有Cookie的话添加Session登录状态
                //response.sendRedirect("/blog/login"); //跳到登录页面进行登录
            }
        }


        return true;  //true-下一步(跳到指定页面),false-请求拦截诶(空白页)
    }

    //执行后
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        //System.out.println("IndexInterceptor******************postHandle()");
    }



    //请求完成后
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        //System.out.println("IndexInterceptor******************afterCompletion()");
    }
}
