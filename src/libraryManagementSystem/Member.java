package libraryManagementSystem;
import java.util.*;
import java.text.SimpleDateFormat;
public class Member {
	boolean isHolding;
	Random random = new Random();
	String bookName, userID, userName;
	
	
	
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
	
	public boolean setDateOfReturn(int year, int month, int day) {
		Date today = new Date();
		Calendar myNextCalendar = Calendar.getInstance();
		myNextCalendar.set(year, month, day);
		Date due = myNextCalendar.getTime();
		
		Member obj = new Member();
		long days = obj.daysBetween(today, due);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");
		String todaysDate = sdf.format(today);
		String dueDate = sdf.format(due);
		if (days > 30) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}
	
}
