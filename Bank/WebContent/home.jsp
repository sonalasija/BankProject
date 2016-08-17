<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to Banks Home Page
<% String count=(String)application.getAttribute("presentwebsitecount");
System.out.println("count i njsp"+count);
long c=Long.parseLong(count);
long presentvalue=c+1;
application.setAttribute("presentwebsitecount", Long.toString(presentvalue));
%>
You are visitor number  <%=presentvalue %>
</body>
</html>