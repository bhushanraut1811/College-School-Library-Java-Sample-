package exceptions;

public class NoBookFoundException extends Exception {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 7481715613616341605L;

	public NoBookFoundException() {
		System.out.println("NO such book found");

	}
}
