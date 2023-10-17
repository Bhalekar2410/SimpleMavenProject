package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentServiceImpl;
import model.Student;

/**
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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

PrintWriter out=response.getWriter();
		int roll=Integer.parseInt(request.getParameter("t1"));
		long ph=Long.parseLong(request.getParameter("t3"));
		String address=request.getParameter("t4");
		StudentServiceImpl service=new StudentServiceImpl();
		Student s=new Student();
		s.setStduentPhone(ph);
		s.setStudentAddress(address);
	int status=	service.updateStudent(roll, s);
		if(status>0)
		{
			out.println("updated");
		}
		
		
		
		
		
		
	}

}
