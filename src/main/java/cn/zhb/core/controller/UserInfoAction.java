package cn.zhb.core.controller;

import javax.annotation.Resource;import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.entity.Users;
import cn.zhb.core.exception.JsonSendException;
import cn.zhb.core.service.UsersService;
import cn.zhb.core.utils.VailUtils;

@Controller
public class UserInfoAction {
	@Resource
	private UsersService usersService;
	@Resource
	private VailUtils vailUtils;
	
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
	public JsonResponse saveUserinfo(@Autowired JsonResponse jRes, @RequestBody Users users, HttpServletRequest request) throws JsonSendException {
		//安全检查
		if(users.getId() == null) {
			throw new JsonSendException("被修改的人员主键不能为空！", jRes);
		}
		if(StringUtils.isEmpty(users.getName()) || StringUtils.isEmpty(users.getUsername())) {
			throw new JsonSendException("关键数据不能为空！", jRes);
		}
		//更新数据
		usersService.update(users);
		return jRes;
	}
	/**
	 * 修改密码页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/page/setPassword")
	public String setPasswordPage(HttpServletRequest request, ModelMap model) {
		Users currentUser = usersService.getUserFromSession(request.getSession());
		model.put("user", usersService.getById(currentUser.getId()));
		return "/user/setPassword";
	}
	
	@RequestMapping("/ajax/setPassword")
	@ResponseBody
	public JsonResponse setPassword(@Autowired JsonResponse jRes,
			@RequestParam Integer id, @RequestParam String oldpassword, @RequestParam String password,
			HttpServletRequest request) throws JsonSendException {
		//安全检查
		vailUtils.setJsonResponse(jRes);
		vailUtils.objIsNotNull(id, "被修改的人员主键不能为空");
		vailUtils.strOrIsNotEmpty(new String[]{oldpassword, password}, "密码相关不能为空"); 
		//校验原密码
		vailUtils.throwErr(!usersService.checkPasswordById(id, oldpassword), "原密码不正确");
		//修改密码
		Users users = usersService.getById(id);
		users.setPassword(usersService.encodePassword(password));
		usersService.update(users);
		return jRes;
	}
}
