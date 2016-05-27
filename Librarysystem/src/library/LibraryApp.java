package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import models.Book;
import constants.BookCategory;
import exceptions.NoBookAvailableException;
import exceptions.MaxBookIssuedException;
import exceptions.NoBookFoundException;
import exceptions.NoBookIssuedException;
import exceptions.NoCategoryFoundException;

public class LibraryApp {

	public static ArrayList<Book> book = new ArrayList<Book>();// to hold all books objects															
	public static ArrayList<String> myBooks = new ArrayList<String>();// to hold students books																		
	public static Scanner s = new Scanner(System.in);
	public final static int MAXBOOKS = 2;// Maximun no. of book a student can											// issue
	public static int noOfBooksIssued = 0;
	private static Scanner sc1;

	/*
	 * bookList() list of all books present in Library in ascending order
	 */
	static void bookList() {

		for (int i = 0; i < book.size(); i++) {
			System.out.println("");
			System.out.println(book.get(i).toString());
		}
	}

	/*
	 * getIssuedBookList() list of books issued by a Student raises
	 * NoBookIssuedException if student has not issued any book
	 */
	static void getIssuedBookList() {
		System.out.println("Books count: " + noOfBooksIssued);
		if (noOfBooksIssued == 0) {
			System.out.println("No books You have Issued!!!");
		} else {
			System.out.println("Books:-");
			for (int i = 0; i < myBooks.size(); i++) {
				System.out.println(myBooks.get(i).toString());
				// System.out.println("");
			}
		}
	}

	/*
	 * searchByName() searches for a particular book by Name in Books List if
	 * not found raises NoBookFoundException and if no BOoks available then
	 * raises a NoBookAvaialble Exception
	 */
	static void searchByName(String bName) {

		Boolean found = false;
		for (int i = 0; i < book.size(); i++) {
			try {
				if (book.get(i).getBookName().equalsIgnoreCase(bName)) {
					int c = book.get(i).getCount();
					found = true;
					if (c == 0)
						throw new NoBookAvailableException();

					noOfBooksIssued++;
					c--;
					book.get(i).setCount(c);
					myBooks.add(book.get(i).getBookName());
				}

			} catch (NoBookAvailableException e) {
				System.out.println("");

			}

		}
		try {
			if (found == false)
				throw new NoBookFoundException();
		} catch (NoBookFoundException e) {

			System.out.println("");
		}

	}
/*
 * serachByName() overloaded method to search book category wise(actions,computers,humour,science)
 * 
 */
	static void searchByName(String bName,String cName) {

		Boolean found = false;
		for (int i = 0; i < book.size(); i++) {
			try {
				if (book.get(i).getBookName().equalsIgnoreCase(bName) && book.get(i).getType().toString().equals(cName)) {
					int c = book.get(i).getCount();
					found = true;
					if (c == 0)
						throw new NoBookAvailableException();

					noOfBooksIssued++;
					c--;
					book.get(i).setCount(c);
					myBooks.add(book.get(i).getBookName());
				}

			} catch (NoBookAvailableException e) {
				System.out.println("");

			}

		}
		try {
			if (found == false)
				throw new NoBookFoundException();
		} catch (NoBookFoundException e) {

			System.out.println("");
		}

	}

	/*
	 * searchByCategory() searches book a book category wise if no category
	 * found then throws NoCategoryException
	 */
	static void searchByCategory(String cName) {
		Boolean found = false;
		sc1 = new Scanner(System.in);
		for (int i = 0; i < book.size(); i++) {

			if (book.get(i).getType().toString().equals(cName)) {
				found = true;
				System.out.println(book.get(i).toString());
				System.out.println("");
			}
		}
		try {
			if (found == false)
				throw new NoCategoryFoundException();

			System.out.println("enter book name");
			String bName = sc1.nextLine();
			searchByName(bName.trim(),cName);
		} catch (NoCategoryFoundException e) {
			// System.out.println("");
		}
	}

	/*
	 * returnBook() Removes book from myBooks list of student decrements
	 * noOfBookIssued if book not found raises NoBookFoundException
	 */
	public static void returnBook() {
		Scanner sc2 = new Scanner(System.in);
		boolean found = false;
		try {
			if (noOfBooksIssued <= 0)
				throw new NoBookIssuedException();
			System.out.println("Enter book name to return");
			String bName = sc2.nextLine();
			for (int i = 0; i < myBooks.size(); i++) {
				if (myBooks.get(i).equalsIgnoreCase(bName.trim())) {
					found = true;
					noOfBooksIssued--;
					myBooks.remove(i);
					addStock(bName.trim());
				}

			}
			try {
				if (found == false)
					throw new NoBookFoundException();
			} catch (NoBookFoundException e) {
				System.out.println("");
			}

		} catch (NoBookIssuedException e) {
			System.out.println("");
		}
	}

	/*
	 * addStock() increments book in Book List which is returned by Student
	 */
	static void addStock(String bName) {

		for (int i = 0; i < book.size(); i++) {

			if (book.get(i).getBookName().equalsIgnoreCase(bName)) {

				int c = book.get(i).count;
				c++;
				book.get(i).setCount(c);

			}
		}
	}

	/*
	 * LibraryMenu() Gives Menu to Student and To do actions Raise
	 * MaxBookIssuedException if Student has issued max books which is set to 2
	 */
	public static void LibraryMenu() {
		String choice;
		boolean cont = true;
		String bName, cName;
		while (cont) {
			System.out.println("MENU LIBRARY");
			System.out.println("--------------------------------");
			System.out.println("1.See all books");
			System.out.println("2.Search by category n issue it(action,science,computer,humour)");
			System.out.println("3.Search by name n issue it");
			System.out.println("4.See my Books Issued");
			System.out.println("5.return book");
			System.out.println("6.EXIT");
			System.out.println("--------------------------------");
			choice = s.next();

			switch (choice.trim()) {

			case "1":
				bookList();
				break;

			case "2":
				try {
					if (noOfBooksIssued >= MAXBOOKS) {
						throw new MaxBookIssuedException();
					}
					Scanner sc1 = new Scanner(System.in);
					System.out.println("enter Category Name");
					cName = sc1.nextLine();
					searchByCategory(cName.trim().toUpperCase());
				} catch (MaxBookIssuedException e) {
					System.out.println("");

				}
				break;

			case "3":
				try {
					if (noOfBooksIssued >= MAXBOOKS) {
						throw new MaxBookIssuedException();
					}
					System.out.println("enter book Name to issue");
					Scanner sc = new Scanner(System.in);
					bName = sc.nextLine();
					searchByName(bName.trim());
				} catch (MaxBookIssuedException e) {
					System.out.println("");

				}
				break;
			case "4":
				getIssuedBookList();
				break;

			case "5":
				returnBook();
				break;

			case "6":
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}

			System.out.println("Press any key to continue and N orn to exit ");
			if (s.next().equalsIgnoreCase("n"))
				cont = false;
		}
	}

	public static void main(String[] args) {

		Book b1 = BookFactory.buildBook("Chacha", "Tope", 14,
				BookCategory.HUMOUR);
		Book b2 = BookFactory
				.buildBook("Host", "Raka", 11, BookCategory.HUMOUR);

		Book b3 = BookFactory.buildBook("tom cruise", "kaka", 3,
				BookCategory.ACTION);
		Book b4 = BookFactory.buildBook("tom", "Taka", 0, BookCategory.ACTION);

		Book b5 = BookFactory
				.buildBook("Air", "shyam", 3, BookCategory.SCIENCE);
		Book b6 = BookFactory.buildBook("valcano", "ram", 4,
				BookCategory.SCIENCE);
		Book b7 = BookFactory.buildBook("java", "kathy serra", 4,
				BookCategory.COMPUTER);

		book.add(b1);
		book.add(b2);
		book.add(b3);
		book.add(b4);
		book.add(b5);
		book.add(b6);
		book.add(b7);
		Collections.sort(book, new BookComparator());
		LibraryMenu();

	}

}
