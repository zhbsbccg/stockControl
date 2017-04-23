package cn.zhb.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainAction {
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
}
