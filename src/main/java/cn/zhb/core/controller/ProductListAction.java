package cn.zhb.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品列表
 * @author zhb
 *
 */
@Controller
public class ProductListAction {
	
	@RequestMapping("/page/productList")
	public String productList(ModelMap modelMap) {
		modelMap.put("title", "产品列表");
		
		return "/product/productList";
	}
	
	
}
