package com.blog.service;

import com.blog.entity.Article;

import java.util.List;

/**
 * @Author Suvan
 * @Date 2017-05-21-15:51
 */
public interface IArticleService {

    public void insertArticle(Article article);

    public void deleteArticle(int articleId);

    public Article selectArticle(int articleId);
    public List<Article> selectReverseFiveArticle();
    public List<Article> selectUserAllArticle(Integer userId);
    public List<Article> selectByUserIdByCategoryAllArticle(Integer userId, String categories);

    public String updateArticle(Article article);
    public int updateByIdArticleReadAddOne(Integer articleId);
}
