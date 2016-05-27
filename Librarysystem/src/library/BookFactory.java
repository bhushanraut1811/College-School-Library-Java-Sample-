package library;

import models.ActionBook;
import models.Book;
import models.ComputerBook;
import models.HumourBook;
import models.ScienceBook;
import constants.BookCategory;

public class BookFactory {

	/*
	 * buildBook() is used to create Books Objects based on type category
	 * action,science, humuor,computers
	 */
	public static Book buildBook(String bName, String aName, int count,
			BookCategory bCategory) {
		Book book = null;
		switch (bCategory) {
		case ACTION:
			book = new HumourBook(bName, aName, count, bCategory);
			break;
		case HUMOUR:
			book = new ActionBook(bName, aName, count, bCategory);
			break;
		case SCIENCE:
			book = new ScienceBook(bName, aName, count, bCategory);
			break;
		case COMPUTER:
			book = new ComputerBook(bName, aName, count, bCategory);
			break;

		default:
			break;

		}
		return book;
	}
}
