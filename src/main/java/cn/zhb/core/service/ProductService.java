package cn.zhb.core.service;

import java.util.List;

import cn.zhb.core.entity.Product;

public interface ProductService extends BaseService<Product> {
	List<Product> getList();
}
