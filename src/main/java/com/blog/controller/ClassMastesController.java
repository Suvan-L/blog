package com.blog.controller;

import com.blog.entity.ClassMastesUser;
import com.blog.entity.HighClassMastes;
import com.blog.extend.javamail.Email;
import com.blog.extend.javamail.SendEmail;
import com.blog.service.IClassMastesUserService;
import com.blog.service.IHighClassMastesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 同学会统计控制器【初中-高中】
 */
@Controller
public class ClassMastesController {

	@Resource
	private IClassMastesUserService classMastesUserService;
	@Resource
	private IHighClassMastesService highClassMastesService;


	String tempString = null;  //临时字符串

	//定义
	static private String basePath;

 /******************************【初中】同学会页面******************************/
 	/*验证用户名唯一*/
	 @RequestMapping(value = "/classmastesUserOnly",produces="text/html;charset=UTF-8",method = RequestMethod.GET)
	 public  @ResponseBody  String classmastesUserOnly(HttpServletRequest request){

		 String name = request.getParameter("username");

		 ClassMastesUser user =  classMastesUserService.selectClassMastesUser(name);

		 if(user==null){
		 	return "YES";	//用户名唯一
		 }

		 return "NO";		//用户名不唯一
	 }

	/*【填写资料页面】*/
	@RequestMapping(value = "/classmastes")
	public String toClassmates(HttpServletRequest request,Model model){
		//1.获取请求绝对路径【赋值到全局变量】
		this.basePath = request.getScheme()+"://"
				+request.getServerName()+":"
				+request.getServerPort()+
				request.getContextPath()+"/";

		//2.设置
		model.addAttribute("basePath",this.basePath);

		return "classmates";
	}

	/*【提交成功页面】*/
	@RequestMapping(value = "/toClassmatesSucess")
	public String toClassmatesSucess(HttpServletRequest request,Model model){


		//1.获取表单数据
		ClassMastesUser user = new ClassMastesUser();
			user.setName(request.getParameter("name"));
			user.setPhone(request.getParameter("phone"));
			user.setCity(request.getParameter("city"));
			user.setArea(request.getParameter("area"));
			user.setPostCode(request.getParameter("postCode"));
			user.setPublictime(new Date());

		//防止空提交
		if(user.getName() == null){
			return "error";
		}


		//2.查询数据库[防止重复]
		ClassMastesUser dataUser = classMastesUserService.selectClassMastesUser(user.getName());
		if(dataUser != null){
			classMastesUserService.deleteClassMastesUser(dataUser.getId()); //删除已有的
		}


		//3.存入数据库
		classMastesUserService.insertClassMastesUser(user);


		this.tempString = user.toString();
		new Thread(new Runnable() {
			@Override
			public void run() {
				//3.发送邮件
				Email email = new Email();
				email.setUsername("13202405189@163.com"); //liushuwei0925@gmail.com,13202405189@163.com.liushuwei0925@gmail.com robot@liushuwei.cn
				email.setPensonalName("博客机器人");
				email.setAuthorizationCode("sendemail123");  //网易授权码
				email.setRecipients("425630933@qq.com"); //425630933@qq.com,liuzhenxi@21cn.com
				email.setSubject("[初中同学]填写记录[初中同学会统计]");
				email.setText("\"提醒\"【初中同学会统计】提交信息   \n" + tempString);

				SendEmail sendEmail = new SendEmail();
				sendEmail.GO(email);
				tempString = null;  //清零

			}
		}).start();



		//4.设置视图参数
		model.addAttribute("basePath",this.basePath);
		model.addAttribute("user",user);

		return "classmastesSuccess";
	}

	/******************************【高中】同学会页面******************************/
 	/*验证用户名唯一*/
	@RequestMapping(value = "/highClassMastesOnly",produces="text/html;charset=UTF-8",method = RequestMethod.GET)
	public  @ResponseBody  String highClassMastesOnly(HttpServletRequest request){

		String name = request.getParameter("username");

		HighClassMastes user =  highClassMastesService.selectHighClassMastes(name);

		if(user==null){
			return "YES";	//用户名唯一
		}

		return "NO";		//用户名不唯一
	}

	/*【填写资料页面】*/
	@RequestMapping(value = "/highclassmastes")
	public String toHighClassmates(HttpServletRequest request,Model model){
		//1.获取请求绝对路径【赋值到全局变量】
		this.basePath = request.getScheme()+"://"
				+request.getServerName()+":"
				+request.getServerPort()+
				request.getContextPath()+"/";

		//2.设置
		model.addAttribute("basePath",this.basePath);

		return "highClassmates";
	}

	/*【提交成功页面】*/
	@RequestMapping(value = "/toHighClassmatesSucess")
	public String toHighClassmatesSucess(HttpServletRequest request,Model model){




		//1.获取表单数据
		HighClassMastes user = new HighClassMastes();
			user.setName(request.getParameter("name"));
			user.setPhone(request.getParameter("phone"));
			user.setCity(request.getParameter("city"));
			user.setArea(request.getParameter("area"));
			user.setPostCode(request.getParameter("postCode"));
			user.setJoin(request.getParameter("join"));
			user.setTraffic(request.getParameter("traffic"));
			user.setMoney(request.getParameter("money"));
			user.setPublictime(new Date());



		//防止空提交
		if(user.getName() == null){
			return "error";
		}

		//2.查询数据库[防止重复]
		HighClassMastes dataUser = highClassMastesService.selectHighClassMastes(user.getName());
		if(dataUser != null){
			highClassMastesService.deleteHighClassMastes(dataUser.getId()); //删除已有的
		}



		//3.存入数据库
		highClassMastesService.insertHighClassMastes(user);


		//this.tempString = user.toString();
		//new Thread(new Runnable() {
		//	@Override
		//	public void run() {
		//		//3.发送邮件
		//		Email email = new Email();
		//		email.setUsername("526097449@qq.com"); //liushuwei0925@gmail.com,13202405189@163.com.liushuwei0925@gmail.com robot@liushuwei.cn
		//		email.setPensonalName("博客机器人");
		//		email.setAuthorizationCode("hpfbqbujgkqhcbde");  //网易授权码,QQ邮箱授权码
		//		email.setRecipients("425630933@qq.com"); //425630933@qq.com,526097449@qq.com
		//		email.setSubject("[职中同学]填写记录");
		//		email.setText("\"提醒\"【职中同学会统计】提交信息   \n" + tempString);
        //
		//		SendEmail sendEmail = new SendEmail();
		//		sendEmail.GO(email);
		//		tempString = null;  //清零
        //
		//	}
		//}).start();



		//4.设置视图参数
		model.addAttribute("basePath",this.basePath);
		model.addAttribute("user",user);

		return "highClassmastesSuccess";
	}
}
