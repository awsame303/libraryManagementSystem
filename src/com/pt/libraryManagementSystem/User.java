package com.pt.libraryManagementSystem;

import java.util.*;
import com.pt.objects.*;

public class User {
	List<Book> books = null;
	List<Member> members = null;

	public User(List<Book> books, List<Member> members) {
		this.books = books;
		this.members = members;
	}

	public void createMember() {
		Member tempmemb = new Member();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		System.out.println("Enter your full name: ");
		String nameOfMember = in.nextLine();
		tempmemb.setUserName(nameOfMember);
		if (!nameOfMember.isEmpty()) {

			System.out.println("Enter your phone number: ");
			String phoneNumber = in.nextLine();
			tempmemb.setPhoneNumber(phoneNumber);

			if (!phoneNumber.isEmpty()) {
				System.out.println("Enter your age: ");
				int age = in.nextInt();
				tempmemb.setAge(age);
				tempmemb.generateUserID();
				tempmemb.setHolding(false);
				members.add(tempmemb);
			}
		}
	}

	public void updateDetails(Member selMembr) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		if (selMembr != null) {
			System.out.println("What would you like to change? Name: 1, Phone Number: 2, or Age: 3");
			int changeChoice = in.nextInt();
			switch (changeChoice) {
			case 1:
				in = new Scanner(System.in);
				System.out.println("What would you like to change your name to? ");
				String newName = in.nextLine();
				System.out.println(newName);
				selMembr.setUserName(newName);
				// userMethod();
				break;

			case 2:
				in = new Scanner(System.in);
				System.out.println("What would you like to change your phone number to? ");
				String numberSwitch = in.nextLine();
				selMembr.setPhoneNumber(numberSwitch);
				// userMethod();
				break;
			case 3:
				in = new Scanner(System.in);
				System.out.println("What would you like to change your age to? ");
				int ageSwitch = in.nextInt();
				selMembr.setAge(ageSwitch);
				// userMethod();
				break;

			}

		}

	}

	public void updateBookThings(Member selMembr) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		if (selMembr != null) {

			System.out.println("All books in catalougue");
			for (int i = 0; i < books.size(); i++) {
				books.get(i).printDetails();
			}
			System.out.println("Enter the S1ID of the book: ");
			String userS1ID = in.next();
			System.out.println("What would you like to do? Hold: 1, Return: 2, or Renew: 3");
			int userChoice = in.nextInt();
			Book selBook = getBookByS1ID(userS1ID);
			switch (userChoice) {
			case 1:
				if (selBook != null && selBook.getCount() > 0) {
					selMembr.setHolding(true);
					selMembr.setBooks(selBook.getName());
					selMembr.setDateOfReturn();
					System.out.println("Book due on " + selMembr.heldBooks.get(selBook.getName()));
					selBook.setCount(selBook.getCount() - 1);
				}

				break;
			case 2:
				if (selBook != null && selMembr.getBooks() != null) {
					selBook.setCount(selBook.getCount() + 1);
					selMembr.setHolding(false);
					selMembr.setBooks(null);
					System.out.println("Book returned");
				} else {
					System.out.println("You are not currently holding a book");
				}
				break;

			case 3:
				if (selBook != null && selMembr.getBooks() != null) {
					selMembr.heldBooks.replace(selBook.getName(), selMembr.getDateOfReturn());
					System.out.print("Book name and Book due date: ");
					selMembr.printCheckedOutBooks();
				} else {
					System.out.println("You are not holding a book");
					break;
				}
			}
		}
	}

	public void delMember(Member selMembr) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < members.size(); i++) {

			if (selMembr == members.get(i)) {

				System.out.println(
						"Are you sure? Enter your full name in the box below to confirm deletion of your account: ");
				String name = in.nextLine();
				if (name.equals(selMembr.getUserName())) {
					members.remove(i);
					break;
				} else {
					System.out.println("Wrong name entered. Quitting...");
					break;
				}
			}
		}

	}

	public Book getBookByS1ID(String userS1IDorName) {
		Book bok = null;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getS1ID().equals(userS1IDorName) || books.get(i).getName().equals(userS1IDorName)) {
				bok = books.get(i);
			}
		}

		return bok;
	}
}
