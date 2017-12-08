package servlet.two;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloFormAndCookie
 */
@WebServlet("/HelloFormAndCookie")
public class HelloFormAndCookie extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloFormAndCookie()
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
		
		Cookie name =new Cookie("name", URLEncoder.encode(
				request.getParameter("name"), "UTF-8"));
		Cookie url = new Cookie("url", request.getParameter("url"));

		name.setMaxAge(60 * 60 * 24);
		url.setMaxAge(60 * 60 * 24);

		response.addCookie(name);
		response.addCookie(url);

		response.setContentType("text/html;charset=UTF-8");
		String n = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
		PrintWriter out = response.getWriter();
		String title = "设置 Cookie 实例";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>站点名：</b>：" + n
				+ "\n</li>" + "  <li><b>站点 URL：</b>："
				+ request.getParameter("url") + "\n</li>" + "</ul>\n"
				+ "</body></html>");
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
