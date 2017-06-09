package cn.zhb.core.service;

import cn.zhb.core.entity.JsonResponse;

public interface JsonResponseService {
	JsonResponse throwJsonResponseError(Exception ex);
}
