package cn.zhb.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.entity.LayuiTableResponse;
import cn.zhb.core.entity.Product;
import cn.zhb.core.entity.TablePage;
import cn.zhb.core.service.ProductService;

/**
 * 产品列表
 * @author zhb
 *
 */
@Controller
public class ProductListAction {
	//page
	@Resource
	private ProductService productService;
	
	@RequestMapping("/page/productList")
	public String productList(ModelMap modelMap) {
		modelMap.put("title", "产品列表");
		
		return "/product/productList";
	}
	
	//ajax
	/**
	 * 获取产品列数据
	 * @return
	 */
	@RequestMapping("/ajax/getProductList")
	@ResponseBody
	public LayuiTableResponse<Product> getProductList() {
		
		List<Product> list = productService.getList();
		LayuiTableResponse<Product> tableResponse = new LayuiTableResponse<>();
		tableResponse.setData(list);
		
		return tableResponse;
	}
	
}
