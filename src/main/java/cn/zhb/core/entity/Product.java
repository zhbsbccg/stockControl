package cn.zhb.core.entity;

/**
 * 产品
 * @author zhb
 *
 */
public class Product extends BaseEntity {
	
	private Integer id;
	private String name;//名称
	private String model;//型号
	private String images;//图片
	private String remark;//备注说明
	
	
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
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
