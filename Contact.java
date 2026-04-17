package project1;


public class Contact{
	static String name;
	static String ph_no;
	
	public Contact(String name, String ph_no) {
		super();
		this.name = name;
		this.ph_no = ph_no;
	}
	
	public String toString() {
		return "Name : "+name+","+" Phone Number : "+ph_no;
	}	
	
}
