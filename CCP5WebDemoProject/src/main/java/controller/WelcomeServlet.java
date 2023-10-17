package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		/*
		 * HttpServletRequest interface having one more method called
		 * Object getAttribute(String keyName)
		 * 
		 * 
		 */
Student studentObject=	(Student)	request.getAttribute("userInfo");
		PrintWriter out=response.getWriter();
		out.println("<h3><font color='blue'> Welcomer"+ "Mr."+ " "+studentObject.getName()+"</font></h3>");
		out.println("<h3> <font color='green'>your user name is"+ " "+studentObject.getUserName()+"</font></h3>");
		out.println("<h3> your  password is"+ " "+studentObject.getUserPassword()+"</font></h3>");
		out.println("<h3><font color='green'> you can login to our system by clicking the below link </h3>");
		out.println("<font color='red'><a href='login.html'>click here to login...</font></h3>");
		response.setContentType("text/html");
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
