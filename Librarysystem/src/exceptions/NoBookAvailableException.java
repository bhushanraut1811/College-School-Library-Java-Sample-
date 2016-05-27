package exceptions;

public class NoBookAvailableException extends Exception {

	//private static final long serialVersionUID = 1L;

	public NoBookAvailableException() {
		System.out.println("can't issue book NO BOOks Available");
	}

}