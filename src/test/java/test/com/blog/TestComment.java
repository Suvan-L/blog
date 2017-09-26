package test.com.blog;

import com.alibaba.fastjson.JSON;
import com.blog.entity.Comment;
import com.blog.service.ICommentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *  测试Comment表
 *
 * @Author Suvan
 * @Date 2017-05-21-11:12
 */
@RunWith(SpringJUnit4ClassRunner.class)		  //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestComment {

    private static Logger logger = Logger.getLogger(TestComment.class); //将此类加入日志

    @Resource
    ICommentService commentService;


    @Test
    public void testInsertComment(){
        Comment comment = new Comment();
            comment.setContent("挺好的");
            comment.setAgree("12");
            comment.setOppose("84");
            comment.setArticleId(1);
            comment.setUserId(3);

        commentService.insertComment(comment);
        logger.info("插入成功 -> " + JSON.toJSONString(comment));  //打印语句
    }

    @Test
    public void testDeleteComment(){
        commentService.deleteComment(1);

        logger.info("成功删除评论！");
    }

    @Test
    public void testSelectComment(){
        Comment comment = commentService.selectComment(2);
        logger.info("查询评论 -> "+JSON.toJSONString(comment));
    }
    @Test
    public void testSelectArticleLastComment(){
        Comment comment = commentService.selectArticleLastComment(15);
        logger.info("查询评论 -> "+JSON.toJSONString(comment));
    }
    @Test
    public void testSelectArticleAllComment(){
        List<Comment> commentList = commentService.selectArticleAllComment(1);
        logger.info("查看该文章所有评论 -> "+JSON.toJSONString(commentList));
    }

    @Test
    public void testUpdateComment(){
        Comment newComment = new Comment();
            //newComment.setId(2);                //指定id的文章进行更新
            newComment.setContent("这个相当差啊1111");


        String info = commentService.updateComment(newComment);
        logger.info(info + "----" + JSON.toJSONString(newComment));

    }
    @Test
    public void testUpdateCommentColumnValue(){
        int result = commentService.updateCommentColumnValue(2,"c_oppose","1000");
        logger.info("更新结果----" + result);
    }

}
