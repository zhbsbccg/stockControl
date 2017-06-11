package cn.zhb.core.exception;

import cn.zhb.core.entity.JsonResponse;

/**
 * json数据处理相关错误
 */
public class JsonSendException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	private JsonResponse jsonResponse;
	
	public JsonSendException(String message, JsonResponse jsonResponse) {
		this.message = message;
		int errorNum = jsonResponse.getErrorNum();
		jsonResponse.setErrorNum( ++ errorNum);
		jsonResponse.setErrorMessage(message);
	}
	
	public String getMessage() {
		return message;
	}

	public JsonResponse getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(JsonResponse jsonResponse) {
		this.jsonResponse = jsonResponse;
	}
	
	
	
	
}
