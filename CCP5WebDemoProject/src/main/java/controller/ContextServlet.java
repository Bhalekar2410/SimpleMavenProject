package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextServlet
 */
@WebServlet("/ContextServlet")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		//I will create object of ServletContext
		//There are three ways are there to create the obejct
		//of servlet context
		ServletContext context=getServletContext();
		
	/*	ServletContext ctx=request.getServletContext();
		
		ServletConfig config=getServletConfig();
		ServletContext ctx1=config.getServletContext();*/
		
		//fetch the parameters from context-param of web.xml file
		 String userName=context.getInitParameter("user-name");
		 String userPassword=context.getInitParameter("user-password");
		 
		 PrintWriter out=response.getWriter();
		 
		 out.println(userName + " "+userPassword);
		/*
		 * void setAttribute(String key, Object obj)
		 * If I will invoke the setAttribute() method of servlet context then
		 * we can able to bind the object with associated key name
		 * 
		 * The scope of that object will be available for entire application
		 *  
		 *  
		 *  
		 */
		 List<String> al=new ArrayList();
		 al.add(userName);
		 al.add(userPassword);
		 context.setAttribute("userInfo",al);
		String path= context.getContextPath();
		String serverInfo= context.getServerInfo();
		 
		 out.println(path+ " "+serverInfo);
		// response.sendRedirect("FetchContextData");
		 RequestDispatcher rd=request.getRequestDispatcher("FetchContextData");
		 rd.include(request, response);
		 
		 
		 
		  
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
