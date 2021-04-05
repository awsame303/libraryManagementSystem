package com.pt.libraryManagementSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.pt.objects.*;

public class Main {
	List<Book> books = new ArrayList<Book>();
	List<Member> members = new ArrayList<Member>();
	protected final String passw = "awesome";
	private int tries = 0;
	User user = new User(books, members);
	Librarian librarian = new Librarian(books, members);

	public static void main(String[] args) {
		Main runner = new Main();
		runner.initializeBooks();
		runner.initializeMembers();
		runner.process();
		// runner.test();

	}

	public void process() {
		System.out.println("Enter if Librarian or User");
		String person = input();
		while (true) {
			if (person.equals("Librarian")) {
				System.out.println("You are a Librarian");
				try {
					librarianPassword();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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

	protected void librarianPassword() throws InterruptedException {
		Scanner in = null;
		if (tries <= 5) {
			in = new Scanner(System.in);
			System.out.println("Enter password to enter librarian system: ");
			String pass = in.nextLine();
			if (pass.equals(passw)) {
				System.out.println("Entering librarian method");
				librarianMethod();
			} else {
				tries = tries + 1;
				System.out.println("Incorrect password, you have used " + tries + " out of the 5 tries.");
				librarianPassword();
			}
			in.close();
		} else {
			System.out.println("You have used all of your tries, please wait for your ten minutes to be up.");
			Thread.sleep(10000);
			tries = 0;
			librarianPassword();
		}
	}

	@SuppressWarnings("resource")
	public String input() {
		String person = "";
		Scanner in = new Scanner(System.in);
		person = in.next();
		return person;

	}

	@SuppressWarnings("resource")
	public void librarianMethod() throws NoSuchElementException {
		int doing = 0;
		@SuppressWarnings("unused")
		boolean available = false;
		Scanner in = new Scanner(System.in);
		System.out.println(
				"What would you like to do, Add New Books: 1, Add/Remove Count to Book: 2, Track Members: 3, Track Transitions of Renewals: 4, Or Show All Books: 5, Exit to Main Menu: 6, or Exit: 7");
		try {
			doing = in.nextInt();
			switch (doing) {
			case 1:
				librarian.createNewBook();
				librarianMethod();
				break;
			case 2:
				librarian.setBookAvail();
				librarianMethod();
				break;
			case 3:
				librarian.trackMembers();
				librarianMethod();
				break;
			case 4:
				for (int i = 0; i < members.size(); i++) {
					System.out.println();
					System.out.print(members.get(i).getUserName() + ": ");
					members.get(i).printCheckedOutBooks();

				}
				librarianMethod();
				break;

			case 5:
				for (int i = 0; i < books.size(); i++) {
					books.get(i).printDetails();
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
		} catch (InputMismatchException d) {
			System.out.println("Please enter a number");
			librarianMethod();
		}
	}

	public void userMethod() throws NoSuchElementException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int best = 0;
		System.out.println(
				"What would you like to do, Take Membership: 1, Update details: 2, Hold return or renew books: 3, Delete Membership: 4, View Book Catalogue: 5, View Due Dates Of Your Books: 6, Exit to Main Menu: 7, or Exit: 8");
		try {
			best = in.nextInt();
			Member selMembr = null;
			if (best > 1 && best <= 4 || best == 6) {
				System.out.println("What member are you? Enter your user ID or your name: ");
				in = new Scanner(System.in);
				String userNameOrID = in.nextLine();
				selMembr = this.getMemberByNameOrID(userNameOrID);
			}
			switch (best) {
			case 1:

				user.createMember();
				userMethod();
				break;

			case 2:
				user.updateDetails(selMembr);
				userMethod();
				break;

			case 3:
				user.updateBookThings(selMembr);
				userMethod();
				break;

			case 4:
				user.delMember(selMembr);
				userMethod();
				break;
			case 5:
				System.out.println("All books in catalougue");
				for (int i = 0; i < books.size(); i++) {
					books.get(i).printDetails();
				}

				userMethod();
				break;

			case 6:
				selMembr.printCheckedOutBooks();
				userMethod();
				break;

			case 7:
				process();
				break;
			case 8:
				break;
			default:
				System.out.println("Error, make sure caps are right and words are spelled correctly");
				userMethod();
				break;

			}
		} catch (InputMismatchException d) {
			System.out.println("Please enter a number");
			userMethod();
		} catch (NullPointerException e) {
			System.out.println("This member does not exist. Please check for errors or create a membership");
			userMethod();
		}

	}

	private void initializeBooks() {
		Book book1 = new Book("Percy Jackson", "Rick Riordan", 4);
		Book book2 = new Book("Harry Motter", "J. K. Rowling", 4);
		Book book3 = new Book("Wonder", "R. J. Palacio", 4);
		Book book4 = new Book("Happy", "Pranav Thota", 4);
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
	}

	private void initializeMembers() {
		Member member1 = new Member("Pranav Thota", "(732)-742-9253", 12);
		Member member2 = new Member("Akka Thota", "(732)-750-9021", 16);
		Member member3 = new Member("Mommy Thota", "(732)-775-9127", 45);
		Member member4 = new Member("Daddy Thota", "(732)-234-9283", 48);
		members.add(member1);
		members.add(member2);
		members.add(member3);
		members.add(member4);
	}

	public void test() {
	}

	private Member getMemberByNameOrID(String nameOrID) {
		Member membr = null;

		for (int member = 0; member < members.size(); member++) {
			if (members.get(member).getUserID().equals(nameOrID)
					|| members.get(member).getUserName().equals(nameOrID)) {
				membr = members.get(member);
			}
		}

		return membr;
	}

}
