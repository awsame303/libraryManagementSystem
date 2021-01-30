package libraryManagementSystem;

import java.util.*;

public class Book {
	int size = 0;
	String name;
	boolean avail = true;
	String theauthor;
	Random random = new Random();
	String id;
	int bookCount;

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
}
	
