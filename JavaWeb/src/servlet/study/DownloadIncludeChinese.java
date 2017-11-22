package servlet.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadIncludeChinese
 */
@WebServlet("/DownloadIncludeChinese")
public class DownloadIncludeChinese extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadIncludeChinese()
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
		downloadFileByPrintWriter(response); // not recommend
	}

	private void downloadFileByPrintWriter(HttpServletResponse response) throws UnsupportedEncodingException, IOException
	{
		String realPath = this.getServletContext().getRealPath("/download/你好.JPG");
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		FileReader in = new FileReader(realPath);
		int len = 0;
		char[] buffer = new char[1024];
		PrintWriter out = response.getWriter();
		while((len = in.read(buffer)) > 0)
		{
			out.write(buffer, 0, len);
		}
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
