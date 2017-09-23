package jdbcResultSet;

import java.sql.*;

public class ResultSetTest
{
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/example";

		static final String USER = "root";
		static final String PASS = "";

		public static void main(String[] args)
		{
			Connection conn = null;
			Statement stmt = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");

				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				System.out.println("Creating statement...");
				stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
				String sql = "SELECT id, age, name FROM emp";
				ResultSet rs = stmt.executeQuery(sql);
				
				// create 50 robot to emp
				for(int i = 1; i <= 50; i++)
				{
					rs.moveToInsertRow();
					rs.updateInt(1, 1000 + i);
					rs.updateInt(2, i);
					rs.updateString(3, "Robot" + Integer.toString(i));
					rs.insertRow();
					rs.moveToCurrentRow();
				}
				
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException se)
			{
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e)
			{
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally
			{
				// finally block used to close resources
				try
				{
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2)
				{
				} // nothing we can do
				try
				{
					if (conn != null)
						conn.close();
				} catch (SQLException se)
				{
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("There are so thing wrong!");
		}// end main
}
