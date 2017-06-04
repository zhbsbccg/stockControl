package cn.zhb.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.exception.JsonSendException;


@ControllerAdvice

public class CatchJsonExceptionAction {
	
	@ModelAttribute
	public JsonResponse newJsonResponse() {
		return new JsonResponse();
	}
	
	
	@ExceptionHandler(JsonSendException.class)
	@ResponseBody
	public JsonResponse handleJsonException(HttpServletRequest request, Exception ex, @Autowired JsonResponse jsonResponse) {
		int errorNum = jsonResponse.getErrorNum();
		jsonResponse.setErrorNum(errorNum ++);
		jsonResponse.setErrorMessage(ex.getMessage());
		
		
		return null;
		
		
	}
	
}
