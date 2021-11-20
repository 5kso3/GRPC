package exeception;

public class SecurityException extends Exception {
	private static final long serialVersionUID = 1L;
	public SecurityException(String errorMessage) {
		super(errorMessage);
	}
}
