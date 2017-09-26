package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.extend.javamail.Email;
import com.blog.extend.javamail.SendEmail;
import com.blog.myunits.CookieUtils;
import com.blog.myunits.CreateRandomNumber;
import com.blog.service.IArticleService;
import com.blog.service.ICommentService;
import com.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Blog直接控制器(控制页面跳转)
 */
@Controller
public class BlogController {

	//定义
	@Resource
	private IUserService userService;
	@Autowired
	private IArticleService articleService;
	@Resource
	private ICommentService commentService;



	/************************************返回视图(一级页面)*****************************************/
	/*获取项目根路径*/
	private String getBastPath(HttpServletRequest request){
		//项目根路径：http://localhost:8080/blog
		return  request.getScheme() + "://" +
				request.getServerName()+":" +
				request.getServerPort()+
				request.getContextPath()+"/";
	}


	/*首页跳转*/
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		//1.获取数据
		List<Article> articleList = articleService.selectReverseFiveArticle();		//获取文章列表[最新发布的5篇文章]*

		//2.设置Model
		String basePath =getBastPath(request);

		model.addAttribute("articleList",articleList);
		model.addAttribute("basePath",basePath);


		//打印Cookie测试
		//CookieUtils.printCookie(request);


		//3.跳到index.jsp
		return "index";
	}



	/*登录页跳转*/
	@RequestMapping(value = "/login")
	public ModelAndView toLogin(HttpServletRequest request) throws Exception{

		//1.获取请求路径
		ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("login");
			modelAndView.addObject("basePath",getBastPath(request));


		return modelAndView;
	}



	/*注册页跳转*/
	@RequestMapping(value = "/register")
	public String toRegister(HttpServletRequest request,Model model) throws Exception{

		model.addAttribute("basePath",getBastPath(request));

		return "register";
	}


	/*归档页跳转*/
	@RequestMapping(value="/toArchiving",method = RequestMethod.GET)
	public String toarchiving(HttpServletRequest request,Model model) throws Exception{

		List<Article> articleList = articleService.selectUserAllArticle(1); //查询用户id为1所有文章

		//1.获取所有文章分类
		Set<String> categoriesSet = new HashSet<String>();//无序,去重
		for(Article a: articleList){
			categoriesSet.add(a.getCategories());
		}

		//2.获取总页数(在归档页进行"假分页")
		Integer totalPages = articleList.size()/18 + 1; // 71/20 ~~ 4
		Integer pageArticles = 18;				  //每页文章数量

		//3.设置参数,传入jsp页面
		model.addAttribute("articleList",articleList);
		model.addAttribute("categoriesSet",categoriesSet);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("pageArticles",pageArticles);
		model.addAttribute("basePath",getBastPath(request));

		return "archiving";
	}




	/*分类页跳转*/
	@RequestMapping(value = "/categories/{category}",method = RequestMethod.GET)
	public String toCategories(@PathVariable String category,
							   HttpServletRequest request,Model model) throws Exception{

		//1.获取文章列表(指定用户id和类别)
		List<Article> categoriesArticleList = articleService.selectByUserIdByCategoryAllArticle(1,category);
		Map<String,List<Article>> yearMap = new HashMap<String,List<Article>>(); //构建键值队(年份,文章列表)			//年份对应指定的文章列表
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String tmpYear = null;//储存临时年份


		//2.获取指定年份的列表
		for(Article a:categoriesArticleList){
			//2-A.获取文章年份
			tmpYear = sdf.format(a.getPublictime());

			//2-B.判断yearArticleMap是否存在对应年份key
			if(!yearMap.containsKey(tmpYear)){	//不存在年份则创建新的Key
				List<Article> alist = new ArrayList<Article>();
				yearMap.put(tmpYear,alist);
			}

			//2-C.将文章储存到指定年份集
			yearMap.get(tmpYear).add(a);
		}


		//3.视图传参
		model.addAttribute("category",category);          		//类型
		model.addAttribute("yearMap",yearMap);	//年份-文章集合
		model.addAttribute("basePath",getBastPath(request));	//绝对路径

		return "categories";
	}

	/*后台系统页跳转*/
	@RequestMapping(value="/toBackstage",method = RequestMethod.GET)
	public String tobackstage(HttpServletRequest request,Model model) throws Exception{

		model.addAttribute("basePath",getBastPath(request));

		return "backstage";
	}


	/*文件上传页跳转*/
	@RequestMapping(value = "/testupload")
	public String totestupload(HttpServletRequest request,Model model) throws Exception{

		model.addAttribute("basePath",getBastPath(request));

		return "testupload";
	}



	/************************************返回视图(二级页面)*****************************************/


	/*【文章页跳转】*/
	@RequestMapping(value="/toArticle/{articleId}",method = RequestMethod.GET)
	public String goArticle(@PathVariable Integer articleId,
							HttpServletRequest request,Model model) throws Exception{

		//1.获取数据
		Article article = articleService.selectArticle(articleId);      	   			//文章
		List<Comment> commentList = commentService.selectArticleAllComment(articleId);  //指定文章所有评论


		//2.设置
		model.addAttribute("Date",new Date());
		model.addAttribute("article",article);
		model.addAttribute("commentList",commentList);
		model.addAttribute("basePath",getBastPath(request));

		return "article";
	}


	/************************************功能性验证(二级页面)*****************************************/

	/*登录验证*/
	@RequestMapping(value="/login/loginCheck",method = RequestMethod.POST)
	public String loginCheck(@RequestParam(value="username",required = false)String username,   //不传入此参数则报错
							 @RequestParam(value="password",required = false)String password,
							 HttpServletRequest request, HttpServletResponse response,Model model) throws Exception{

		//1.空判断
		if(username == null || username.length() <= 0 || password == null || password.length() <= 0){

			model.addAttribute("warnMessage","帐号密码不能为空!,请根据提示输入信息");
			model.addAttribute("time",3);

			return "error";//跳到错误页面
		}

		//2.判断用户和密码
		User user = userService.selectUserByName(username);
		if(user == null){
			model.addAttribute("warnMessage","不存在该用户,请重新输入!");
			model.addAttribute("time",3);

			return "error";//跳到错误页面
		}

		//3.判断帐号密码是否有误
		if(!user.getName().equals(username) || !user.getPassword().equals(password)){
			model.addAttribute("warnMessage","该用户的密码输入错误,请重新输入！");
			model.addAttribute("time",2);

			return "error";//跳到错误页面
		}

		if(user.getName().equals(username) && user.getPassword().equals(password)){
			//4-A.判断是否添加Cookie自动登录
			String automaticLogin = request.getParameter("automaticLogin"); //on-勾选,null未勾选
			if("on".equals(automaticLogin)){
				CookieUtils.insertCookie(response,"blogUserNameCookie",username);//插入Cookie
				CookieUtils.insertCookie(response,"blogPasswordCookie",password);//插入Cookie
			}

			//4-B.Session添加登录状态
			request.getSession().setAttribute("loginState",true); //登录状态
		}




		System.out.println("***********************************登录成功***********************************");
		return "redirect:../index";
		//return "forward:login"; //请求转发

	}
	/*注销登录*/
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response) throws Exception{


			//1.清除Session,取消登录状态
			//HttpSession session = request.getSession(false);//true(如果当前为null就创建),false(如果没有Session,即为null)
			request.getSession().removeAttribute("loginState");

			//2.清除Cookie
			CookieUtils.deleteCookie(request,response,"blogUserNameCookie");
			CookieUtils.deleteCookie(request,response,"blogPasswordCookie");


			return "redirect:index";
	}



	/*注册用户*/
	@RequestMapping(value = "register/registerUser",method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request,
							   @RequestParam(required = false) String username,
							   @RequestParam(required = false) String password,
							   @RequestParam(required = false) String email){ //没有request变量无法传参数


		//2.构建用户对象
		User user = new User();
			user.setName(username);
			user.setPassword(password);
			user.setEmail(email);


		//3.持久化到数据库
		String result = userService.insertUser(user);
		System.out.println("注册结果 --->" + result);

		return "redirect:../login";
	}
	/*验证用户名唯一*/
	@RequestMapping(value = "register/onlyUserName",produces="text/html;charset=UTF-8",method = RequestMethod.POST)
	public  @ResponseBody String onlyUserName(@RequestParam(required = false) String username){  //requred-false不传入此参数则报错
		return userService.selectByNameOnlyUser(username);
	}
	/*发送邮箱验证码*/
	@RequestMapping(value = "register/emailVerificationCode",produces="text/html;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody String emailVerificationCode(HttpServletRequest request){

		String useremail = request.getParameter("useremail");
		String VerificationCode = CreateRandomNumber.getSixRandomNumber();		//生成6位数随机数

		Email email = new Email();
			email.setUsername("526097449@qq.com"); //liushuwei0925@gmail.com,13202405189@163.com,526097449@qq.com
			email.setPensonalName("博客机器人");
			email.setAuthorizationCode("rhurwfaecvvzbjbg"); //qq邮箱授权码
			email.setRecipients(useremail);
			email.setSubject("注册验证码");
			email.setText("您好,注册码是:" + VerificationCode + ",欢迎您注册博客");

		SendEmail sendEmail = new SendEmail();
		sendEmail.GO(email);

		return VerificationCode;
	}
}
