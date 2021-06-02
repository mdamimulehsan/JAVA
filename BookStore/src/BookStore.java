import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
	String name;
	ArrayList<Book> books = new ArrayList<>();
	
	public BookStore(String name) {
		super();
		this.name = name;
	}
	
	public void sell(String title, int quantity) {
		boolean found = false;
		for(int i=0; i<books.size(); i++) {
			Book b = books.get(i);
			if(b.title.equals(title)) {
				found = true;
				if(b.noOfCopies >= quantity) {
					b.noOfCopies -= quantity;
					System.out.println("Successfully Sold.");
				}
				else
					System.out.println("Not enough copy.");
				break;
			}
		}
		
		if(!found)
			System.out.println("The book is not available.");
	}
	

	public void order(String isbn, int quantity) {
		boolean found = false;
		for(int i=0; i<books.size(); i++) {
			Book b = books.get(i);
			if(b.isbn.equals(isbn)) {
				found = true;
				b.noOfCopies += quantity;
				break;
			}
		}
		
		if(!found) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter the title and authorname of the book.");
			String title = scan.next();
			String au = scan.next();
			Book b1 = new Book(title, au, isbn, quantity);
			books.add(b1);
		}
	}
	
	
	public void display() {
		if(books.size()==0)
		{
			System.out.println("No books.");
			return;
		}
		for(int i=0; i<books.size(); i++) {
//			books.get(i).display();
			Book b = books.get(i);
			b.display();
		}
	}
}






