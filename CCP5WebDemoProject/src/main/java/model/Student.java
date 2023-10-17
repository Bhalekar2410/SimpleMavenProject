package model;

import java.time.LocalDate;

public class Student {
	
	private String name;
	private String userName;
	private String userPassword;
	private String studentAddress;
	private String gender;
	private long stduentPhone;
	private LocalDate stduentDob;
	private String qualifications;
	private String collegeName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getStduentPhone() {
		return stduentPhone;
	}
	public void setStduentPhone(long stduentPhone) {
		this.stduentPhone = stduentPhone;
	}
	public LocalDate getStduentDob() {
		return stduentDob;
	}
	public void setStduentDob(LocalDate stduentDob) {
		this.stduentDob = stduentDob;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", studentAddress=" + studentAddress + ", gender=" + gender + ", stduentPhone=" + stduentPhone
				+ ", stduentDob=" + stduentDob + ", qualifications=" + qualifications + ", collegeName=" + collegeName
				+ "]";
	}
	

}
