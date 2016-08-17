<%@page import="java.util.Iterator"%>
<%@page import="bankaccount.BankAccountDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="showAccountsdetails.jsp">
<table border="1" align="center">
<tr><td>Accounts</td>
<td><select name="accountNumber">
<jsp:useBean id="bankaccountBObean" class="bankaccount.BankAccountBO"></jsp:useBean>

<% bankaccountBObean.setContext(application);
ArrayList<BankAccountDTO> ar=	bankaccountBObean.getallAccounts();
System.out.println("ArrayList got is "+ar);
Iterator ir=ar.iterator();
while(ir.hasNext()){
	BankAccountDTO bdto=(BankAccountDTO)ir.next();

%>
<option value="<%=bdto.getAccno() %>"> <%= bdto.getAccno()%></option>
<%} %>
</select></td>

</tr>
<tr><td></td><td><input type="submit"></td></tr>
</table>
</form>
</body>
</html>