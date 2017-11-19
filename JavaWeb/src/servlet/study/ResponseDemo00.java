package servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo00
 */
@WebServlet("/ResponseDemo00")
public class ResponseDemo00 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseDemo00()
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
		outputChineseByPrintWriter(response);
	}

	private void outputChineseByPrintWriter(HttpServletResponse response) throws IOException
	{
		String data = "中国";
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>");
		out.write(data);
		
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
