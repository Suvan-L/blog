package com.blog.service.impl;

import com.blog.dao.ICommentDao;
import com.blog.entity.Comment;
import com.blog.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Author Suvan
 * @Date 2017-05-19-9:40
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService{

    @Resource
    private ICommentDao commentDao; //配置文件自动注入


    public void insertComment(Comment comment){
        commentDao.insert(comment);
    }
    public void deleteComment(int commentId){
        commentDao.deleteByPrimaryKey(commentId);
    }
    public Comment selectComment(int commentId){
        return commentDao.selectByPrimaryKey(commentId);
    }
    public Comment selectArticleLastComment(int articleId){
        return commentDao.selectArticleLastComment(articleId);
    }
    public List<Comment> selectArticleAllComment(int articleId){

        List<Comment> commentList =  commentDao.selectArticleAllComment(articleId);

        return  commentList;
    }
    public String updateComment(Comment comment){
        int result = commentDao.updateByPrimaryKeySelective(comment);
        if(result == 0){
            return "更新失败";
        }

        return "成功更新" + result + "条记录！";
    }
    public int updateCommentColumnValue(Integer commentId,String columnName,String value){
        return commentDao.updateCommentColumnValue(commentId,columnName,value);
    }
}
