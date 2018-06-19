package cn.zhb.core.entity;

import java.util.ArrayList;
import java.util.List;



public class LayuiTableResponse <T> {
	private Integer code = 0;
	private String msg = "";
	private Integer count = 0;
	private List<T> data = new ArrayList<T>();
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
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
