package jdbcconnection;
import java.util.*;
import java.sql.*;
public class Usingwhere {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","system","Asha");
				Statement stm = con.createStatement();
				System.out.println("entre the ohn ni");
				long phno=sc.nextLong();
				ResultSet rs=stm.executeQuery("select * from user66 where NUM="+phno+"");
				if(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3));
				}
				else {
					System.out.print("Invalid phn no");
				}}
			catch(Exception e) {
				System.out.print(e.toString());
			}
		}
	}
}
