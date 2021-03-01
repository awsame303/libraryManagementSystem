package libraryManagementSystem;

import java.util.*;

import java.util.Calendar;

public class Member {
	boolean isHolding;
	Random random = new Random();
	String bookName, userID, userName, userPhoneNumber;
	int userAge;
	long daysBetween;
	long millis = System.currentTimeMillis();
	Date dateOfDue = null;
	Map<String, java.util.Date> heldBooks = new HashMap<String, java.util.Date>();
	
	public Member() {
		
	}
	
	public Member(String name, String phoneNumber, int age) {
		this.userName = name;
		this.userPhoneNumber = phoneNumber;
		this.userAge = age;
		generateUserID();
	}
	
	
	public void setHolding(boolean holding) {
		isHolding = holding;
	}

	public boolean getHolding() {
		return isHolding;
	}

	public void generateUserID() {
		userID = String.format("%04d", random.nextInt(10000000));
	}

	public String getUserID() {
		return userID;
	}

	
	public void setUserName(String name) {
		userName = name;
	}

	public String getUserName() {
		return userName;
	}
	
	
	
	public void setBooks(String name) {
		bookName = name;
		setDateOfReturn();
		heldBooks.put(name, dateOfDue);
	}

	public List<Map<String,Date>> getBooks() {
		System.out.println();
		return Collections.singletonList(heldBooks);
	}

	public void setPhoneNumber(String phoneNumber) {
		userPhoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return userPhoneNumber;
	}

	public void setAge(int age) {
		userAge = age;
	}

	public int getAge() {
		return userAge;
	}

	public void setDateOfReturn() {
		dateOfDue = new Date();
		int daysDue = 30;
		dateOfDue = this.addDays(dateOfDue, daysDue);		
	}

	public Date addDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return new Date(c.getTimeInMillis());
	}
	
	public Date getDateOfReturn() {
		return dateOfDue;
	}
	
	public void setDueDate(Date date) {
		dateOfDue = date;
		
	}

}
