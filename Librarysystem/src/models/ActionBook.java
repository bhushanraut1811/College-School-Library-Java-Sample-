package models;

import constants.BookCategory;

/*
 * ActionBook class extends Book class and implements getCategoryCount() method 
 * which is abstract in Book class
 */

public class ActionBook extends Book {
	static int aCount;// to hold total no of books of category action

	public ActionBook(String bName, String authorName, int count,
			BookCategory type) {
		super(bName, authorName, count, type);
		aCount++;
	}

	/*
	 * getCategoryCount() returns total no of ActiBooks
	 */
	int getCategoryCount() {
		return aCount;
	}

}
