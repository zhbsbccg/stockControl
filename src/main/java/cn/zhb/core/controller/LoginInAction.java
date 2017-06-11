package cn.zhb.core.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.entity.Users;
import cn.zhb.core.exception.JsonSendException;
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
	@ResponseBody
	public JsonResponse doLogin(HttpServletRequest request, @RequestBody Users users, @Autowired JsonResponse jsonResponse) throws JsonSendException {
		if(StringUtils.isEmpty(users.getUsername()) || StringUtils.isEmpty(users.getPassword())) {
			throw new JsonSendException("密码不能为空", jsonResponse);
		}
		Users loginUser = usersService.getUserByUsername(users.getUsername());
		if(loginUser == null) {
			throw new JsonSendException("账号名错误", jsonResponse);
		}
		String md5Password = usersService.encodePassword(loginUser.getPassword());
		if(!users.getPassword().equals(md5Password)) {
			throw new JsonSendException("密码错误", jsonResponse);
		}
		return jsonResponse;
		
		
		//resp.sendRedirect("/main.action");
	}
}
