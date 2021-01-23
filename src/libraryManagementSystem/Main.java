package libraryManagementSystem;

import java.util.*;

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
		Scanner in = new Scanner(System.in);
		System.out.println(
				"What would you like to do: 1, Add New Books: 2, Update availability of a book: 3, Add Count to Book: 4, Track Members: 5, Track Transitions of Renewals: 6, Or Show All Books: 7, or Exit: 8");
		doing = in.nextInt();
		switch (doing) {
		case 1:
			System.out.println("Enter Book Name: ");
			Book tempbook = new Book();
			in = new Scanner(System.in);
			String tempname = in.nextLine();
			tempbook.setBookName(tempname);
			books.add(tempbook);
			break;
		case 2:

		case 3:

		case 4:

		case 5:

		case 6:

		case 7:
			for (int i = 0; i < books.size(); i++) {
				System.out.println(books.get(i).getBookName());
			}

		case 8:
			break;
		default:
			System.out.println("Error, make sure caps are right and words are spelled correctly");
			librarianMethod();
		}
	}

	public void userMethod() {

	}
}
