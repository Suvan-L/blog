package com.blog.controller.filter;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * index页过滤器
 *
 * @Author Suvan
 * @Date 2017-06-10-20:50
 */
public class IndexFilter implements Filter {

    public FilterConfig config;     //FilterConfig对象访问web.xml里初始化的参数


    /*初始化【容器加载时执行1次】*/
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("IndexFilter【init()】--->初始阶段");
        this.config = filterConfig;
    }



    /*执行过滤器【请求n次,执行n次】*/
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("IndexFilter【doFilter()】--->执行阶段");

        /*
          * servlet理论上可以处理多种形式的请求响应形式,http只是其中之一
          * HttpServletRequest, HttpServletResponse分别是ServletRequest和ServletResponse的子类,多了一些针对http协议的方法
          *  4个都是接口
        */
        //1.定义
        HttpServletRequest httprequest = (HttpServletRequest)request;
        HttpServletResponse httpresponse = (HttpServletResponse)response;
        HttpServletResponseWrapper httpresponsewrapper = new HttpServletResponseWrapper(httpresponse);


        ////2.判断是否执行index过滤器
        //String ableFilter = config.getInitParameter("ableFilter");//获取配置文件(web.xml)参数,判断过滤器是否有效
        //if (ableFilter.toUpperCase().equals("NO")) {    //NO表示过滤器无效,直接跳过,把请求传回过滤链
        //    chain.doFilter(request, response);  //检查过滤链是否还有其他filter,有就调用,没有就调用目标资源
        //    return;
        //}


            //Cookie myCookie = new Cookie("suvan", "123");
            //myCookie.setSecure(true);       //使用加密传输
            //myCookie.setHttpOnly(true);     //将Cookie设置成HttpOnly[指示浏览器不要在除HTTP（和 HTTPS)请求之外暴露Cookie],防止XSS攻击【跨站点脚本攻击(例如js引用document.cookie0】
            //                                //Servlet 2.5 API 不支持 cookie设置HttpOnly,Servlet3.0支持
            ////2.客户端添加Cookie
            //httpresponse.addCookie(myCookie);

        ////3.Cookie判断自动登录
        //Boolean automatocLogin = this.CookieAutomaticLogin(httprequest,httpresponse);
        //if(automatocLogin){
        //    httprequest.getRequestDispatcher("/index").forward(request,response);//http://localhost:8080/blog/index
        //}


        ////4.进入首页过滤
        String url = httprequest.getRequestURI();
        if (url.equals("/blog/")){ //localhost:8080/blog/ 是唯一入口
            //请求转发【服务器内请求】跳到首页
            httprequest.getRequestDispatcher("/index").forward(request,response);

            //请求重定向【服务器外请求】
            //httpresponsewrapper.sendRedirect("/index");
            return;
        }

        //
        //
        //System.out.println("输入无效链接("+url+")---------------------->请求仍然停留在IndexFilter");
    }

    /*销毁【容器销毁时执行1次】*/
    public void destroy() {
        System.out.println("IndexFilter--destroy()--->销毁");
        this.config = null;
    }


    /*Cookie自动登录*/
    public boolean CookieAutomaticLogin(HttpServletRequest httprequest,HttpServletResponse httpresponse){

        //1.搜索Cookie,判断是否自动登录
        Cookie[] cookies = httprequest.getCookies();

        for(Cookie c: cookies){
            System.out.println("Cookie\n【Name】:" + c.getName() +
                                     "\n【Value】:" + c.getValue());

            //3.满足自动登录条件
            if("suvan".equals(c.getName()) && "123".equals(c.getValue())){
                return true;
            }
        }

        //2.未搜索到相应Cookie
        return false;//无自动登录

    //    //1.构造Cookie
    //    Cookie myCookie = new Cookie("myRecord", "888888888");
    //    myCookie.setSecure(true);       //使用加密传输
    //    myCookie.setHttpOnly(true);     //将Cookie设置成HttpOnly[指示浏览器不要在除HTTP（和 HTTPS)请求之外暴露Cookie],防止XSS攻击【跨站点脚本攻击(例如js引用document.cookie0】
    //                                    //Servlet 2.5 API 不支持 cookie设置HttpOnly,Servlet3.0支持
    //    //2.客户端添加Cookie
    //    httpresponse.addCookie(myCookie);
    //
    //    //3.读取客户端Cookie
    //    Cookie[] cookies = httprequest.getCookies();
    //    for(int i = 0;i < cookies.length;i++){
    //        System.out.println("Cookie\n名字:" + cookies[i].getName() +
    //                            "\n值:" + cookies[i].getValue());
    //
    //        //可选删除指定Cookie
    //        if("myCookie".equals(cookies[i].getName())){
    //            cookies[i].setMaxAge(0);                    //有效期设置为0
    //            httpresponse.addCookie(cookies[i]);            //将cookie重新添加到响应头中
    //        }
    //    }
    }
}