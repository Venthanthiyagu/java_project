import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
     static List<Book> books= new ArrayList<>();;
     static List<User> users = new ArrayList<>();
    // Methods: addBook, viewBooks, issueBook, returnBook, addUser, login, etc.
    static Scanner sc=new Scanner(System.in);
    
    public void addBook() {
    	try {
    		System.out.println("Enter Id:");
    		int id=sc.nextInt();
    		sc.nextLine();
    		System.out.println("Enter Book Name:");
    		String bname=sc.nextLine();
    		System.out.println("Enter Author Name:");
    		String aname=sc.nextLine();
    		System.out.println("Enter isAvailable:");
    		boolean avail=sc.nextBoolean();
    	Book b1=new Book(id,bname,aname,avail);
    	books.add(b1);
    	System.out.println("Book added successfully...");
    	}catch(Exception e){
    		System.out.println("Enter correctly...");
    		sc.nextLine();
    	}
    }
    public void viewBooks() {
    	if(books.isEmpty()) {
    		System.out.println("No Book Available");
    	}
    	for(Book b:books) {
    		System.out.println(b);
    	}
    }
    public void issueBook() {
    	System.out.println("Enter Book Id : ");
    	int user_id=sc.nextInt();
    	for(Book b:books) {
    	if(b.id==user_id){
    		if(b.isAvailable) {
    		  b.isAvailable=false;
    		  System.out.println("Book issued Successfully...");
    		}
    		else
    			System.out.println("Book is already issued...");
    		return;
    		}
    	}
    	System.out.println("Book Not found");
    }
    public void returnBook() {
    	System.out.println("Enter Book Id : ");
    	int user_id=sc.nextInt();
    	for(Book b:books) {
    		if(b.id==user_id){
        		if(!b.isAvailable) {
        		  b.isAvailable=true;
        		  System.out.println("Book returned Successfully...");
        		}
        		else
        			System.out.println("Book was not issued...");
        		return;
        		}
        	}
        	System.out.println("Book Not found");
    }
    public void addUser() {
    	System.out.println("Enter your Username :");
    	String name=sc.next();
    	System.out.println("Enter your password : ");
    	String password = sc.next();
    	User u1=new User(name,password);
    	users.add(u1);
    	System.out.println("User Added successfully...");
    }
    /*"The Great Gatsby" by F. Scott Fitzgerald, "To Kill a Mockingbird" by Harper Lee, 
     * "Pride and Prejudice" by Jane Austen, "War and Peace" by Leo Tolstoy, "One Hundred Years of Solitude" by Gabriel Garcia Marquez, 
     * "Don Quixote" by Miguel de Cervantes, "The Catcher in the Rye" by J.D. Salinger, 
     * "Madame Bovary" by Gustave Flaubert, "The Alchemist" by Paulo Coelho, and "Harry Potter and the Philosopher's Stone" by J.K. Rowling*/
    
    public static void main(String[] args) {
    	
    	
    	LibraryManagementSystem lms=new LibraryManagementSystem();
    	
    	boolean flag=true;
    	do {
    	System.out.print("1.addBook\n");
    	System.out.print("2.viewBooks\n");
    	System.out.print("3.issueBook\n");
    	System.out.print("4.returnBook\n");
    	System.out.print("5.AddUser\n");
    	System.out.print("6.Exit\n");
    	
    	System.out.println("Enter your choice : ");
    	int user=sc.nextInt();
    	switch(user) {
    	case 1:
    		lms.addBook();
    		break;
    	case 2:
    		lms.viewBooks();
    		break;
    	case 3:
    		lms.issueBook();
    		break;
    	case 4:
    		lms.returnBook();
    		break;
    	case 5:
    		lms.addUser();
    		break;
    	case 6:
    		flag=false;
    		break;
    	}
    	}while(flag);
		System.out.println("Thank you...");
	}
}