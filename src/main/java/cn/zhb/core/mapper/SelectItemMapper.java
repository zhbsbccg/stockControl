package cn.zhb.core.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.zhb.core.entity.SelectItem;

@Repository
public interface SelectItemMapper extends BaseMapper<SelectItem> {
	List<SelectItem> getByType(String type);
}
