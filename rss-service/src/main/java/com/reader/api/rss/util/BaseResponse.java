package com.reader.api.rss.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> extends GenericEntity {

	@JsonView(Views.BaseView.class)
	private String message;
	@JsonView(Views.BaseView.class)
	private int code;
	@JsonView(Views.BaseView.class)
	private T result;

	public BaseResponse(String message, int code, T result) {
		this.message = message;
		this.code = code;
		this.result = result;
	}

	public BaseResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
