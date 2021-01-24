package libraryManagementSystem;

import java.util.*;

public class Book {
	int size = 0;
	String name;
	boolean avail = true;
	String theauthor;
	double S1ID = 0;

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
		S1ID = Math.random() * 1000;
	}
	
	public double getS1ID() {
		return S1ID;
	}
}
	
