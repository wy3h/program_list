package servlet.study;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo02
 */
@WebServlet("/ResponseDemo02")
public class ResponseDemo02 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseDemo02()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws  IOException
	{
		outputOneByOutputStream(response);
	}

	private void outputOneByOutputStream(HttpServletResponse response) throws IOException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write("使用OutputStream流输出数字1：".getBytes("UTF-8"));
		outputStream.write(("" + 1).getBytes());
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
