package com.blog.reptile.WebMagic;

import com.blog.myunits.thread.ThreadPool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumTest {

	public static void main(String [] args){
		long begin = System.currentTimeMillis();

		try{

			//1.设置参数，获取浏览器对象【firefox浏览器】
			System.setProperty("webdriver.firefox.bin","D:\\生活杂件\\火狐\\firefox.exe"); //firefox浏览器程序，直接用System.setPropert方法设置webdriver.firefox.bin
			System.setProperty("webdriver.gecko.driver","E:\\浏览器驱动包【selenium】\\geckodriver.exe"); //firefox驱动包
			WebDriver driver = new FirefoxDriver();


			//2.访问目标网页
			driver.get("http://www.xingdongliu.com/user/loginPage");


			//3.登录
			Thread.sleep(2000);
			driver.findElement(By.id("account")).sendKeys("13631686001");
			driver.findElement(By.id("password")).sendKeys("960925");
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[6]/button")).click();


			//4.个人界面点击【快展】 -> 【数据采集】
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"nav-xshow\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div.scene-total:nth-child(3) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(5) > a:nth-child(2)")).click();


			//5.获取页面源代码
			Thread.sleep(2000);
			System.out.println(driver.getPageSource());


			driver.close();    //关闭Webdriver的当前窗口【方式1】
			driver.quit();		//退出Webdriver所有窗口【方式2】
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");  //结束进程s


		}catch(Exception e){
			System.out.println("抛出异常");
			e.printStackTrace();
		}

		long end = System.currentTimeMillis()-begin;
		System.out.println("*********************共花费："+end/1000+"秒****************************************");
	}
}
