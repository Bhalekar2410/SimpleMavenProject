<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int a;
int b; 
String choice;
int result=0;
%>
<% 
String number1=request.getParameter("n1");
String number2=request.getParameter("n2");
a=Integer.parseInt(number1);
b=Integer.parseInt(number2);
String symbol=request.getParameter("ch");
if(symbol.equals("+"))
{
	result=a+b;
}else if(symbol.equals("-"))
{
	result=a-b;
}else if(symbol.equals("*"))
{
	result=a*b;
}else if(symbol.equals("/"))
{
	result=a/b;
}



%>
 <h1><font color="orange">result is:<%=result %></font></h1>

</body>
</html>