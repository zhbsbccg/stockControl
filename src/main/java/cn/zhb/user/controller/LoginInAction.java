package cn.zhb.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginInAction {
	
	@RequestMapping("/in")
	public String page() {
		return "/login/in";
	}
	
	@RequestMapping("/checkUser")
	public void doLogin(HttpServletResponse resp, String username, String password) throws IOException {
		System.out.println("登录");
		
		resp.sendRedirect("/main.action");
	}
}
