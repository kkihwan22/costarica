package me.kkihwan.web.shared.application;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Setter @Getter
@ToString
@EqualsAndHashCode
public class BaseResponse<T> {
	private Integer status;
	private String cause;
	private String message;
	private LocalDateTime timestamp;
	private T result;

	public static <T> BaseResponse<T> successResponse(T result) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setStatus(200);
		response.setCause("SUCCESS");
		response.setMessage("OK");
		response.setTimestamp(LocalDateTime.now());
		response.setResult(result);
		return response;
	}

	public static <T> BaseResponse<T> errorResponse(Integer status, String cause, String message, T result) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setStatus(status);
		response.setCause(cause);
		response.setMessage(message);
		response.setTimestamp(LocalDateTime.now());
		response.setResult(result);
		return response;
	}

}