package libraryManagementSystem;

import java.util.*;
import java.sql.*;

public class Main {
	List<Book> books = new ArrayList<Book>();
	List<Member> members = new ArrayList<Member>();
	HashMap<String, String> dates = new HashMap<String, String>();
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
				"What would you like to do, Add New Books: 1, Add/Remove Count to Book: 2, Track Members: 3, Track Transitions of Renewals: 4, Or Show All Books: 5, Exit to Main Men: 6, or Exit: 7");
		doing = in.nextInt();
		switch (doing) {
		case 1:
			createNewBook();
			librarianMethod();
			break;
		case 2:
			setBookAvail();
			librarianMethod();
			break;
		case 3:
			for (int i = 0; i < members.size(); i++) {
				System.out.print(members.get(i).getName() + ", ");
				System.out.print(members.get(i).getHolding() + ", ");
				System.out.print(members.get(i).getUserID() + ", ");
				System.out.println(dates.get(members.get(i).getName()));
			}
		case 4:
			for (int i = 0; i < members.size(); i++) {
				System.out.println(members.get(i).getName());
			}

		case 5:
			for (int i = 0; i < books.size(); i++) {
				System.out.print(books.get(i).getName() + ", ");
				System.out.print(books.get(i).getAuthor() + ", ");
				System.out.print(books.get(i).getS1ID() + ", ");
				System.out.println(books.get(i).getCount());
			}
			librarianMethod();
			break;
		case 6:
			process();
			break;
		
		case 7:
			break;
			
		default:
			System.out.println("Error, make sure caps are right and words are spelled correctly");
			librarianMethod();
		}
	}

	public void userMethod() {
		Scanner in = new Scanner(System.in);
		int choice = 0;
		System.out.println(
				"What would you like to do, Take Membership: 1, Update details: 2, Hold return or renew books: 3, Delete Membership: 4, View Book Catalogue: 5, Exit to Main Menu: 6, or Exit: 7");
		choice = in.nextInt();
		switch (choice) {
		case 1:
			Member tempmemb = new Member();
			System.out.println("Enter your full name: ");
			String nameOfMember = in.nextLine();
			tempmemb.setName(nameOfMember);
			tempmemb.setUserID();
			tempmemb.setHolding(false);
			members.add(tempmemb);
			userMethod();
			break;
			
		case 2:

		case 3:

		case 4:
			for (int i = 0; i < members.size(); i++) {
				System.out.println(members.get(i).getName());
			}
			System.out.println("Enter the number of the person of which you would like to remove: ");
			int delchoice = in.nextInt();
			System.out.println("Are you sure? Enter your full name in the box below to confirm deletion of your account: ");
			String name = in.nextLine();
			if (name == members.get(delchoice).getName()) {
				members.remove(delchoice);
			} else {
				System.out.println("Wrong name entered. Quitting...");
				userMethod();
				break;
			}
			userMethod();
			break;
		case 5:
			System.out.println("All books in catalougue");
			for (int i = 0; i < books.size(); i++) {
				System.out.print(books.get(i).getName() + ", ");
				System.out.print(books.get(i).getAuthor() + ", ");
				System.out.print(books.get(i).getS1ID() + ", ");
				System.out.println(books.get(i).getCount());
			}
			
		userMethod();
		break;
		case 6:
			process();
			break;
		case 7: 
			break;
		default:
			System.out.println("Error, make sure caps are right and words are spelled correctly");
			userMethod();
		

		}

	}

	public void createNewBook() {
		Scanner in = new Scanner(System.in);
		boolean available = false;

		System.out.println("Enter Book Name: ");
		Book tempbook = new Book();
		in = new Scanner(System.in);
		String tempname = in.nextLine();
		tempbook.setName(tempname);
		System.out.println("Enter the author of the book: ");
		String author = in.nextLine();
		tempbook.setAuthor(author);
		System.out.println("Enter the amount of books coming into the library: ");
		int amount = in.nextInt();
		tempbook.setCount(amount);
		tempbook.setS1ID();
		books.add(tempbook);
		System.out.println("Book created");
	}

	public void setBookAvail() {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).getName() + ", " + books.get(i).getCount());
		}
		System.out.println("Enter the number of the book which you would like to reduce the count of: ");
		// Most people will go from 1+ instead of 0+
		int numOfBook = in.nextInt() - 1;
		System.out.println(books.size());
		System.out.println("You are editing the count of " + books.get(numOfBook).getName());
		System.out.println("This book is currently has " + books.get(numOfBook).getCount()
				+ " books, would you like to change this(Y/N)?");
		switch (in.next()) {
		case "Y":
			System.out.println("What would you like to change this to?");
			books.get(numOfBook).setCount(in.nextInt());
			System.out.println("Amount changed");

		case "N":
			System.out.println("Exited");
			librarianMethod();
			break;

		}
	}

	public void test() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter year(YYYY)");
		int year = in.nextInt();
		System.out.println("Enter day(DD)");
		int day = in.nextInt();
		System.out.println("Enter Month(Like Feburary as 2 and October as 10)");
		int month = in.nextInt();
		System.out.println();
		members.get(0).setDateOfReturn(year, month - 1, day);
		;

	}
}