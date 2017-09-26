package shoppingManagerSystem;

import java.sql.*;

public class DatabaseConnect
{
	static final String DB_URL = "jdbc:mysql://localhost/shop-manager";
	
	static final String USER = "root";
	static final String PASS = "";
	
	public static Connection createConnect()
	{
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
