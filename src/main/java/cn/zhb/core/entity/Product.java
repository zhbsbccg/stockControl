package cn.zhb.core.entity;

/**
 * 产品
 * @author zhb
 *
 */
public class Product {
	
	private Integer id;
	private String name;//名称
	private String model;//型号
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
