package libraryManagementSystem;

import java.util.*;

public class Main {
	Librarian librarian = new Librarian();
	User user = new User();

	public void process() {
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
		System.out.println("Enter if Librarian or User");
		Scanner in = new Scanner(System.in);
		person = in.next();
		return person;

	}

	public void librarianMethod() {
		String doing = "";
		Scanner in = new Scanner(System.in);
		System.out.println("What would you like to do: Add New Books, Update availability of a book, Add Count to Book, Track Members, or Track Transitions of Renewals");
		doing = in.nextLine();
		switch(doing) {
		case "Add New Books":
			System.out.println("HEY");
			break;
		case "Update availability of a book":
			
		case "Add Count to Book":
			
		case "Track Members":
		
		case "Track Transitions of Renewals":
			
		default:
			System.out.println("Error, make sure caps are right and words are spelled correctly");
			librarianMethod();
			break;
		}
		}
	
	


	public void userMethod() {
		
	}
}
