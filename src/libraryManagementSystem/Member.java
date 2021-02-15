package libraryManagementSystem;

import java.util.*;

public class Member {
	boolean isHolding;
	Random random = new Random();
	String bookName, userID, userName, userPhoneNumber;
	int userAge;
	long daysBetween;

	public void setHolding(boolean holding) {
		isHolding = holding;
	}

	public boolean getHolding() {
		return isHolding;
	}

	public void setUserID() {
		userID = String.format("%04d", random.nextInt(10000000));
	}

	public String getUserID() {
		return userID;
	}

	public void setName(String name) {
		bookName = name;
	}

	public String getName() {
		return bookName;
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
	

	public void setDateOfReturn(int year, int month, int day) {
		Date today = new Date();
		Calendar myNextCalendar = Calendar.getInstance();
		myNextCalendar.set(year, month, day);
		Date due = myNextCalendar.getTime();	
		Member obj = new Member();
		long days = obj.daysBetween(today, due);
		daysBetween = days;
		
	}

	public long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}

	public long getDateOfReturn() {
		return daysBetween;
	}
}
