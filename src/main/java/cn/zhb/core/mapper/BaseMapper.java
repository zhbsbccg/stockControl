package cn.zhb.core.mapper;

import java.util.List;

import cn.zhb.core.entity.BaseEntity;

public interface BaseMapper<T extends BaseEntity> {
	int updateById(T t, Integer id);
	int save(T t);
	T getById(Integer id);
	T getObjById(Integer id);
	List<T> getList();
	List<T> getListByWhere(String where);
}
