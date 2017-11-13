package servlet.study;

import java.io.*;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassLoaderReadFile
 */
@WebServlet("/ClassLoaderReadFile")
public class ClassLoaderReadFile extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassLoaderReadFile()
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
		test1(response);
		response.getWriter().println("<hr/>");
		test2(response);
		response.getWriter().println("<hr/>");
		// test3();
		// test4();
	}

	private void test1(HttpServletResponse response) throws IOException
	{
		ClassLoader loader = ClassLoaderReadFile.class.getClassLoader();
		InputStream in = loader.getResourceAsStream("db1.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("用类装载器读取src目录下的db1.properties配置文件");
		response.getWriter().println(
				MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", driver,
						url, username, password));
	}

	private void test2(HttpServletResponse response) throws IOException
	{
		ClassLoader loader = ClassLoaderReadFile.class.getClassLoader();
		// 用类装载器读取src目录下的gacl.servlet.study包中的db4.properties配置文件
		InputStream in = loader
				.getResourceAsStream("servlet/study/db4.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println(
				"用类装载器读取src目录下的servlet.study包中的db4.properties配置文件：");
		response.getWriter().println(
				MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", driver,
						url, username, password));
	}

	public void test3()
	{
		InputStream in = ClassLoaderReadFile.class.getClassLoader()
				.getResourceAsStream("01.avi");
		System.out.println(in);
	}
	
	
	/**
     * 读取01.avi,并拷贝到e:\根目录下
     * 01.avi文件太大，只能用servletContext去读取
     * @throws IOException
     */
	public void test4() throws IOException
	{
		// path=G:\Java学习视频\JavaWeb学习视频\JavaWeb\day05视频\01.avi
        // path=01.avi
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/01.avi");
		String filename = path.substring(path.lastIndexOf("\\") + 1);
		 InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/01.avi");
		 byte buffer[] = new byte[1024];
		 int len = 0;
		 OutputStream out = new FileOutputStream("e:\\" + filename);
		 while ((len = in.read(buffer)) > 0) {
		 out.write(buffer, 0, len);
		 }
		 out.close();
		 in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
