package exceptions;

public class NoBookIssuedException extends Exception {
	public NoBookIssuedException()
	{
		
		System.out.println("you havent issed any book");
	}
}
