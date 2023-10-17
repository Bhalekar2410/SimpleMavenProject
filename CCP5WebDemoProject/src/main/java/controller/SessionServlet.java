package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html");
       //I am fetching the name from html element
		String name=request.getParameter("t1");
		//creating a session object
		HttpSession session=request.getSession();
		//creating object of PrintWriter
		PrintWriter out=response.getWriter();
		out.println("<h2> The session creation time is"+ " "+new Date(session.getCreationTime())+ "</h2>");
		out.println("<h2> The session id is" + " "+session.getId());
		//setting inactive interval time
		session.setMaxInactiveInterval(50000);
		//binding the object with session object
		session.setAttribute("key1", name);
		RequestDispatcher rd=request.getRequestDispatcher("NextSessionServlet");
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
