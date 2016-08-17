<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- html style comment-->
<%--jsp style commnet --%>

<!-- there are some implicit objects in jsp they are automatically avaliable for jsp page author
example - request resembles httpservletrequest type of object
response resembles httpservletresponse
config- servletconfig tyoe of object
application- servletcontext type of object
out- jspwriter typeobject
 -->
 
 <%String dburl=(String)application.getAttribute("dburl");
		out.println("dburl is "+dburl);
		%>

</body>
</html>