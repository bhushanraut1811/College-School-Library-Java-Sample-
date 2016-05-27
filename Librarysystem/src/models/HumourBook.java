package models;

import constants.BookCategory;

/*
 * ActionBook class extends Book class and implements getCategoryCount() method 
 * which is abstract in Book class
 */

public class HumourBook extends Book {
	static int hCount; // to hold total no of books of category Humour

	public HumourBook(String bName, String authorName, int count,
			BookCategory type) {
		super(bName, authorName, count, type);
		hCount++;

	}

	/*
	 * getCategoryCount() returns total no of Humour Books
	 */

	int getCategoryCount() {
		return hCount;
	}

}
