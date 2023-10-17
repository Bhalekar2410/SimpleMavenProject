package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//getting input from HTML form
 String un=request.getParameter("t1");
 String pw=request.getParameter("t2");
 //creating object of StudentServiceImpl class
 StudentServiceImpl service=new StudentServiceImpl();
 PrintWriter out=response.getWriter();
		//calling getLogin() method
 
 boolean  status=service.getLogin(un, pw);
		if(status)
		{
			/*
		//creating cookie	
		Cookie	ck1=new Cookie("user-name", un);
		Cookie ck2=new Cookie("user-password", pw);
		//setting age of cookie
		ck1.setMaxAge(5000);
		ck2.setMaxAge(5000);
		//seting comment with the cookie
		ck1.setComment("Cookie holding user name");
		ck2.setComment("cookie holding user password");
		//adding cookie with response header
		response.addCookie(ck1);
		response.addCookie(ck2);
		out.println("cookies are created");
		
		
			RequestDispatcher rd=request.getRequestDispatcher("/NextServlet");
			rd.forward(request, response);*/
		HttpSession session=request.getSession();
		session.setAttribute("user-key",un);
		session.setAttribute("user-password",pw);
		RequestDispatcher rDispatcher=request.getRequestDispatcher("studentView.jsp");
		rDispatcher.forward(request, response);
			
		}
		else
		{
			response.sendRedirect("errorPage.html");
		}
		
	}

}
