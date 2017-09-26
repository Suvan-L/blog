package test.com.blog;

import com.alibaba.fastjson.JSON;
import com.blog.entity.Article;
import com.blog.myunits.ImportArticle;
import com.blog.service.IArticleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *  测试Article表的增删查改
 *
 * @Author Suvan
 * @Date 2017-05-21-11:12
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestArticle {

    private static Logger logger = Logger.getLogger(TestArticle.class); //将此类加入日志

    @Resource
    IArticleService articleService;


    @Test/*插入文章*/
    public void testInsertArticle(){
        Article article = new Article();
            article.setTitle("第6666篇文章");
            article.setContent("内容很多....");
            article.setCategories("MyProject");
            article.setUserId(2);

            articleService.insertArticle(article);
            logger.info("插入成功 -> " + JSON.toJSONString(article));  //打印语句
    }


    @Test/*将指定目录下的文章,批量插入数据库*/
    public void testInsertAllArticle(){
        //1.从本地磁盘获取文章
        List<Article> articleList =  ImportArticle.getAllArticle("src\\main\\webapp\\file\\_posts");

        //2.将文章
        for(Article a:articleList){
            articleService.insertArticle(a);
            System.out.println(a.getTitle() + "————> 已入库");
        }
    }


    @Test/*删除id文章*/
    public void testDeleteArticle(){
        articleService.deleteArticle(1);

        logger.info("成功删除id为1的文章！");
    }


    @Test/*查询id文章*/
    public void testSelectArticle(){
        Article article = articleService.selectArticle(2);
        logger.info("查询文章(id为2) -> "+JSON.toJSONString(article));
    }


    @Test/*查询倒序5篇文章*/
    public void testSelectReverseFiveArticle(){
        List<Article> articleList = articleService.selectReverseFiveArticle();
        for(Article a:articleList){
            System.out.println("已查询文章————>" + a.getTitle());
        }
    }

    @Test/*查询指定用户所有文章*/
    public void testSelectUserAllArticle() {
        List<Article> articlelist = articleService.selectUserAllArticle(1);
        logger.info("查询指定用户(userId=1)所有文章————>" + JSON.toJSONString(articlelist));
    }

    @Test/*查询指定用户ID和类别的所有文章*/
    public void testSelectCategoriesArticle(){
        List<Article>  articleList = articleService.selectByUserIdByCategoryAllArticle(1,"BAT");
        logger.info("查询用户ID=1,类别为BAT的所有文章————>" + JSON.toJSONString(articleList));
    }


    @Test/*更新文章*/
    public void testUpdateArticle(){
        Article newArticle = new Article();
            newArticle.setId(121);     //更新指定id的文章
            newArticle.setTitle("我是第二篇");
            newArticle.setContent("哈哈哈");

        String resultMessage = articleService.updateArticle(newArticle);
        logger.info(resultMessage + "----" + JSON.toJSONString(newArticle));
    }

    @Test/*更新文章阅读数+1*/
    public void testUpdateByIdArticleReadAddOne(){
        int result = articleService.updateByIdArticleReadAddOne(2); //阅读数+1
        logger.info("\nid为2的文章阅读数+1,更新结果:  ————>更新了" +  result + "条记录");
    }
}
