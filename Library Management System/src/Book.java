public class Book {
     int id;
     String title;
     String author;
     boolean isAvailable;
    // Constructor, getters, setters
	public Book(int id, String title, String author, boolean isAvailable) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable + "]";
	}
    
	
}