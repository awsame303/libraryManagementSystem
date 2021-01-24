package libraryManagementSystem;

import java.util.*;

public class Book {
	int size = 0;
	String name;
	boolean avail = true;
	String theauthor;
	Random random = new Random();
	String id;

	public void setBookName(String bookName) {
		name = bookName;
	}

	public String getBookName() {
		return name;
	}

	public void setAvail(boolean available) {
		avail = available;
		if (avail == false) {
			size = size - 1;
		} else {
			size = size + 1;
		}
	}

	public boolean getAvail() {
		return avail;
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
}
	
