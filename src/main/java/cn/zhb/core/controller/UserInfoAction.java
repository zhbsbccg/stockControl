package cn.zhb.core.controller;

import javax.annotation.Resource;import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhb.core.entity.Users;
import cn.zhb.core.service.UsersService;

@Controller
@RequestMapping("/page")
public class UserInfoAction {
	@Resource
	private UsersService usersService;
	
	/**
	 * 个人信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/userinfo_view")
	public String userinfo_view(HttpServletRequest request, ModelMap model) {
		Users currentUser = usersService.getUserFromSession(request.getSession());
		model.put("user", usersService.getById(currentUser.getId()));
		return "/user/userinfo_view";
	}
}
