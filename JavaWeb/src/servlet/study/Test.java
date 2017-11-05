package servlet.study;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet(urlPatterns =
{ "/Test" }, initParams =
{
		@WebInitParam(name = "name", value = "hello"),
		@WebInitParam(name = "id", value = "100"),
		@WebInitParam(name = "describer", value = "cute", description = "someone character") })
public class Test extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config)
	{
		this.config = config;
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test()
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
		// TODO Auto-generated method stub
		String paramVal = this.config.getInitParameter("name");
		response.getWriter().print(paramVal);
		
		response.getWriter().print("<hr/>");
		// 获取所有的初始化参数
		Enumeration<String> e = config.getInitParameterNames();
		while (e.hasMoreElements())
		{
			String name = e.nextElement();
			String value = config.getInitParameter(name);
			response.getWriter().print(name + "=" + value + "<br/>");
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
		this.doGet(request, response);
	}

}
