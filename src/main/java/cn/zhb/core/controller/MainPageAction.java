package cn.zhb.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageAction {
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
}
