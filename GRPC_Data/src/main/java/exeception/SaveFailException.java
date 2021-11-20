package exeception;

public class SaveFailException extends Exception {
	private static final long serialVersionUID = 1L;
	public SaveFailException(String errorMessage) {
		super(errorMessage);
	}
}
