package jdbcPrepareStatement;
import java.sql.*;

public class PreparedStatementTest
{
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/example";

		static final String USER = "root";
		static final String PASS = "";

		public static void main(String[] args)
		{
			Connection conn = null;
			PreparedStatement stmt = null;
			try
			{
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// STEP 4: Execute a query
				System.out.println("Creating statement...");
				String sql = "INSERT employees values(?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, 101);
				stmt.setInt(2, 22);
				stmt.setString(3, "Tom");
				stmt.setString(4, "Jerry");
				stmt.executeUpdate();
				
				// STEP 6: Clean-up environment
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
