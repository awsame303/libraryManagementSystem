package libraryManagementSystem;
import java.util.*;
public class Librarian {
	List<String> books = new ArrayList<String>();
	public void addNewBooks() {
		Scanner in = new Scanner(System.in);
		System.out.println("What is the name of the book you would like to enter?");
		books.add(in.nextLine());	
	}
}
