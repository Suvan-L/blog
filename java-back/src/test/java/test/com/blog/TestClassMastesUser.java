package java.test.com.blog;

import com.alibaba.fastjson.JSON;
import com.blog.entity.ClassMastesUser;
import com.blog.myunits.UseExcel;
import com.blog.service.IClassMastesUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *  测试ClassMastesUser表
 *
 * @Author Suvan
 * @Date 2017-06-24
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类[配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit]
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestClassMastesUser {

    private static Logger logger = Logger.getLogger(TestClassMastesUser.class); //将此类加入日志

    @Resource
    IClassMastesUserService classMastesUserService;

    //插入数据
    @Test
    public void testInsertClassMastesUser(){
        ClassMastesUser user = new ClassMastesUser();
             user.setName("你好");
             user.setPhone("12312");
             user.setCity("深圳");
             user.setArea("广东");
             user.setPostCode("519112");


        classMastesUserService.insertClassMastesUser(user);

        logger.info("插入成功");  //打印语句
    }

    //删除数据
    @Test
    public void testDeleteClassMastesUser(){

        classMastesUserService.deleteClassMastesUser(1);
        logger.info("删除成功");
    }

    //查询数据
    @Test
    public void testSelectClassMastesUser(){
        String name = "哈哈哈哈";
        ClassMastesUser user = classMastesUserService.selectClassMastesUser(name);
        logger.info("查询数据:"+JSON.toJSONString(user));
    }

    @Test
    public void testSelectAllMessage(){
        List<ClassMastesUser> clist = classMastesUserService.selectAllMessage();

        //导出到Excel表
        UseExcel useExcel = new UseExcel();
        try{
            useExcel.eportClassMastesMessage("C:\\Users\\Liu-shuwei\\Desktop\\用户表.xls",clist);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
