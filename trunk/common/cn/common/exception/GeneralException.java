package cn.common.exception;

/**
 * 自定义异常处理类
 * 
 * @author 孙树林
 * 
 */
public class GeneralException extends Exception {

	private static final long serialVersionUID = 1246430664697608801L;

	public GeneralException() {
		super();
	}

	public GeneralException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneralException(String message) {
		super(message);
	}

	public GeneralException(Throwable cause) {
		super(cause);
	}
}
