package cn.zhb.core.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * json反馈实体
 * @author zhb
 *
 * @param <T>
 */
@Component
@Scope("prototype")
public class JsonResponse<T> {
	private int errorNum;
	private String errorMessage;
	private T response;
	
	public int getErrorNum() {
		return errorNum;
	}
	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	
}
