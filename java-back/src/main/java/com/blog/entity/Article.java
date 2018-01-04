package com.blog.entity;

import java.util.Date;

/**
 *  文章实体类(对应article表    )
 *
 * @Author Suvan
 * @Date 2017-05-20-10:48
 */
public class Article {
    private Integer id;             //文章id(无setter)
    private String title;           //标题
    private String content;         //内容
    private String categories;      //类型


    private String read;            //阅读数
    private String comment;         //评论数
    private String like;            //点赞数

    private Integer userId;         //用户id

    private Date publictime;        //发布时间【一般是从markdown里获取插入】


    //Getter
    public Integer getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public String getCategories() {
        return categories;
    }
    public  Date getPublictime(){
        return publictime;
    }
    public String getRead(){
        return read;
    }
    public String getComment(){
        return comment;
    }
    public  String getLike(){
        return like;
    }
    public Integer getUserId(){
        return userId;
    }

    //Setter
    public void setId(Integer id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }
    public void setRead(String read){
        this.read = read;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public void setLike(String like){
        this.like = like;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    public void setPublictime(Date publictime){
        this.publictime = publictime;
    }


    public String toString(){
        return "id=" + id + "\ntitle=" + title + "\ncontent=" + content +
                "\nread=" + read + "\ncomment=" + comment + "\nlike=" + like +
                "\npublictime=" + publictime;

    }
}

/*
    CREATE TABLE article(
        a_id INT  AUTO_INCREMENT primary key,
        a_title VARCHAR(50) NOT NULL,
        a_content LongText  NOT NULL,
        a_categories VARCHAR(20) NOT NULL,
        a_read VARCHAR(10) default '0',
        a_comment VARCHAR(10) default '0',
        a_like  VARCHAR(10) default '0',
        u_id INT NOT NULL,
        a_publictime  DATETIME DEFAULT NOW()
     )ENGINE = innoDB;
 */
