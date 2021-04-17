package it.vinicioflamini.sharedlib.exceptions.apierror;

public class ApiValidationError implements ApiSubError {

	private String object;

	private String field;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private Object rejectedValue;

	private String message;

	ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

	ApiValidationError(String object, String field, Object rejectedValue, String message) {
		this.object = object;
		this.message = message;
		this.rejectedValue = rejectedValue;
		this.field = field;
	}

}

