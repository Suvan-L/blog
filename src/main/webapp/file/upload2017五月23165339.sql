
/*
 * 一.自己新建数据库【在数据库里执行下列SQL脚本】
 *      数据库名：myblog
 *      字符集：  utf8--UTF-8 Unicode
 *      排序规则: utf8_general_ci
 *  
 *  SQL语句：
 *     CREATE DATABASE myblog;   
 */


/*
 * 二.建表
 */
-- 1.用户表
CREATE TABLE user(             
        u_id INT  AUTO_INCREMENT primary key,   /*[用户id(自增)]*/
        u_name VARCHAR(19) UNIQUE KEY,          /*[用户名唯一]*/
        u_password VARCHAR(15) NOT NULL,        /*[密码]*/
        u_sex  VARCHAR(2) NOT NULL,             /*[性别]*/
        u_birthday VARCHAR(20) NOT NULL,        /*[出生年月日]*/
        u_address VARCHAR(15)  NOT NULL,        /*[所在地]*/
        u_phone VARCHAR(15) NOT NULL,           /*[手机]*/
        u_email  VARCHAR(20)  NOT NULL,         /*[邮箱]*/
        u_registertime DATETIME DEFAULT NOW()       /*[注册时间]*/
)ENGINE = innoDB;


-- 2.文章表
CREATE TABLE article(             
    a_id INT  AUTO_INCREMENT primary key,       /*[文章id(自增)]*/
    a_title VARCHAR(20) NOT NULL,               /*[标题]*/
    a_content VARCHAR(20000)  NOT NULL,         /*[内容]*/
    a_read VARCHAR(10),                         /*[阅读数]*/
    a_comment VARCHAR(10),                      /*[评论数]*/
    a_like  VARCHAR(10),                        /*[点赞数]*/
    u_id INT NOT NULL,                          /*[用户id]*/
    a_publictime  DATETIME DEFAULT NOW()        /*[发布时间]*/
)ENGINE = innoDB;


-- 3.评论表
CREATE TABLE comment( 
    c_id INT  AUTO_INCREMENT primary key,       /*[评论id[自增]]*/
    c_content VARCHAR(300)  NOT NULL,           /*[内容]*/
    c_agree VARCHAR(10),                        /*[同意数]*/
    c_oppose VARCHAR(10),                       /*[反对数]*/
    a_id INT,                                   /*[文章id]*/
    u_id INT,                                    /*[用户id]*/
    c_publictime DATETIME DEFAULT NOW()     /*[发布时间]*/
)ENGINE = innoDB;


/*
 * 三.插入测试数据
 */
#user表
insert into user(u_name,u_password,u_sex,u_birthday,u_address,u_phone,u_email) values('suvan','12345','男','2001-05-18','广东省佛山市南海区','13289966310','suvan@gmail.com');
insert into user(u_name,u_password,u_sex,u_birthday,u_address,u_phone,u_email) values('TOM','12345','女','1983-05-18','广东省深圳市罗湖区','1389128573','1389128573@163.com');
insert into user(u_name,u_password,u_sex,u_birthday,u_address,u_phone,u_email) values('瓜皮','12345','男','2001-05-18','广东省河源市龙川','18154876543','723583341@qq.com');

#article表
insert into article(a_title,a_content,a_read,a_comment,a_like,u_id) values('学习使我快乐','皮皮皮皮123','523','64','83','1');
insert into article(a_title,a_content,a_read,a_comment,a_like,u_id) values('看书吗','死亡开端还不错啦','56','2','23','2');
insert into article(a_title,a_content,a_read,a_comment,a_like,u_id) values('看书吗','死亡开端还不错啦','182','5','62','3');


#comment表
insert into comment(c_content,c_agree,c_oppose,a_id,u_id) values('不错','52','23','1','2');
insert into comment(c_content,c_agree,c_oppose,a_id,u_id) values('挺好的','892','673','1','1');
insert into comment(c_content,c_agree,c_oppose,a_id,u_id) values('很棒哦','5431','889','1','2');