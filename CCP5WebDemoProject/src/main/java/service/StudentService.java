package service;

import java.util.List;

import model.Student;

public interface StudentService {

	public Student addStudent(Student stduent);
	public List<Student> viewAllStudent();
	public Student viewStudentByRoll(int rollNo);
	public int updateStudent(int rollNo, Student newStudent);
	public int removeStudent(int rollNo);
	public boolean getLogin(String userName, String userPassword);
	
}
