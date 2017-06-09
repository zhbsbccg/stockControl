package cn.zhb.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.zhb.core.entity.JsonResponse;
import cn.zhb.core.service.JsonResponseService;

@Service("jsonResponseService")
@Scope("prototype")
public class JsonResponseServiceI implements JsonResponseService {
	@Autowired
	private JsonResponse jsonResponse;
	
	@Override
	public JsonResponse throwJsonResponseError(Exception ex) {
		// TODO Auto-generated method stub
		int errorNum = jsonResponse.getErrorNum();
		jsonResponse.setErrorNum(++ errorNum);
		jsonResponse.setErrorMessage(ex.getMessage());
		return jsonResponse;
	}

}
