package cn.zhb.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.entity.Users;
import cn.zhb.core.exception.JsonSendException;
import cn.zhb.core.service.UsersService;

@Controller
public class MainPageAction {
	@Resource
	private UsersService usersService;
	
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
	
	/**
	 * ajax获取当前用户
	 * @param request
	 * @param jsonResponse
	 * @return
	 * @throws JsonSendException 
	 */
	@RequestMapping("/getCurrentUser")
	@ResponseBody
	public JsonResponse<Users> getCurrentUser(HttpServletRequest request, @Autowired JsonResponse<Users> jsonResponse) throws JsonSendException {
		Users currentUsers = usersService.getUserFromSession(request.getSession());
		if(currentUsers == null) {
			throw new JsonSendException("当前用户尚未登录，请重新登录", jsonResponse);
		}
		jsonResponse.setResponse(currentUsers);
		return jsonResponse;
	}
}
