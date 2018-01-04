package com.blog.myunits;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie操作
 *
 * @Author Liu
 * @Date 2017/9/12
 */
public class CookieUtils {


    /*插入Cookie*/
    public static void insertCookie(HttpServletResponse response, String CookieName, String CookieValue) {

        Cookie cookie = new Cookie(CookieName,CookieValue);
            cookie.setMaxAge( 7 *24 * 60 * 60);			//7天Cookie
            cookie.setPath("/");  //如果不设置cookie的path，会默认设为当前路径，所以最好统一设置一个path，否则登出时可能会发现并没有删除登录时的cookie。
            cookie.setHttpOnly(true);		//将Cookie设置成HttpOnly[指示浏览器不要在除HTTP（和 HTTPS)请求之外暴露Cookie],防止XSS攻击【跨站点脚本攻击(例如js引用document.cookie0】
            //cookie.setSecure(true); 			//使用加密传输(使用后Cookie会被加密)

        response.addCookie(cookie);
    }

    /*删除Cookie*/
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String CookieName){
        for(Cookie c: request.getCookies()){
            if(CookieName.equals(c.getName())){
                c.setMaxAge(0); //周期设置为0,即等于删除
                c.setPath("/");
                c.setHttpOnly(true);

                response.addCookie(c);
            }
        }
    }

    /*打印Cookie*/
    public static void printCookie(HttpServletRequest request){
        int count = 1;
        for(Cookie c: request.getCookies()){
            System.out.println((count++)+".CookieName："+ c.getName() + "\t----CookieValue:"+ c.getValue());
        }
    }

    /*判断是否存在Cookie*/
    public static Cookie existCookie(HttpServletRequest request,String cookieName){
        for(Cookie c: request.getCookies()){
            if(cookieName.equals(c.getName())){
                return c;//存在则返回相应Cookie
            }
        }

        return null;
    }
}
