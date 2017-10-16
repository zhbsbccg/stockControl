package cn.zhb.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.exception.JsonSendException;

/**
 * 数据验证相关工具
 * @author zhb
 *
 */
@Component
public class VailUtils {
	private JsonResponse jsonResponse;
	
	public void throwErr(boolean isR, String msg) throws JsonSendException {
		if(isR) {
			throw new JsonSendException(msg, jsonResponse);
		}
	}
	
	/**
	 * 对象不能为空
	 * @param obj
	 * @param msg
	 * @throws JsonSendException
	 */
	public void objIsNotNull(Object obj, String msg) throws JsonSendException {
		if(obj == null) {
			throw new JsonSendException(msg, jsonResponse);
		}
	}
	/**
	 * 不为空，空则报错
	 * @param str
	 * @param jRes
	 * @throws JsonSendException 
	 */
	public void strIsNotEmpty(String str, String msg) throws JsonSendException {
		if(StringUtils.isEmpty(str)) {
			throw new JsonSendException(msg, jsonResponse);
		}
	}
	/**
	 * 或者不为空
	 * isempgy || is empty
	 * @param strs
	 * @param msg
	 * @throws JsonSendException 
	 */
	public void strOrIsNotEmpty(String[] strs, String msg) throws JsonSendException {
		for(String temp: strs) {
			if(StringUtils.isEmpty(temp)) {
				throw new JsonSendException(msg, jsonResponse);
			}
		}
	}
	public JsonResponse getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(JsonResponse jsonResponse) {
		this.jsonResponse = jsonResponse;
	}
}
