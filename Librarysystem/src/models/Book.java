package models;

import constants.BookCategory;

public abstract class Book {

	public String bookName;
	public String authorName;
	public int count;
	public BookCategory type = null;

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "   Name: " + bookName + "  Author: " + authorName
				+ "  Count:" + count + "  Category:" + type;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public int getCount() {
		return count;
	}

	public BookCategory getType() {
		return type;

	}

	public Book(String bookName, String authorName, int count, BookCategory type) {

		this.bookName = bookName;
		this.authorName = authorName;
		this.count = count;
		this.type = type;
	}

	abstract int getCategoryCount();

}
