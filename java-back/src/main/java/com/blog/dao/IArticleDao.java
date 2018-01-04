package com.blog.dao;

import com.blog.entity.Article;

import java.util.List;


public interface IArticleDao {
   int saveArticle(Article article);

   int removeArticle(Article article);

   int getArticleById(Integer id);
   List<Article> listReverseFiveArticle();
   List<Article> listUserAllArticleByUserId(Integer id);
   List<Article> listUserCategoryAllArticleByUserIdByCategory(Integer id, String categories);

   int updateArticle(Article article);
   int updateReadAddOneById(Integer id);
}

