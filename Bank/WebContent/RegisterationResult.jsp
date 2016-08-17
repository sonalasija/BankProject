<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="registerationformbean" class="registeration.RegisterationForm"></jsp:useBean> 
<jsp:setProperty property="*" name="registerationformbean"/>
<jsp:useBean id="registerationBObean" class="registeration.RegisterationBO"></jsp:useBean>
<%
registerationBObean.setContext(application);
String result=registerationBObean.register(registerationformbean);
%>
<%=result %>
</body>
</html>