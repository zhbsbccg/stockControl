package cn.zhb.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginInAction {
	
	@RequestMapping("/login")
	public String loginIn() {
		System.out.println("dologin in");
		return "login/in";
	}
	
	@RequestMapping("/checkUser")
	public void doLogin(HttpServletResponse resp, String username, String password) throws IOException {
		System.out.println("登录");
		
		//resp.sendRedirect("/main.action");
	}
}
