package com.blog.service.impl;

import com.blog.dao.IArticleDao;
import com.blog.entity.Article;
import com.blog.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *  IArticleService接口实现类
 *
 * @Author Suvan
 * @Date 2017-05-19-9:40
 */
@Service("articleService")
public class ArticleServiceImpl implements IArticleService{

    @Resource
    private IArticleDao articleDao;

    public void insertArticle(Article article){
        int result = articleDao.insertArticle(article);
    }

    public void deleteArticle(int articleId){
        int result = articleDao.deleteArticle(articleId);
    }

    public Article selectArticle(int articleId){
        return articleDao.selectArticleById(articleId);
    }

    public List<Article> selectReverseFiveArticle(){
        //1.获取文章列表
        List<Article> articleList =  articleDao.selectReverseFiveArticle();

        //2.字符处理
        String title = null;
        String content = null;
        for(Article a:articleList){

            title = a.getTitle();
            content = a.getContent();

            //2-A.标题只取15个字符
            if(title.length() >= 15){
                a.setTitle(title.substring(0,15) + "...");
            }

            //2-B.内容只取200个字符
            if(content.length() >= 200){
                content = content.substring(0,200).replace("=","").replace("-","");
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(content);

                a.setContent(m.replaceAll("")+ "......");
            }
        }

        return articleList;
    }


    public List<Article> selectUserAllArticle(Integer userId){
       return articleDao.selectUserAllArticle(userId);
    }

    public List<Article> selectByUserIdByCategoryAllArticle(Integer userId, String categories){
        return  articleDao.selectByUserIdByCategoryAllArticle(userId,categories);
    }


    public String updateArticle(Article article){
        int result = articleDao.updateArticle(article);

        if(result == 0){
            return "更新失败";
        }
        return "成功更新" + result + "条记录！";
    }

    public int updateByIdArticleReadAddOne(Integer articleId){
        return articleDao.updateByIdArticleReadAddOne(articleId);
    }
}
