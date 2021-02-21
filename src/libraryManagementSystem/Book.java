package libraryManagementSystem;

import java.util.*;
public class Book {
	List<String> renewals = new ArrayList<String>();
	int size = 0;
	String name;
	boolean avail = true;
	String theauthor;
	Random random = new Random();
	String id;
	int bookCount;
	
	public Book() {
		
	}
	
	public Book(String name, String auth, int count) {
		super();
		this.name = name;
		this.theauthor = auth;		
		this.bookCount = count;
		this.setS1ID();
	}
	
	public void setName(String bookName) {
		name = bookName;
	}

	public String getName() {
		return name;
	}

	public void setAuthor(String author) {
		theauthor = author;
	}
	public String getAuthor() {
		return theauthor;
	}
	
	public void setS1ID() {
		id = String.format("%04d", random.nextInt(10000));
	}
	
	public String getS1ID() {
		return id;
	}
	
	public void setCount(int count) {
		bookCount = count;
	}
	
	public int getCount() {
		return bookCount;
	}
	
	
	public void printDetails() {
		System.out.print(getName() + ", ");
		System.out.print(getAuthor() + ", ");
		System.out.print(getS1ID() + ", ");
		System.out.println(getCount());
	}
		
}
	
