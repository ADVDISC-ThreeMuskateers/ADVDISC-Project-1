package exception;

@SuppressWarnings("serial")
public class UnequalDimensionsException extends Exception {
	public UnequalDimensionsException() {
		super();
	}
	
	public UnequalDimensionsException(String message) {
		super(message);
	}
}
