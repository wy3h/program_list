package servlet.two;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookie
 */
@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadCookie()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		Cookie cookie = null;
		Cookie[] cookies = null;

		cookies = request.getCookies();

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "Delete Cookie Example";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		if (cookies != null)
		{
			out.println("<h2>Cookie 名称和值</h2>");
			for (int i = 0; i < cookies.length; i++)
			{
				cookie = cookies[i];

				out.print("名称：" + cookie.getName() + "，");
				out.print("值：" + new String(URLDecoder.decode(cookie.getValue(), "utf-8").getBytes("ISO8859-1"),"UTF-8")
						+ " <br/>");
			}
		} else
		{
			out.println("<h2 class=\"tutheader\">No Cookie founds</h2>");
		}
		out.println("</body>");
		out.println("</html>");
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
