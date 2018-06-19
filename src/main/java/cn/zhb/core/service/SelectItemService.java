package cn.zhb.core.service;

import java.util.List;

import cn.zhb.core.entity.SelectItem;

public interface SelectItemService {
	List<SelectItem> getLightType();
	List<SelectItem> getByType(String type);
}
 