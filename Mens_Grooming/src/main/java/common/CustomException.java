package common;

import exception.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

	private final ErrorCode errorCode;
	
	public CustomException(ErrorCode errorCode) {
		super(errorCode.getErrorMsg());
		this.errorCode = errorCode;
	}
	
	public CustomException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
