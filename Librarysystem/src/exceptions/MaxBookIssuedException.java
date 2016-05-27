package exceptions;

public class MaxBookIssuedException extends Exception {

	//private static final long serialVersionUID = 1L;

	public MaxBookIssuedException() {
		System.out.println("you have issued books as per MAX Limit ");
	}
}
