package cn.zhb.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhb.core.entity.SelectItem;
import cn.zhb.core.service.SelectItemService;

/**
 * 下拉框控制器
 * @author Administrator
 *
 */
@Controller
public class SelectItemAction {
	@Resource
	private SelectItemService selectItemService;
	
	
	@RequestMapping("/ajax/select/getLightType")
	@ResponseBody
	public List<SelectItem> getLightType() {
		return selectItemService.getLightType();
	}
}
