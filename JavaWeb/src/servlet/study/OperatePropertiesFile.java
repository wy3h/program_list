package servlet.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OperatePropertiesFile
 */
@WebServlet("/OperatePropertiesFile")
public class OperatePropertiesFile extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OperatePropertiesFile()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		readSrcDirPropCfgFile(response); // db1.properties file on src directory
		response.getWriter().println("<hr>");
		readWebRootDirPropCfgFIle(response); // db2.properties file on WEB-INF
												// directory
		response.getWriter().println("<hr>");
		readProCfgFile(response); // db3.properties file on db.config package
		response.getWriter().println("<hr>");
		readPropCfgFile2(response); // db4.properties file on servlet.study
									// package

	}

	private void readSrcDirPropCfgFile(HttpServletResponse response)
			throws IOException
	{
		InputStream in = this.getServletContext().getResourceAsStream(
				"/WEB-INF/classes/servlet/study/db4.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println(
				"读取src目录下的gacl.servlet.study包中的db4.properties配置文件：");
		response.getWriter().println(
				MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", driver,
						url, username, password));
	}

	private void readWebRootDirPropCfgFIle(HttpServletResponse response)
			throws IOException
	{
		InputStream in = this.getServletContext().getResourceAsStream(
				"/WEB-INF/db2.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("读取WebRoot目录下的db2.properties配置文件：");
		response.getWriter().print(
				MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", driver,
						url, username, password));

	}

	private void readProCfgFile(HttpServletResponse response)
			throws IOException
	{
		String path = this.getServletContext().getRealPath(
				"/WEB-INF/classes/db/config/db3.properties");
		InputStream in = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter()
				.println("读取src目录下的db.config包中的db3.properties配置文件：");
		response.getWriter().println(
				MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", driver,
						url, username, password));

	}

	private void readPropCfgFile2(HttpServletResponse response)
			throws IOException
	{
		// TODO Auto-generated method stub
		InputStream in = this.getServletContext().getResourceAsStream(
				"/WEB-INF/classes/servlet/study/db4.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println(
				"读取src目录下的gacl.servlet.study包中的db4.properties配置文件：");
		response.getWriter().println(
				MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", driver,
						url, username, password));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

}
