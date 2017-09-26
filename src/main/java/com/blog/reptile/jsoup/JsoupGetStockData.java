package com.blog.reptile.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * jsoup获取行浪接口的股票数据
 *
 * @Author Liu-shuwei
 * @Date 17.6.28
 */
public class JsoupGetStockData {

    //获取股票数据
    public Map<String,String> getStockData(String stockCode){ //参数：股票代码
        //1.定义
        Map<String,String> stockMap = new HashMap<String, String>();
        Document doc = null;

        //2.获取数据
        try{
           doc = Jsoup.connect("http://hq.sinajs.cn/list=sz300059")
                       .ignoreContentType(true)  //[忽略请求类型]
                        .get();
        }catch (IOException e){
            e.printStackTrace();
        }

        //3.处理数据
        //String content = doc.
        System.out.println(doc.text());



        return stockMap;
    }
    //测试
    public static void main(String[] args) {
        JsoupGetStockData j  = new JsoupGetStockData();
        j.getStockData("sz300059");
    }
}
