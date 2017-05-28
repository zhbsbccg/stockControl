package cn.zhb.core.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhb.core.entity.Users;
import cn.zhb.core.service.UsersService;

@Controller
public class LoginInAction {
	@Resource
	private UsersService usersService;
	
	@RequestMapping("/in")
	public String loginIn() {
		return "login/in";
	}
	
	@RequestMapping("/checkUser")
	public void doLogin(HttpServletRequest request, String username, String password) throws Exception {
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new Exception("密码不能为空");
		}
		Users loginUser = usersService.getUserByUsername(username);
		if(loginUser == null) {
			throw new Exception("账号名错误");
		}
		if(!password.equals(loginUser.getPassword())) {
			throw new Exception("密码错误");
		}
		//resp.sendRedirect("/main.action");
	}
}
