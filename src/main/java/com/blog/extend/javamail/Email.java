package com.blog.extend.javamail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Date;

/**
 *  POJO对象,储存邮箱信息
 *
 * @Author Suvan
 * @Date 2017-05-29-21:17
 */
public class Email {
    private String username;                    //发送者地址
    private String pensonalName;               //发信人名称[可自定义]
    private String authorizationCode;        //授权码
    private String recipients;                 //收件人
    private String subject;                    //主题
    private String text;                       //文本内容
    private String content;                    //HTML内容
    private Date sendDate;                     //发送日期
    private String propertiesWay;               //连接方式[163和qq邮箱都是默认,gmail可选择SSL或者TSL]

    //授权信息
    private Authenticator authenticator = new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            //填写自己163邮箱的登录账户和授权密码
            return new PasswordAuthentication(username, authorizationCode);
        }
    };


    //Getter
    public String getUsername() {
        return username;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public String getRecipients() {
        return recipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String getContent() {
        return content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public String getPropertiesWay() {
        return propertiesWay;
    }

    public String getPensonalName() {
        return pensonalName;
    }

    //Setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public void setPropertiesWay(String propertiesWay) {
        this.propertiesWay = propertiesWay;
    }

    public void setPensonalName(String pensonalName) {
        this.pensonalName = pensonalName;
    }
}