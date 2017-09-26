package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.Comment;
import com.blog.service.IArticleService;
import com.blog.service.ICommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Article控制器
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource
	private IArticleService articleService;
	@Resource
	private ICommentService commentService;

	//定义
	static private String basePath;



	 /************************************返回数据(JSON,Text)*****************************************/
	/*【获取文章】*/
	@RequestMapping(value = "/getArticle/{articleId}",method = RequestMethod.GET)
	public @ResponseBody Article getArticle(@PathVariable Integer articleId){

		Article article = articleService.selectArticle(articleId);

		return article;
	}

	/*【获取文章列表[最新发布的5篇文章]】*/
	@RequestMapping(value = "/getArticleList_list5",method = RequestMethod.GET)
	public @ResponseBody List<Article> getArticleList(){

		List<Article> articleList = articleService.selectReverseFiveArticle();

		return articleList;
	}

	/*【获取指定文章的所有评论】*/
	@RequestMapping(value = "/getComments",params = "articleId",method = RequestMethod.GET)
	public @ResponseBody List<Comment> getComments(@RequestParam(value="articleId")String articleId){	//参数：文章id

		List<Comment> commentList = commentService.selectArticleAllComment(Integer.parseInt(articleId));

		return commentList;	//返回所有评论呢
	}

	/*【文章页+文章阅读数+1】*/
	@RequestMapping(value = "/updateArticleReadInsert1/{articleId}",method = RequestMethod.GET)
	public @ResponseBody Integer updateArticleReadInsert1(@PathVariable Integer articleId){
		//文章阅读数+1
		Integer result = articleService.updateByIdArticleReadAddOne(articleId);

		return result;
	}


	/*【更新评论的列值列值】(用于修改点赞反对数)*/
	@RequestMapping(value = "/updateCommentColumnValue",produces="text/html;charset=UTF-8",method = RequestMethod.GET)
	public @ResponseBody String updateCommentColumnValue(@RequestParam(value = "commentId")Integer commentId,	//参数:评论id,列名,修改值
														 @RequestParam(value = "columnName")String columnName,
														 @RequestParam(value = "value")String value){
		int result = commentService.updateCommentColumnValue(commentId, columnName, value);
		if(result == 0){
			return "更新失败";
		}
		return "更新成功";
	}

	/*【插入新评论】*/
	@RequestMapping(value = "/insertComment",method = RequestMethod.GET)
	public @ResponseBody Comment insertComment(@RequestParam(value = "commentContent")String commentContent,//参数:,评论内容,文章id,评论用户id
											   @RequestParam(value = "articleId")Integer articleId,
											   @RequestParam(value = "commentUserId")Integer commentUserId){
		Comment comment = new Comment();
		comment.setContent(commentContent);
		comment.setAgree("0");
		comment.setOppose("0");
		comment.setArticleId(articleId);
		comment.setUserId(commentUserId);

		commentService.insertComment(comment);
		Comment newComment = commentService.selectArticleLastComment(articleId);



		return newComment;
	}
}
