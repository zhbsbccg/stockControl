package cn.zhb.core.entity;

import java.util.HashMap;
import java.util.Map;

public class BaseEntity {
	private Map<String, Object> otherData = new HashMap<>();

	
	public Map<String, Object> getOtherData() {
		return otherData;
	}

	public void setOtherData(Map<String, Object> otherData) {
		this.otherData = otherData;
	}
	
	
	
	
}
