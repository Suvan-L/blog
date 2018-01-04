package com.blog.exception;

/**
 * 自定义异常：注册失败异常
 *
 * @Author Suvan
 * @Date 2017-06-03-20:33
 */
public class RegisterFailException extends Exception {
    int data; //储存异常数据

    public RegisterFailException(){               //无参构造器
        super();
    }
    RegisterFailException(int data,String message){  //有参构造器
        super(message);
    }
}
