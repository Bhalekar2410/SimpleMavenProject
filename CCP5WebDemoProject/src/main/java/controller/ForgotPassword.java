package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DBUtil;

/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    long phNumber=Long.parseLong(request.getParameter("ph"));	
    Connection con=DBUtil.getDBConnection();
    String fetchQuery="select user_password from student_registration where student_phone=?";
    PreparedStatement ps=con.prepareStatement(fetchQuery);
    ps.setLong(1, phNumber);
     ResultSet rs=ps.executeQuery();
     String password=null;
     if(rs.next())
     {
    	  password=rs.getString("user_password");
     }
     out.println("<h2>your password is"+ " "+password+ "</h2>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
    
    
    
    
    
    
		
		
		
	}

}
