package it.vinicioflamini.sharedlib.exceptions.type;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7859851106284999548L;
	
	public ResourceNotFoundException() {
        super();
    }
    
	public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
	public ResourceNotFoundException(String message) {
        super(message);
    }
    
	public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}