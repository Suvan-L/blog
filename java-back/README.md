
# 个人博客系统
![image](https://github.com/Suvan-L/blog/blob/master/src/main/webapp/img/index_Screenshot.png)
![image](https://github.com/Suvan-L/blog/blob/master/src/main/webapp/img/register_Screenshot.png)


## 后端
+ IDE: IntelliJ IDEA 2016.3.5
+ Java: jdk1.8.0_65
+ 服务器：Tomcat-8.0.41
+ 项目管理(本地仓库管理依赖)：maven-3.3.9
+ 版本控制：Github Git2.7.2.0
+ 数据库：MySQL57

## 前端
+ 归档页：Bookstrap(栅格系统)
+ 后台管理：Layui
+ 其余页面: html + css + jQuery

# 目录结构
```
blog                                                                                                                                            
├─src                             【java源码】                                                  
│  ├─main                                                      
│  │  ├─java                                                   
│  │  │  └─com                                                 
│  │  │      └─blog                                            
│  │  │          ├─controller                【控制器包】                 
│  │  │          │  ├─filter                    【过滤器包】                 
│  │  │          │  └─interceptor               【拦截器包】                 
│  │  │          ├─dao                       【DAO接口包】                  
│  │  │          ├─entity                    【实体包】         
│  │  │          ├─exception                 【异常包】                  
│  │  │          ├─extend                    【扩展包】                                         
│  │  │          ├─myunits                   【个人工具包】                                             
│  │  │          ├─reptile                   【爬虫包】                             
│  │  │          └─service                                     
│  │  │              └─impl                                    
│  │  ├─resources                                              
│  │  │  └─mapping                                             
│  │  └─webapp                                                 
│  │      ├─css                                                
│  │      ├─extend                                                                               
│  │      ├─file                                                                                    
│  │      ├─frame                            【前端框架与库】                                                
│  │      │  ├─bootstrap-3.3.7-dist                                                            
│  │      │  ├─jQuery                                          
│  │      │  └─layui                                                                        
│  │      ├─img                                                                    
│  │      ├─js                                                 
│  │      ├─music                                              
│  │      └─WEB-INF                                            
│  │          ├─jsp                          【jsp页面】                  
│  │          └─lib                          【编译后jar包】                 
│  └─test                          【jUnit测试用例】                                       
```

# 数据库设计
+ 用户表
+ 评论表
+ 文章表
