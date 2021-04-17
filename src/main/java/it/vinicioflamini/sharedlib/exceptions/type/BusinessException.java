package it.vinicioflamini.sharedlib.exceptions.type;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1550224212912525380L;
	private String businessErrorCode;
	private String debugMessage;

	/** CONSTRUCTORS **/

	public BusinessException() {
		super();
	}

	public BusinessException(String businessErrorCode, String message) {
		this(businessErrorCode, message, null);
	}

	public BusinessException(String businessErrorCode, String message, String debugMessage) {
		super(message);
		this.businessErrorCode = businessErrorCode;
		this.debugMessage = debugMessage;
	}

	public BusinessException(String businessErrorCode, Throwable error) {
		super(error.getMessage());
		this.businessErrorCode = businessErrorCode;
	}

	/** ACCESSOR METHODS **/

	public String getBusinessErrorCode() {
		return businessErrorCode;
	}

	public void setBusinessErrorCode(String businessErrorCode) {
		this.businessErrorCode = businessErrorCode;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	@Override
	public String toString() {
		return String.format("BusinessException{businessErrorCode=%s, message=%s, debugMessage=%s}", businessErrorCode,
				getMessage(), debugMessage);
	}

}
