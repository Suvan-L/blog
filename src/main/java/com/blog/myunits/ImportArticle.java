package com.blog.myunits;

import com.blog.entity.Article;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 导入文件目录下所有文章
 *
 * @Author Liu-shuwei
 * @Date 17.6.14
 */
public class ImportArticle {
    /*测试主函数*/
    public static void main(String[] args) {
        //E:\Java\Intellij IDEA\项目\My_Blog\src\main\webapp\file\_posts
        List<Article> articleList = getAllArticle("src\\main\\webapp\\file\\_posts");
        for(Article a: articleList){
            System.out.println(a.toString());
        }
    }


    /*读取文件*/
    public static List<Article> getAllArticle(String pathFileName){
        List<Article> articleList = new ArrayList<Article>();       //用与保存文章列表

        File file = new File(pathFileName);

        if(file.isDirectory()){
            File [] fileList = file.listFiles();
            FileReader fileReader = null;
            LineNumberReader lineNumberReader = null;      //对Reader进行装饰的装饰类，该装饰类能返回和设置行号
            BufferedReader bufferedReader = null;          //文件缓冲输入流[读取FileRead读取时需要+文件名]

            int line;                                      //文件当前行号
            String tmpStr = "";                            //保存临时内容
            StringBuilder sb = new StringBuilder();        //储存文章内容
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String title = null;                           //文章标题
            String date = null;                            //日期
            String tags = null;                            //标签
            String categories = null;                      //类型
            Article article = null;                        //文章对象

            try{
                for(File f:fileList){

                    //1.定义
                    fileReader = new FileReader(file + "/" + f.getName());
                    lineNumberReader = new LineNumberReader(fileReader);


                    //2.读取前6行[起始坐标为0]【稳住导航】
                    while ((line =lineNumberReader.getLineNumber()) <= 5) {
                        tmpStr = lineNumberReader.readLine();
                        if(ifExistString(tmpStr,"title")){
                            title = subColonLastString(tmpStr);
                        }else if(ifExistString(tmpStr,"date")){
                            date = subColonLastString(tmpStr);
                        }else if(ifExistString(tmpStr,"tags")){
                            tags = subColonLastString(tmpStr);
                        }else if(ifExistString(tmpStr,"categories")){
                            categories = subColonLastString(tmpStr);
                        }
                    }

                    //3.读取剩余内容【文章内容】
                    while ((tmpStr = lineNumberReader.readLine()) != null){
                        sb.append(tmpStr + "\n"); //换行
                    }

                    //4.构造文章对象
                    article = new Article();
                        article.setTitle(title);
                        article.setContent(sb.toString());
                        article.setCategories(categories);
                        article.setUserId(1);


                        Date d = sdf.parse(date);    //文章日期【没设置的话,默认是插入时间】
                        article.setPublictime(d);

                    //5.储存进List<Article>集合
                    articleList.add(article);


                    //6.还原数据
                    sb.delete( 0, sb.length());     //清空StringBuilder
                }


                //4.关闭流
                if(fileReader != null){
                    fileReader.close();
                }
                if(lineNumberReader != null){
                    lineNumberReader.close();
                }
                if(bufferedReader != null){
                    bufferedReader.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        return  articleList;
    }

    /*判断是否存在指定字符串*/
    public static boolean ifExistString(String str,String existStr){
        return  str.indexOf(existStr) != -1;
    }
    /*截取：(冒号)以后的字符*/
    public static String subColonLastString(String str){
        return str.substring(str.indexOf(":")+1).trim();
    }
}
