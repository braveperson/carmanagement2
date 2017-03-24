package cn.scxh.carmangger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(){
		return "login";	//此处返回值是和jsp文件名一致
	}
	
	@RequestMapping("/main")
	public String main(String userName,String passWord,Model model){
		System.out.println("11111111111");
		if("admin".equals(userName) && "admin".equals(passWord)){
			return "main";
		}else{
			model.addAttribute("error","用户名或密码错误！");
			return "login";
		}
	}
}
