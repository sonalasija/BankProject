<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<jsp:useBean id="admincustomerbobean" class="admincustomer.AdminCustomerBO"></jsp:useBean>
<jsp:useBean id="admincustomerformbobean" class="admincustomer.AdminCustomerForm"></jsp:useBean>
<jsp:setProperty property="*" name="admincustomerformbobean"/>

<%
admincustomerbobean.setContext(application);
String result=admincustomerbobean.addCust_Account(admincustomerformbobean);
%>

<%=result %>
</body>
</html>