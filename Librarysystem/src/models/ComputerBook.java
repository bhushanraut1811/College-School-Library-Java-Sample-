package models;

import constants.BookCategory;

/*
 * ComputerBook class extends Book class and implements getCategoryCount() method 
 * which is abstract in Book class
 */

public class ComputerBook extends Book {
	static int cCount;// to hold total no of books of category computer

	public ComputerBook(String bName, String authorName, int count,
			BookCategory type) {
		super(bName, authorName, count, type);
		cCount++;
	}

	/*
	 * getCategoryCount() returns total no of ComputerBooks
	 */
	int getCategoryCount() {
		return cCount;
	}
}
