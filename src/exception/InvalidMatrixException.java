package exception;

@SuppressWarnings("serial")
public class InvalidMatrixException extends Exception {
	public InvalidMatrixException() {
		super();
	}
	
	public InvalidMatrixException(String message) {
		super(message);
	}
}
