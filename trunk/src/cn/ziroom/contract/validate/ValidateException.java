package cn.ziroom.contract.validate;

/**
 * 验证的异常
 * 
 * @author manguo
 * 
 */
public class ValidateException extends Exception {

	private static final long serialVersionUID = 1L;

	private String msg;
	private Throwable cause;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public ValidateException() {
		super();
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
		this.msg = message;
		this.cause = cause;
	}

	public ValidateException(String message) {
		super(message);
		this.msg = message;
	}

	public ValidateException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}
}
