package cn.zhb.core.entity;

import java.util.HashMap;
import java.util.Map;

public class LayuiMapResponse extends LayuiResponse {
	private Map<String, Object> data = new HashMap<>();

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	
	
}
