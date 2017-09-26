package com.blog.dao;

import com.blog.entity.Article;

import java.util.List;


/**
 * IArticle接口对象
 *
 * @Author Suvan
 * @Date 2017-05-19-9:43
 */
public interface IArticleDao {

   int insertArticle(Article article);

   int deleteArticle(Integer articleId);

   Article selectArticleById(Integer articleId);
   List<Article> selectReverseFiveArticle();
   List<Article> selectUserAllArticle(Integer userId);
   List<Article> selectByUserIdByCategoryAllArticle(Integer userId,String categories);

   int updateArticle(Article article);
   int updateByIdArticleReadAddOne(Integer articleId);//阅读数+1
}
