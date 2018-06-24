package cn.zhb.core.entity;

import java.util.ArrayList;
import java.util.List;



public class LayuiTableResponse <T> extends LayuiResponse {
	
	private Integer count = 0;
	private List<T> data = new ArrayList<T>();
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
