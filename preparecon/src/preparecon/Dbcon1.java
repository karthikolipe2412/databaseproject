package preparecon;
import java.sql.*;
import java.util.*;
public class Dbcon1 {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
try(sc;){
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Asha");
	PreparedStatement ps1=con.prepareStatement("insert into bookdetails66 values(?,?,?)");
	PreparedStatement ps2=con.prepareStatement("select * from bookdetails66");
	PreparedStatement ps3=con.prepareStatement("select * from bookdetails66 where bookid=?");
	PreparedStatement ps4=con.prepareStatement("update bookdetails66 set bookname=? where bookid=?");
	PreparedStatement ps5=con.prepareStatement("delete from bookdetails66 where bookid=?");
	while(true) {
		System.out.println("........choose one.......");
		System.out.println("\t1.Add the details to add in to thte table"+"\n\t2.retrieve all data from the table"+"\n\t3.view using the bookid"+"\n\t4.update suing bookid"+"\n\t5.deleteusing bookid"+"\n\t6.Exit");
		System.out.println("enter yout choice");
		int choice=Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1:
			System.out.println("=====Book details=====");
			System.out.println("enter the book code");
			int bc=Integer.parseInt(sc.nextLine());
			System.out.println("enter the book name");
			String bn=sc.nextLine();
			System.out.println("entre the book type");
			String bt=sc.nextLine();
			ps1.setInt(1, bc);
			ps1.setString(2, bn);
			ps1.setString(3, bt);
			int k=ps1.executeUpdate();
			if(k>0) {
				System.out.println("details inserted");
			}
			break;
		case 2:
			ResultSet rs=ps2.executeQuery();
			System.out.print("=====details of the books");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			break;
		case 3:
			System.out.println("enter the bookid");
			int bookid=Integer.parseInt(sc.nextLine());
			ps3.setInt(1, bookid);
			ResultSet rs3=ps3.executeQuery();
			if(rs3.next()) {
				System.out.println("bookid is:"+rs3.getInt(1));
				System.out.println("bookname is:"+rs3.getString(2));
				System.out.println("booktype is:"+rs3.getString(3));
			}
			else {
				System.out.println("invalid bookid");
			}
			break;
		case 4:
			System.out.println("enter the book id");
			int bid1=sc.nextInt();
			ps4.setInt(1, bid1);
			ResultSet rs4=ps4.executeQuery();
			while(rs4.next()) {
				System.out.println("the old bookname is:"+rs4.getString(2));
				System.out.println(":enter the bookname to be set");
				String bookname4=sc.nextLine();
				ps4.setString(2, bookname4);
				int k1=ps4.executeUpdate();
				if(k1>0) {
					System.out.println("details upadated succesfully");
				}
				else {
					System.out.println("Invalid book code");
				}
			}
			break;
		case 5:
			System.out.println("enter the book id ro delete");
			int bookid5=Integer.parseInt(sc.nextLine());
			ps3.setInt(1, bookid5);
			ResultSet rs5=ps3.executeQuery();
			if(rs5.next()) {
				ps5.setInt(1, bookid5);
				int k5=ps5.executeUpdate();
				if(k5>0) {
					System.out.println("deletd succesfully");
				}
				else {
					System.out.println("invalid book code");
				}
			}
			
			break;
		case 6:
			System.out.println("Program Stopped..");
			System.exit(0);
			default:
			System.out.println("Invalid Choice...");
			}
			}
			}
catch(Exception e) {
	System.out.println(e.toString());
}
		
	}

}
