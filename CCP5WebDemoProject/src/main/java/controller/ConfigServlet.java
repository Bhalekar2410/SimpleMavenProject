package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigServlet
 */
@WebServlet("/ConfigServlet")
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//First We will fecth input from html element
		String n=request.getParameter("t1");
		String p=request.getParameter("t2");
		
		//Now fetching user name and password from web.xml file
		//instantiating object of ServletConfig
		ServletConfig config=getServletConfig();
		//String getInitParameter(String parameterName)
		String name= config.getInitParameter("admin-name");
		String pw=config.getInitParameter("admin-password");
		
		PrintWriter out=response.getWriter();
		//String getServletName()
	String servletName=	config.getServletName();
	out.println(servletName);
		//ServeltContext getServletContext
		response.setContentType("text/html");
		if(name.equalsIgnoreCase(n) && pw.equals(p))
		{
			out.println("<h4><font color='blue'>Welcome"+" "+name+"</font></h4>");
		}
		else
		{
			out.println("<h4><font color='red'>sorrry admin  </font></h4>");
		}
		  
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
