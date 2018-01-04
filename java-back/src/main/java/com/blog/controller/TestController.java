package com.blog.controller;

import com.blog.entity.User;
import com.blog.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/test")
public class TestController {
	@Resource
	private IUserService userService;


	//请求传参
	@RequestMapping(value = "/user",params = "id")
	public String printUser(HttpServletRequest request, Model model){
		int userId = Integer.parseInt(request.getParameter("id")); //获取用户id

		User user = userService.selectUserById(userId);
		model.addAttribute("user",user);

		System.out.println("服务器打印测试：" + user.getName() + "---" + user.getPassword());

		return "test"; 		//返回test.jsp文件
	}

	//注解传参
    @RequestMapping(value = "/param")
    public String printUser(@RequestParam(value="id",defaultValue = "1")Integer id,
                            @RequestParam(value="name")String name){

        System.out.println("id:" + id + "\n name" + name);

	    return "test";
    }
    //RESTFul风格【方法参数中,必须有HttpServletRequest类型的参数】
    @RequestMapping(value = "/ruser/{id}",method = RequestMethod.GET)
    public String printUser(HttpServletRequest request,
                            @PathVariable(value = "id") String id,
                            @RequestHeader(value = "HSOT",defaultValue = "无")String host,
                            @CookieValue(value = "JSESSIONID")String sesssionId){

        System.out.println("\n 我的id --->" + id);
        System.out.println("主机HOST" + host);
        System.out.println("Cookie的值" +  sesssionId);


        return "test";
    }

    //JSON格式数据
    @ResponseBody           //返回JSON格式数据
    @RequestMapping("/jsonuser")
    public User printUser(){
        User user = new User();

        user.setName("第一");
        user.setPhone("13202405189");

        return user;
    }

	//请求重定向
	@RequestMapping("/show")
	public String redirectBackstage(){

		return "redirect:../user/backstage?id=1";
	}


    //异常处理[默认会跳转到error.jsp]
    @RequestMapping("/ok")
    public String error(){

        int i = 5/0; //这里会出现异常

        return "test";
    }


    //文件上传[required-是否必须有该参数,设为true时，若请求没此参数则报错404]
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request,
                             @RequestParam(value = "file",required = false)MultipartFile file
                            ) throws Exception{

        ////1.转换请求类型【获取MultipartFile对象】[可在方法参数用@RequestParam获取]
        //MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)request;
        //MultipartFile file = mreq.getFile("file");

        //2.定义参数
        String fileName = file.getOriginalFilename();                                       //获取文件名
        String date = new SimpleDateFormat("yyyyMMMMddHHmmss").format(new Date());  //上传日期
        String suffix = fileName.substring(fileName.lastIndexOf("."));                  //后缀

        String uploadPath = request.getSession().getServletContext().getRealPath("/");   //上传路径
        String uploadFileName = "upload" + date + suffix;                                  //上传文件名

        //3.输出流
        FileOutputStream fos = new FileOutputStream(uploadPath +"file/" + uploadFileName);
        System.out.print("上传文件 ->" + uploadPath + "file/" + uploadFileName + "-----");

        //4.写入文件[刷新与关闭输出流]
        fos.write(file.getBytes());
        fos.flush();
        fos.close();


        return "testshow";
    }


    //文件下载【java的io流】
    @RequestMapping("/download")
    public void download(HttpServletRequest request,HttpServletResponse response) throws Exception{

        //1.获取待下载[文件名 + 路径]
        String fileName = "测试语句.sql";
        String filePath = request.getSession().getServletContext().getRealPath("/")+"file/download/";

        //2.得到文件对象
        File file = new File(filePath + fileName);
        if(!file.exists()){
            System.out.println("抱歉,不存在该文件");
            return; //文件不存在就退出方法
        }

        //3.文件输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1"); //下载文件名

        //4.设置Http响应头[告诉浏览器要下载该文件]
        response.setHeader("Content-Disposition",       //文件类型
                          "attachment;filename=" + downloadFileName);

        //5.输出流[将文件内容输出]
        OutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[2048];
        int len = 0;
        while ((len = fileInputStream.read(bytes))>0){
            outputStream.write(bytes,0,len);
        }

        //6.关闭流
        fileInputStream.close();
        outputStream.close();
    }

    //文件下载[SpringMVC提供的]
    @RequestMapping("/springdownload")
    public ResponseEntity<byte[]> springdownload(HttpServletRequest request,
                                           HttpServletResponse response)
                            throws IOException {
        //1.待下载[文件+路径]
        String fileName = "测试语句.sql";
        String filePath = request.getSession().getServletContext().getRealPath("/")+"file/download/";


        //2.获取文件对象
        File file = new File( filePath + "/" + fileName);

        //3.设置Http响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",
                new String(fileName.getBytes("UTF-8"), "iso-8859-1"));


        //4.返回[由SpringMVC框架读取输出流]
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                                          headers,
                                          HttpStatus.OK);
    }
}
