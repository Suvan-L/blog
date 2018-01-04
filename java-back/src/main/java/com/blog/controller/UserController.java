package com.blog.controller;

import com.blog.entity.User;
import com.blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *	用户登录与注册功能性验证
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;




	/*根据用户id进入指定后台*/
	@RequestMapping(value = "/backstage",method = RequestMethod.GET)
	public String toBackstage(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id")); //获取用户id


		User user = userService.selectUserById(userId);
		model.addAttribute("user", user);	//将user对象添加到Model视图

		return "backstage"; 		//跳到后台界面
	}


}
