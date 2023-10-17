package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;



import model.Student;
import service.StudentService;
import utility.DBUtil;

public class StudentServiceImpl implements StudentService {
	  int status=0;
	@Override
	public Student addStudent(Student student) {
		
      try
      {
    	
		Connection connection=DBUtil.getDBConnection();
		String insertStduent="insert into Students(user_name,user_password,student_name,student_address,student_phone,student_gender,student_clg_name,student_dob,student_qualifications) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=connection.prepareStatement(insertStduent);
	   ps.setString(1, student.getUserName());
	   ps.setString(2, student.getUserPassword());
	   ps.setString(3, student.getName());
	   ps.setString(4, student.getStudentAddress());
	   ps.setLong(5, student.getStduentPhone());
	   ps.setString(6, student.getGender());
	   ps.setString(7, student.getCollegeName());
	   java.sql.Date dob=java.sql.Date.valueOf(student.getStduentDob());
	   ps.setDate(8, dob);
	   ps.setString(9, student.getQualifications());
	  status= ps.executeUpdate();
	  }catch(Exception e)
      {
    	  System.out.println(e);
      }
      if(status>0)
      {
    	  return student;
      }
      else {
		return null;
	}
      
	}

	@Override
	public List<Student> viewAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student viewStudentByRoll(int rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStudent(int rollNo, Student newStudent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeStudent(int rollNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getLogin(String userName, String userPassword) {

   try
   {
	   Connection connection=DBUtil.getDBConnection();
	   String fetch_query="select * from Students where user_name=? and user_password=?";
	   PreparedStatement ps=connection.prepareStatement(fetch_query);
	   ps.setString(1, userName);
	   ps.setString(2,userPassword);
	   ResultSet rs=ps.executeQuery();
	   if(rs!=null)
	   {
		   return true;
	   }
	   
   }
		catch(Exception e)
   {
			System.out.println(e);
   }
		
		return false;
	}

}
