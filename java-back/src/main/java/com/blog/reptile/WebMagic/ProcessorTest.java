package com.blog.reptile.WebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class ProcessorTest implements PageProcessor{


	private static final String shop="https://item.jd.com/\\w+.html";
	private int count=0;								//统计爬虫爬取次数
	private long beginTime=System.currentTimeMillis();  //统计开始爬取的时间
	
	
	private Site site = Site.me()
			.setCharset("UTF-8")
			.setRetryTimes(1)
			.setSleepTime(1)
			.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
			.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.86 Safari/537.36")
			.addHeader("cookic", "smetk=MTQ5ODE4NTkzNy4zNDYwNzg5OQ%3D%3D; smesc=ODEwOWQ4M2RhNDk0OWJjMmFhMDk3ZjFiMmExODc5NmQ%3D; PHPSESSID=auam3qvq5o2r3svgn716i822g1; smecurrentPageUrl=aHR0cDovL3d3dy54aW5nZG9uZ2xpdS5jb20veHNob3cvbXlTY2VuZT9wYWdlTnVtPTE%3D; smeautoLogin=%7B%22uidString%22%3A%2267782dfd032661b7126797786ce3cfccc9c597d4%22%2C%22autoLoginToken%22%3A%22ded87897aeecc1e0adb0f3cc1087956e98d2388c%22%7D; Hm_lvt_4c8715d993463a0b6c1ee8e881275b26=1498179804,1498180400,1498186233,1498186272; Hm_lpvt_4c8715d993463a0b6c1ee8e881275b26=1498186272");


	public Site getSite() {
		return site;
	}

	public void process(Page page){
		System.out.println("************************第"+(++count)+"次*************已花费"+String.valueOf(((double)System.currentTimeMillis()-beginTime)/1000)+"秒*************************");
		System.out.println("============"+page.getHtml());


	
	}
	
	public static void main(String [] args){
		try{
		Spider.create(new ProcessorTest())
				.addUrl("http://www.xingdongliu.com/h5/myScene?pageNum=1")
				.thread(1)
				.run();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
