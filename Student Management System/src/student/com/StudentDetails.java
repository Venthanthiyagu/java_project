package student.com;
import java.sql.*;
import java.util.*;
public class StudentDetails {
	static Scanner sc = new Scanner(System.in);
	String name;
	int id;
	double m1,m2,m3;
	char grade;
	
	public StudentDetails() {
		
	}
	
	public StudentDetails(String name, int id, double m1, double m2, double m3) {
		super();
		this.name = name;
		this.id = id;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}

	public void addStudent() {
		System.out.print("Enter your name : ");
		String name=sc.next();
		System.out.print("Enter your id : ");
		int id=sc.nextInt();
		System.out.print("Enter your m1 : ");
		int m1=sc.nextInt();
		System.out.print("Enter your m2 : ");
		int m2=sc.nextInt();
		System.out.print("Enter your m3 : ");
		int m3=sc.nextInt();
		
		StudentDetails sd = new StudentDetails(name, id, m1, m2, m3);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps = c.prepareStatement("insert into student_details values(?,?,?,?,?)");
			
			ps.setString(2, name);
			ps.setInt(1, id);
			ps.setDouble(3, m1);
			ps.setDouble(4, m2);
			ps.setDouble(5, m3);
			
			ps.executeUpdate();
			
			c.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Added Successfully");
		System.out.println("-------------------------------------");
		
	}
	
	public void removeStudent() {
		System.out.print("Enter your id : ");
		int id=sc.nextInt();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps = c.prepareStatement("delete from student_details where Id =?");
			
			ps.setInt(1, id);
			
			
			ps.executeUpdate();
			
			c.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Removed Successfully");
		System.out.println("-------------------------------------");
	}
	
	public void updateStudent() {
		System.out.print("Enter your id : ");
		int id=sc.nextInt();
		System.out.print("Enter your m1 : ");
		int m1=sc.nextInt();
		System.out.print("Enter your m2 : ");
		int m2=sc.nextInt();
		System.out.print("Enter your m3 : ");
		int m3=sc.nextInt();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps = c.prepareStatement("update student_details set Mark_1=?,Mark_2=?,Mark_3=? where Id =?");
			
			ps.setInt(4, id);
			ps.setDouble(1, m1);
			ps.setDouble(2, m2);
			ps.setDouble(3, m3);
			
			ps.executeUpdate();
			
			c.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Updated Successfully");
		System.out.println("-------------------------------------");
	}
	
	public void detailsOfStudent() {
		System.out.print("Enter your id : ");
		int id=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps = c.prepareStatement("Select * from student_details where Id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Id = "+rs.getInt("Id"));
				System.out.println("Name = "+rs.getString("Name"));
				System.out.println("Mark1 = "+rs.getDouble(3));
				System.out.println("Mark2 = "+rs.getDouble(4));
				System.out.println("Mark3 = "+rs.getDouble(5));
				
				double total = (rs.getDouble(3)+rs.getDouble(4)+rs.getDouble(5))/3;
				if(total>=90) {
					grade='A';
				}
				else if(total>=80) {
					grade='B';
				}
				else if(total>=70) {
					grade='C';
				}
				else if(total>=60) {
					grade='D';
				}
				else if(total>=50) {
					grade='E';
				}
				else {
					grade='F';
				}
				System.out.println("Grade = "+grade);
				System.out.println("------------------------------");
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		
		StudentDetails sd = new StudentDetails();
		
		boolean flag=true;
		
		do {
		System.out.println("Welcome to Student Details");	
		System.out.print("1.Add Student\n2.Remove Student\n3.Update Student\n4.Details of student\n5.Exit\n");
		System.out.print("Enter your choice : ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			sd.addStudent();
			break;
		case 2:
			sd.removeStudent();
			break;
		case 3:
			sd.updateStudent();
			break;	
		case 4:
			sd.detailsOfStudent();
			break;
		case 5:
			flag=false;
			break;
		}
		}while(flag);
		System.out.println("Thanking you...");

	}

}
