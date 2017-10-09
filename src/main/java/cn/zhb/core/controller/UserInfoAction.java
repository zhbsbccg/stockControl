package cn.zhb.core.controller;

import javax.annotation.Resource;import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.entity.Users;
import cn.zhb.core.service.UsersService;

@Controller
public class UserInfoAction {
	@Resource
	private UsersService usersService;
	
	/**
	 * 个人信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/page/userinfo_view")
	public String userinfo_view(HttpServletRequest request, ModelMap model) {
		Users currentUser = usersService.getUserFromSession(request.getSession());
		model.put("user", usersService.getById(currentUser.getId()));
		return "/user/userinfo_view";
	}
	
	@RequestMapping("/ajax/saveUserinfo")
	@ResponseBody
	public JsonResponse saveUserinfo(@Autowired JsonResponse jRes, @RequestBody Users users, HttpServletRequest request) {
		if(users.getId() == null) {
			//获取当前sessionid
			users.setId(usersService.getUserFromSession(request.getSession()).getId());
		}
		//update users
		
		
		
		return jRes;
	}
}
