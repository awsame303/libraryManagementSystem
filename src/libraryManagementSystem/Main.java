package libraryManagementSystem;

import java.util.*;

public class Main {
	List<Book> books = new ArrayList<Book>();
	List<Member> members = new ArrayList<Member>();
	Map<String, String> dates = new HashMap<String, String>();
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
		runner.initializeBooks();
		runner.initializeMembers();
		runner.process();
		// runner.test();

	}

	@SuppressWarnings("resource")
	public String input() {
		String person = "";
		Scanner in = new Scanner(System.in);
		person = in.next();
		return person;

	}

	@SuppressWarnings("resource")
	public void librarianMethod() {
		int doing = 0;
		@SuppressWarnings("unused")
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
				System.out.print(members.get(i).getUserName() + ", ");
				System.out.print(members.get(i).getHolding() + ", ");
				System.out.print(members.get(i).getUserID());
				System.out.println();
			}
			librarianMethod();
			break;
		case 4:
			for (int i = 0; i < members.size(); i++) {
				System.out.println(members.get(i).getDateOfReturn());
			}

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
	}

	public void userMethod() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int choice = 0;
		System.out.println(
				"What would you like to do, Take Membership: 1, Update details: 2, Hold return or renew books: 3, Delete Membership: 4, View Book Catalogue: 5, Exit to Main Menu: 6, or Exit: 7");
		choice = in.nextInt();		
		Member selMembr = null;
		if (choice > 1 && choice <=4) {
			System.out.println("What member are you? Enter your user ID or your name: ");
			in = new Scanner(System.in);
			String userNameOrID = in.nextLine();
			selMembr = this.getMemberByNameOrID(userNameOrID);
		}
		switch (choice) {
		case 1:
			Member tempmemb = new Member();
			in = new Scanner(System.in);
			System.out.println("Enter your full name: ");
			String nameOfMember = in.nextLine();
			tempmemb.setBookName(nameOfMember);
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
					userMethod();
				}
			}
			break;

		case 2:				
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
						userMethod();
						break;

					case 2:
						in = new Scanner(System.in);
						System.out.println("What would you like to change your phone number to? ");
						String numberSwitch = in.nextLine();
						selMembr.setPhoneNumber(numberSwitch);
						userMethod();
						break;
					case 3:
						in = new Scanner(System.in);
						System.out.println("What would you like to change your age to? ");
						int ageSwitch = in.nextInt();
						selMembr.setAge(ageSwitch);
						userMethod();
						break;

					}

				}
			userMethod();
			break;

		case 3:
				if (selMembr != null) {

					System.out.println("All books in catalougue");
					for (int i = 0; i < books.size(); i++) {
						books.get(i).printDetails();
					}
					System.out.println("Enter the S1ID of the book: ");
					String userS1ID = in.next();
					in = new Scanner(System.in);
					System.out.println("What would you like to do? Hold: 1, Return: 2, or Renew: 3");
					int userChoice = in.nextInt();
					Book selBook = getBookByS1ID(books, userS1ID);
					switch (userChoice) {
					case 1:					
						
							if (selBook != null && selBook.getCount() > 0) {
								// TODO finish holding
								selMembr.setHolding(true);
								selMembr.setBookName(selBook.getName());
								selMembr.setDateOfReturn();
								System.out.println("Book due on " + selMembr.getDateOfReturn());
								selBook.setCount(selBook.getCount() - 1);
							}
							userMethod();
							break;
					case 2:
						Date todaysDate = new Date();
						
					case 3:
						// TODO Do Renewing

					}
				}
			
			userMethod();
			break;

		case 4:
			for (int i = 0; i < members.size(); i++) {
				System.out.println(members.get(i).getBookName());
			}
			System.out.println("Enter the number of the person of which you would like to remove: ");
			int delchoice = in.nextInt();
			--delchoice;
			System.out.println(
					"Are you sure? Enter your full name in the box below to confirm deletion of your account: ");
			String name = in.nextLine();
			if (name == members.get(delchoice).getBookName()) {
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
				books.get(i).printDetails();
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
			break;

		}

	}

	public void createNewBook() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unused")
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
		@SuppressWarnings("resource")
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

	private Book getBookByS1ID(List<Book> books, String userS1ID) {
		Book bok = null;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getS1ID().equals(userS1ID)) {
				bok = books.get(i);
			}
		}
		
		return bok;
	}
}
