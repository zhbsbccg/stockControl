package cn.zhb.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhb.core.entity.Product;
import cn.zhb.core.mapper.ProductMapper;
import cn.zhb.core.service.ProductService;

@Service("productService")
public class ProductServiceI extends BaseServiceI<Product> implements ProductService {
	
	/*@Resource
	private ProductMapper productMapper;*/
	
	 @Autowired
	 SQLManager sql;

	public List<Product> getList() {
		return sql.all(Product.class);
	}

	

}
