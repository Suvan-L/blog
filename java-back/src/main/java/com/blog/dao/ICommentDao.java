package com.blog.dao;

import com.blog.entity.Comment;

import java.util.List;


/**
 * @Author Suvan
 * @Date 2017-05-19-9:43
 */
public interface ICommentDao {

    //添加
    int insert(Comment comment);

    //删除
    int deleteByPrimaryKey(Integer commentId);

    //查询
    Comment selectByPrimaryKey(Integer commentId);
    Comment selectArticleLastComment(Integer articleId);
    List<Comment>selectArticleAllComment(Integer articleId);

    //更新
    int updateByPrimaryKeySelective(Comment comment);
    int updateCommentColumnValue(Integer commentId,
                                 String columnName,
                                 String value);


}
