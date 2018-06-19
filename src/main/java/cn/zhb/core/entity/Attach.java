package cn.zhb.core.entity;

/**
 * 附件相关
 * @author Administrator
 *
 */
public class Attach {
	private Integer id; 
	private String originName;
	private String abstractName;
	private String path;
	private String size;
	private String suffix;
	private String createDate;
	
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getAbstractName() {
		return abstractName;
	}
	public void setAbstractName(String abstractName) {
		this.abstractName = abstractName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	
	
}
