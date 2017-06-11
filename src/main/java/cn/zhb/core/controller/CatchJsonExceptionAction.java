package cn.zhb.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.exception.JsonSendException;



@ControllerAdvice
public class CatchJsonExceptionAction {
	private Logger logger = Logger.getLogger(CatchJsonExceptionAction.class);
	
	
	
	@ExceptionHandler({JsonSendException.class})
	@ResponseBody
	public JsonResponse handleJsonException(HttpServletRequest request, JsonSendException ex  ) {
		logger.error("ajax error: ", ex);
		return ex.getJsonResponse();
	}
	
	
}
