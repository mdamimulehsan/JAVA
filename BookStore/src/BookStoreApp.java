import java.util.Scanner;

public class BookStoreApp {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		BookStore bs = new BookStore("Awesome B1");
		
		while(true) {
			int option = showMenu();
			
			switch(option) {
			case 1: // display
				bs.display();
				break;
			case 2: // sell
				System.out.println("Please enter the title and quantity.");
				String t = scan.next();
				int q = scan.nextInt();
				bs.sell(t, q);
				break;
			case 3: //order
				System.out.println("Please enter the isbn and quantity.");
				String isbn = scan.next();
				int quantity = scan.nextInt();
				bs.order(isbn, quantity);
				break;
			case 0:
				System.exit(0);
				//break;
			}
		}
		

	}
	
	public static int showMenu() {
		System.out.println("Please enter '1' to display\n'2' to sell\n'3' to order and\n'0' to exit.");
		int option = scan.nextInt();
		return option;
		
	}

}
