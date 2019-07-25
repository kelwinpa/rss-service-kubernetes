package com.reader.api.rss.util;

import org.springframework.http.ResponseEntity;

public class ResponseUtils {

	public static <T> ResponseEntity<BaseResponse<?>> buildSuccessOperationResponse(T data) {
		return buildResponse(200, "SUCCESS", data);
	}

	public static <T> ResponseEntity<BaseResponse<?>> buildResponse(int code, String message, T data) {
		return ResponseEntity.ok(new BaseResponse<>(message, code, data));
	}

	public static ResponseEntity<BaseResponse<?>> buildErrorResponse(CustomException e) {
		return buildResponse(e.getErrorCode(), e.getMessage(), null);
	}

	public static ResponseEntity<BaseResponse<?>> buildFailedOperationResponse(int code, String errorMessage) {
		return buildResponse(code, errorMessage, null);
	}
}
