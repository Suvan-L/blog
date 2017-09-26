package test.com.blog;

import com.alibaba.fastjson.JSON;
import com.blog.entity.HighClassMastes;
import com.blog.service.IHighClassMastesService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 *  highclassmastes
 *
 * @Author Suvan
 * @Date 2017-07-09
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类[配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit]
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestHighClassMastes {

    private static Logger logger = Logger.getLogger(TestHighClassMastes.class); //将此类加入日志

    @Resource
    IHighClassMastesService highClassMastesService;

    //插入数据
    @Test
    public void testInsertHighClassMastes(){
        HighClassMastes user = new HighClassMastes();
             user.setName("哈哈哈哈");
             user.setPhone("12312");
             user.setCity("深圳");
             user.setArea("广东");
             user.setPostCode("519112");
             user.setJoin("是");
             user.setTraffic("自驾");
             user.setMoney("2000");


        highClassMastesService.insertHighClassMastes(user);

        logger.info("插入成功");  //打印语句
    }

    //删除数据
    @Test
    public void testDeleteHighClassMastes(){

        highClassMastesService.deleteHighClassMastes(1);
        logger.info("删除成功");
    }

    //查询数据
    @Test
    public void testSelectHighClassMastes(){
        String name = "哈哈哈哈";
        HighClassMastes user = highClassMastesService.selectHighClassMastes(name);
        logger.info("查询数据:"+JSON.toJSONString(user));
    }

    //@Test
    //public void testSelectAllMessage(){
    //    List<HighClassMastes> clist = highClassMastesService.selectAllMessage();
    //
    //    //导出到Excel表
    //    UseExcel useExcel = new UseExcel();
    //    try{
    //        useExcel.eportClassMastesMessage("C:\\Users\\Liu-shuwei\\Desktop\\用户表.xls",clist);
    //    }catch (Exception e){
    //        e.printStackTrace();
    //    }
    //}


}
