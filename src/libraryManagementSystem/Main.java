package libraryManagementSystem;

import java.util.*;
import java.sql.*;

public class Main {
	List<Book> books = new ArrayList<Book>();
	User user = new User();

	public void process() {
		System.out.println("Enter if Librarian or User");
		String person = input();
		while (true) {
			if (person.equals("Librarian")) {
				System.out.println("You are a Librarian");
				librarianMethod();
				break;
			} else if (person.equals("User")) {
				System.out.println("You are a User");
				userMethod();
				break;
			} else {
				System.out.println("Error, please try again");
				person = input();
			}

		}
	}

	public static void main(String[] args) {
		Main runner = new Main();
		runner.process();

	}

	public String input() {
		String person = "";
		Scanner in = new Scanner(System.in);
		person = in.next();
		return person;

	}

	public void librarianMethod() {
		int doing = 0;
		boolean available = false;
		Scanner in = new Scanner(System.in);
		System.out.println(
				"What would you like to do, Add New Books: 1, Update availability of a book: 2, Add Count to Book: 3, Track Members: 4, Track Transitions of Renewals: 5, Or Show All Books: 6, or Exit: 7");
		doing = in.nextInt();
		switch (doing) {
		case 1:
			System.out.println("Enter Book Name: ");
			Book tempbook = new Book();
			in = new Scanner(System.in);
			String tempname = in.nextLine();
			tempbook.setBookName(tempname);
			System.out.println("Enter the availability of this book: Enter True or False ");
			available = in.nextBoolean();
			tempbook.setAvail(available);
			tempbook.setS1ID();
			books.add(tempbook);
			System.out.println("Book created");

			librarianMethod();
			break;
		case 2:

		case 3:

		case 4:

		case 5:

		case 6:
			for (int i = 0; i < books.size(); i++) {
				System.out.print(books.get(i).getBookName() + ", ");
				System.out.println(books.get(i).getS1ID() + ", ");
				System.out.println(books.get(i).getAvail());
			}
			librarianMethod();
			break;
		case 7:

			break;
		default:
			System.out.println("Error, make sure caps are right and words are spelled correctly");
			librarianMethod();
		}
	}

	public void userMethod() {

	}
}
