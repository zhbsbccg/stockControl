package cn.zhb.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestAction {
	
	
	@RequestMapping("/page/testUpload")
	public String TestUpload() {
		return "/testUpload";
	}
}
