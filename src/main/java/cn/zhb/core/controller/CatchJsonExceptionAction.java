package cn.zhb.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.exception.JsonSendException;




@ControllerAdvice
public class CatchJsonExceptionAction {
	private Logger logger = Logger.getLogger(CatchJsonExceptionAction.class);
	
	@ExceptionHandler(JsonSendException.class)
	public JsonResponse handleJsonException(HttpServletRequest request, Exception ex, @Autowired JsonResponse jsonResponse) {
		System.out.println("in error");
		int errorNum = jsonResponse.getErrorNum();
		jsonResponse.setErrorNum(errorNum ++);
		jsonResponse.setErrorMessage(ex.getMessage());
		logger.error("ajax错误:", ex);
		return jsonResponse;
	}
	
}
