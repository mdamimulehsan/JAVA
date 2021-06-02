
public class Book {
	String title, authorName, isbn;
	int noOfCopies;
	
	public Book() {
		
	}

	public Book(String title, String authorName,String isbn, int noOfCopies) {
		//super();
		this.title = title;
		this.authorName = authorName;
		this.isbn = isbn;
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", authorName=" + authorName +", isbn=" + isbn + ", noOfCopies=" + noOfCopies + "]";
	}
	
	public void display() {
		System.out.println(this);
	}
	
	
	

}











