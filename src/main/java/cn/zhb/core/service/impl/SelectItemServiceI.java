package cn.zhb.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhb.core.entity.SelectItem;
import cn.zhb.core.mapper.SelectItemMapper;
import cn.zhb.core.service.SelectItemService;

@Service("selectItemService")
public class SelectItemServiceI  implements SelectItemService {
	/*@Resource
	private SelectItemMapper selectItemMapper;*/
	
	@Autowired
	SQLManager sql;
	
	/**
	 * 获取灯具类型
	 */
	@Override
	public List<SelectItem> getLightType() {
		return getByType("lightType");
	}

	@Override
	public List<SelectItem> getByType(String type) {
		return sql.query(SelectItem.class).andEq("type", type).select();
	}
	
	
	

}
