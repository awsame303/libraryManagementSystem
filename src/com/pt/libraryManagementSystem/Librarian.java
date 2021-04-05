package com.pt.libraryManagementSystem;

import java.util.List;
import java.util.Scanner;

import com.pt.objects.Book;
import com.pt.objects.Member;

public class Librarian {
	List<Book> books = null;
	List<Member> members = null;

	public Librarian(List<Book> books, List<Member> members) {
		this.books = books;
		this.members = members;
	}

	public void createNewBook() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Book Name: ");
		Book tempbook = new Book();
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

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the S1ID or name of the book which you would like to add/reduce the count of: ");
		String Stringors1id = in.nextLine();
		Book selBook = getBookByS1ID(Stringors1id);
		try {

			System.out.println("You are editing the count of " + selBook.getName());
			System.out.println(
					"This book is currently has " + selBook.getCount() + " books, would you like to change this(Y/N)?");
			switch (in.next()) {
			case "Y":
				System.out.println("What would you like to change this to?");
				selBook.setCount(in.nextInt());
				System.out.println("Amount changed");
				break;

			case "N":
				System.out.println("Exited");
				break;
			}
		} catch (NullPointerException d) {
			System.out.println("Invalid Name Or S1ID, please try again");
			setBookAvail();
		}

	}

	public void trackMembers() {
		for (int i = 0; i < members.size(); i++) {
			System.out.print(members.get(i).getUserName() + ", ");
			System.out.print(members.get(i).getHolding() + ", ");
			System.out.print(members.get(i).getUserID());
			System.out.println();
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
