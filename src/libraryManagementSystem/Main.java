package libraryManagementSystem;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String person = User();
		if (person == "Librarian") {
			System.out.println("You are a Librarian");
		} else if (person == "User") {
			System.out.println("You are a User");
		} else {
			System.out.println("Error, please try again");
		}

	}

	public static String User() {
		String person = "";
		System.out.println("Enter if Librarian or User");
		Scanner in = new Scanner(System.in);
		person = in.next();
		in.close();
		return person;

	}
}
