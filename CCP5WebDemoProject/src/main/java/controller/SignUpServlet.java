package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.StudentServiceImpl;
import model.Student;


/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost
	(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//fetch all inputs from client 
		//String getParameter(String)
		String name=request.getParameter("t1");
		String address=request.getParameter("t2");
		String phone=request.getParameter("t3");
		String dob=request.getParameter("t4");
		String gender=request.getParameter("t5");
		String[] qualifications= request.getParameterValues("t6");
		String clgName=request.getParameter("t7");
		String str=" ";
		for(String qualification:qualifications)
		{
			str=str+qualification;
		}
		String userName=phone.substring(phone.length()-4);
		String password=dob.substring(dob.length()-2)+name.substring(0,2);
		
		//we need to create the object PrintWriter
		//PrintWriter getWriter() is the method of HttpServletResponse
		PrintWriter out=response.getWriter();
		
		//out.println("<h3>"+ name + " "+address+ " "+phone+ " "+dob+ " "+gender+ " "+str+" "+clgName+ " "+"</h3>");
		
		response.setContentType("text/html");
		
		StudentServiceImpl service=new StudentServiceImpl();
		Student studentObj=new Student();
		studentObj.setName(name);
		studentObj.setStudentAddress(address);
		studentObj.setUserName(userName);
		studentObj.setUserPassword(password);
		studentObj.setStduentPhone(Long.parseLong(phone));
		studentObj.setGender(gender);
		studentObj.setQualifications(str);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob1=LocalDate.parse(dob, dtf);
		studentObj.setStduentDob(dob1);
		studentObj.setCollegeName(clgName);
		System.out.println("Values setted");
	Student stud=	service.addStudent(studentObj);
	System.out.println("object passed");
	if(stud!=null)
	{
	
		
		/*
		 * HttpServletRequest interface having one more method called
		 * setAttibute(String keyName, Object value) void
		 * The above method help us to bind the specified object with the given
		 * key name with request object
		 * The attached object only available for the current request scope
		 * 
		 * 
		 * 
		 */
		
		request.setAttribute("userInfo", stud);		
		/*
		 * inside the javax.servlet package there is one interface is available 
		 * called RequestDispatcher
		 * 
		 * The above interface can be instantiated using two ways:
		 * 
		 * i. HttpServletRequest interface having one more  method called
		 *    getRequestDispatcher(String path)
		
		 * Ex:
		 *    RequestDispatcher rd=request.
		 *    getRequestDispatcher(String nextResource)
		 *    The nextResource can be HTML/JSP/Servlet
		 *    
		 *    
		 *    
		 *    
		 *  ii. The second way to create the object of RequestDispatcher is
		 *   by using the object of ServletContext interface we can call 
		 *   getRequestDispatcher(String nextResource)
		 *   
		 *   ServletContext context=getServletContext();
		 *   RequestDispatcher rd=context.
		 *   getRequestDispatcher(String nextResource)
		 *   
		 *   
		 *   RequestDispatcher having two important methods
		 *   
		 *   i. include(request, response)
		 *   
		 *    incase of include method the response of second resource or next 
		 *    resource will be included with the response of the first resource 
		 *    
		 *   
		 *   
		 *   ii.forward(request, response)
		 *   incase of include method the response of second resource or next 
		 *    resource will NOT  be included with the response of the first resource
		 * 
		 * 
		 */
		
		RequestDispatcher rd=request.getRequestDispatcher("/WelcomeServlet");
		rd.include(request, response);
		
		
		
		
	}
	else
	{
		out.println("not inserted");
	}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
