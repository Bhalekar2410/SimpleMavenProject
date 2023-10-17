<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import ="java.sql.*" %>
    <%@page import ="utility.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student View</title>
</head>
<body bgcolor="bisque">
<% String uname=(String)session.getAttribute("user-key"); %>
<font color="blue">Welcome<%= uname %>
<br><br>
<table border="1">
<thead>
<th>Course Id</th>
<th>Course Name</th>
<th>Course price</th>
<th>Book Course</th>
</thead>
<%
int courseId;
String name;
double price;
%>
<%
Connection con=DBUtil.getDBConnection();
String fetchQuery="select * from course_table";
PreparedStatement ps=con.prepareStatement(fetchQuery);
ResultSet rs=ps.executeQuery();
while(rs.next()){
	courseId=rs.getInt(1);
	name=rs.getString(2);
	price=rs.getDouble(3);

%>
<tr>
<td><%= courseId %></td>
<td><%= name%></td>
<td><%= price%></td>
<td><a href='CourseBookServlet?p1=<%=courseId %>'> BookCourse</a></td>
</tr>
<%} %>
</table>
</body>
</html>