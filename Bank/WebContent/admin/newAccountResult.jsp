<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- We are using jsp action element to associate the jsp with the java beans -->
<jsp:useBean id="bankformbean" class="bankaccount.BankAccountForm"></jsp:useBean>
<!-- the above tag will create an object of bankaccountform and refered as bankformbean -->

<jsp:setProperty property="*" name="bankformbean"/>
<!-- populate all the setter methods with the request parameters coming from the last jsp page -->

<jsp:useBean id="bankbobean" class="bankaccount.BankAccountBO"></jsp:useBean>

<%
bankbobean.setContext(application);
String result=bankbobean.createAccount(bankformbean);
%>

<%=result %>
</body>
</html>