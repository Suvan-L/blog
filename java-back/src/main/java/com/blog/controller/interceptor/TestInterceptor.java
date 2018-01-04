package com.blog.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  测试拦截器
 *
 *      执行顺序
 *          1.FirstInterceptor     (preHandle)
 *          2.HandlerAdapter       (【适配器】handle)
 *          3.FirstInterceptor     (postHandle)
 *          4.DispatcherServlet    (【Controller里的映射方法】reader)
 *          5.FirstInterceptor     (afterCompletion)
 *
 * @Author Suvan
 * @Date 2017-05-22-23:03
 */
public class TestInterceptor implements HandlerInterceptor{

    //执行前
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        System.out.println("~~~~~~~~~~~~TestInterceptor拦截器-preHandle()");
        return true;  //返回true下一步才会执行
    }

    //执行后
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        System.out.println("~~~~~~~~~~~~TestInterceptor拦截器-postHandle()");
    }



    //请求完成后
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("~~~~~~~~~~~~TestInterceptor拦截器-afterCompletion()");
    }
}
