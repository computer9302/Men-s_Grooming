package exception;


public class MemoAPIException extends Exception{

	private ErrorCode errorCode;

	public MemoAPIException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	
	
	
}
