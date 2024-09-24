package jdbcconnection;
import java.sql.*;
public class Kam {

	public static void main(String[] args) {
		try {
			//step-1 : Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step-2 : Creating Connection
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","Asha");
			//step-3 : Preparing JDBC-Statement
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from User66");
			while(rs.next())
			{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
			"\t"+rs.getLong(3));
			}
			con.close();
		}
		catch(Exception e) {
			System.out.print(e.toString());
		}
	}

}
