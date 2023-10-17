<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String un=request.getParameter("t1");
String pw=request.getParameter("t2");
if(un.equalsIgnoreCase("admin") && pw.equals("admin@123"))
{
	
	session.setAttribute("userInfo", un);
}%>
<jsp:forward page="nextPage.jsp" />


</body>
</html>