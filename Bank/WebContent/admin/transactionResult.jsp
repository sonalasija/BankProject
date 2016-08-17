<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="transactionformbean" class="transaction.TransactionForm"></jsp:useBean> 
<jsp:setProperty property="*" name="transactionformbean"/>
<jsp:useBean id="transactionBObean" class="transaction.TransactionBO"></jsp:useBean>
<%
transactionBObean.setContext(application);
String result=transactionBObean.transaction(transactionformbean);
%>
<%=result %>
</body>
</html>