package com.blog.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 评论实体类(对应comment表)
 *
 * @Author Suvan
 * @Date 2017-05-20-10:59
 */
public class Comment {
    private Integer id;             //评论id(无setter)
    private String content;         //内容
    private String agree;           //赞同数
    private String oppose;          //反对数

    private Integer articleId;      //文章id
    private Integer userId;         //用户id

    @JsonFormat(pattern="yyyy年MM月dd日 HH:mm",timezone = "GMT+8")   //SpringMVC返回的JSON格式日期是时间戳,需要转换
    private Date publictime;       //发布时间(无setter)【java.sql.Date只能取到日期,不能取到时间】

    //Getter
    public Integer getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
    public Date getPublictime(){
        return publictime;
    }
    public String getAgree(){
        return agree;
    }
    public String getOppose(){
        return oppose;
    }
    public Integer getArticleId(){
        return articleId;
    }
    public Integer getUserId(){
        return userId;
    }

    //Setter
    //public void setId(Integer id){
    //    this.id = id;
    //}
    public void setContent(String content){
        this.content = content;
    }
    public  void setAgree(String agree){
        this.agree = agree;
    }
    public void setOppose(String oppose){
        this.oppose = oppose;
    }
    public void setArticleId(Integer articleId){
        this.articleId = articleId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    //public void setPublictime(Date publictime){
    //    this.publictime = publictime;
    //}
}
/*
    CREATE TABLE comment(
        c_id INT  AUTO_INCREMENT primary key,
        c_content VARCHAR(300)  NOT NULL,
        c_agree VARCHAR(10) default '0',
        c_oppose VARCHAR(10) default '1',
        a_id INT,
        u_id INT,
        c_publictime DATETIME DEFAULT NOW()
        )ENGINE = innoDB;
*/