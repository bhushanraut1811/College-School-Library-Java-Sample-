package models;

import constants.BookCategory;

/*
 * ScienceBook class extends Book class and implements getCategoryCount() method 
 * which is abstract in Book class
 */

public class ScienceBook extends Book {
	static int sCount; // to hold total no of books of category science

	public ScienceBook(String bName, String authorName, int count,
			BookCategory type) {
		super(bName, authorName, count, type);
		sCount++;
	}

	/*
	 * getCategoryCount() returns total no of ScienceBooks
	 */
	int getCategoryCount() {
		return sCount;
	}
}
