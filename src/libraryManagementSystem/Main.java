package libraryManagementSystem;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String person = User();
		while (true) {
			if (person.equals("Librarian")) {
				System.out.println("You are a Librarian");
				break;
			} else if (person.equals("User")) {
				System.out.println("You are a User");
				break;
			} else {
				System.out.println("Error, please try again");
				person = User();
			}
			
		}

	}

	public static String User() {
		String person = "";
		System.out.println("Enter if Librarian or User");
		Scanner in = new Scanner(System.in);
		person = in.next();
		return person;

	}
}
