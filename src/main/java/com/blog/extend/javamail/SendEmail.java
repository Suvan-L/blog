package com.blog.extend.javamail;


import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;


/**
 * 使用javaMail发送邮件【163邮箱,qq邮箱,gmail邮箱】
 *
 * @Author Suvan
 * @Date 2017-05-29-20:40
 */
public class SendEmail {
    /*个人邮箱*/
    public Properties getProperties_liushuwei(){
        Properties props = new Properties();

        props.setProperty("mail.host","mail.liushuwei.cn");      //网易smtp邮箱服务器
        return props;
    }

    /*网易邮箱连接参数【需要开启：POP3/SMTP服务 】*/
    public Properties getProperties_163(){
        Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");        //开启权限验证
            props.setProperty("mail.host","smtp.163.com");      //网易smtp邮箱服务器

        return props;
    }

    /*QQ邮箱连接参数【需要开启：POP3/SMTP服务 】*/
    public Properties getProperties_qq(){
        Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");        //开启权限验证
            props.setProperty("mail.host","smtp.qq.com");      //qq的smtp邮箱服务器
            props.setProperty("mail.transport.protocol", "smtp");

        //QQ邮箱的SSL加密
        MailSSLSocketFactory sf = null;
        try{
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        }catch (GeneralSecurityException e){
            e.printStackTrace();
        }

        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.ssl.socketFactory",sf);


        return props;
    }

    /*谷歌邮箱连接参数【需要开启：允许不够安全的应用】*/
    public Properties getProperties_gmail(String way){

        Properties props = new Properties();
        if("SSL".equals(way)){
            //1.SSL方式
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            props.put("mail.debug", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.auth", "true");
        }else{
            //2.TLS方式
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
        }

        return props;
    }


    /*发送邮件*/
    public void GO(Email email){  //Email对象
        try {
            //A-构建连接参数
            String username = email.getUsername();
            String emailServer = username.substring(username.indexOf("@")+1,username.lastIndexOf("."));
            Properties props = null;
            if("163".equals(emailServer)){
                props = getProperties_163();
            }else if("qq".equals(emailServer)){
                props = getProperties_qq();
            }else if("gmail".equals(emailServer)){
                props = getProperties_gmail("SSL");
            }else if("liushuwei".equals(emailServer)){
                props = getProperties_liushuwei();
            }


            //B.获取连接【获取默认会话对】
            Session mailSession = Session.getInstance(props, email.getAuthenticator()); //连接参数,授权信息

            //B-创建消息【获取MimeMessage对象】
            MimeMessage  msg = new MimeMessage(mailSession);

            //B-2.发件邮件 + 发信名称[没设置的话默认为空]
            String personalName =  email.getPensonalName();
            if (personalName != null){
                try{
                    msg.setFrom(new InternetAddress(email.getUsername(),personalName));
                }catch (UnsupportedEncodingException ue){ue.printStackTrace();}
            }else{
                msg.setFrom(new InternetAddress(email.getUsername())); //默认发信名称为：邮箱地址
            }



            /*B-3.收件人
             *    参数1：
             *      Message.RecipientType.TO  代表收件人(主要收件,能知道抄送给谁,不知道暗送)
             *      Message.RecipientType.CC  抄送
             *      Message.RecipientType.BCC 暗送
             *
             *    参数2：
             *      收件人地址 or 抄送or密送名单【群发-Address[]】
             */

            msg.setRecipient(MimeMessage.RecipientType.TO,
                             new InternetAddress(email.getRecipients()));

            //B-4.日期,主题,正文
            Date date = email.getSendDate();
            String text = email.getText();
            String content = email.getContent();

            if(date != null){
                msg.setSentDate(date);                                                 //日期
            }
            msg.setSubject(email.getSubject(), "UTF-8");                       //主题
            if(text != null){
                msg.setText(text, "UTF-8");                                    //文本内容
            }else if(content != null){
                msg.setContent(content,"text/html;charset=UTF-8");                       //HTML内容
            }

            msg.saveChanges();//保存更改

            //C-发送邮件
            Transport.send(msg);

            System.out.println("邮件发送成功........!");

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //String contentHTML = "<head>" +
        //        "<title>注册验证码</title>" +
        //        "</head>" +
        //        "<body>" +
        //        "<h1>您好,注册码是:" + 213123 + ",欢迎您注册博客</h1>" +
        //        "</body>";
        //Email email = new Email();
        //    email.setUsername("13202405189@163.com");
        //    email.setAuthorizationCode("sendemail123");
        //    email.setRecipients("425630933@qq.com");
        //    email.setSubject("第一篇");
        //    email.setContent("学习");

        //Email email = new Email();
        //    email.setUsername("526097449@qq.com");
        //    email.setAuthorizationCode("qq邮箱授权码");
        //    email.setRecipients("liuzhenxi@21cn.com");
        //    email.setSubject("第一篇");
        //    email.setText("123456");
        //
        //Email email = new Email();
        //email.setUsername("liushuwei0925@gmail.com");
        //email.setAuthorizationCode("liushuwei");
        //email.setRecipients("liuzhenxi@21cn.com");
        //email.setSubject("第二篇");
        //email.setText("asdfasdf");
        //
        //Email email = new Email();
        //email.setUsername("robot@liushuwei.cn");
        //email.setPensonalName("博客机器人");
        //email.setAuthorizationCode("密码");
        //email.setRecipients("526097449@qq.com");
        //email.setSubject("第二篇");
        //email.setText("asdfasdf");


        //SendEmail sendEmail  = new SendEmail();
        //sendEmail.GO(email);
    }
}
