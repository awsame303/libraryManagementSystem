package libraryManagementSystem;
import java.util.*;
public class Member {
	boolean isHolding;
	Random random = new Random();
	String bookName, userID, userName;
	
	
	public void setName(String name) {
		userName = name;
	}
	
	public String getName() {
		return userName;
	}
	
	
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
	
	public void getName(String name) {
		bookName = name;
	}
	
	public String setName() {
		return bookName;
	}
}
