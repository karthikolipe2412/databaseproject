package jdbcconnection;
import java.util.*;
import java.sql.*;
public class Jdbc {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step-2 : Creating Connection
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","Asha");
			//step-3 : Preparing JDBC-Statement
			Statement stm = con.createStatement();
			System.out.println("Enter the name :");
			String name=sc.nextLine();
			System.out.println("Enter the job tye:");
			String empname=sc.nextLine();
			System.out.println("enter the user phone number:");
			long phno=Long.parseLong(sc.nextLine());
			int k=stm.executeUpdate("insert into user66 values('"+name+"','"+empname+"',"+phno+")");
			if(k>0) {
				System.out.println("user details are upadartes");
			}
			con.close();
	}
		catch(SQLIntegrityConstraintViolationException se)
		{
		System.out.println("User details already available...");
		}
		catch(Exception e) {
			System.out.print(e.toString());
		}
	}

}}
