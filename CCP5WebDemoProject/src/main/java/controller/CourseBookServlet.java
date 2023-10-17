package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import utility.DBUtil;
//@WebServlet("/CourseBookServlet")
public class CourseBookServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)  {
		try {
		String courseId=req.getParameter("p1");
		res.setContentType("text/html");
		PrintWriter outPrintWriter=res.getWriter();
		int cid=Integer.parseInt(courseId);
		Connection con=DBUtil.getDBConnection();
		
			PreparedStatement ps =con.prepareStatement("select * from course_table where course_id=?");
			ps.setInt(1, cid);
			ResultSet rSet=ps.executeQuery();
			if(rSet.next()) {
				String cname=rSet.getString(2);
				outPrintWriter.println("<h4>Congratulations you have successfully booked" +" " + cname+ " course" +"</h4>");
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	}

}
