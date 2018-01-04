package com.blog.service;


import com.blog.entity.Comment;

import java.util.List;

/**
 * @Author Suvan
 * @Date 2017-05-21-15:51
 */
public interface ICommentService {

    public void insertComment(Comment comment);     //插入评论

    public void deleteComment(int commentId);       //删除评论
    
    public Comment selectComment(int commentId);    //查询评论
    public Comment selectArticleLastComment(int articleId);         //查询文章最新的评论
    public List<Comment> selectArticleAllComment(int articleId);    //查询文章所有评论

    public String updateComment(Comment Comment);   //更新评论
    public int updateCommentColumnValue(Integer commentId,String columnName,String value); //更新评论列值
}
