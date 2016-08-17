<%@page import="transaction.TransactionDTO"%>
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
	<table border="1" align="center">
	<tr><td>Date</td><td>Amount</td><td>Balance</td></tr>
	<jsp:useBean id="transaction" class="transaction.TransactionBO" />
	<%
		transaction.setContext(application);
	ArrayList<TransactionDTO> ar=transaction.showRecentTansactions(Long.parseLong(request.getParameter("accno")), request.getParameter("fromDate"), request.getParameter("toDate"));
	System.out.println("arryalist is  -- "+ar);
	for(TransactionDTO tdto:ar)
	{
	%>
	<tr> <td> <%=tdto.getTstamp() %></td>
	<td><%=tdto.getAmount() %></td>
	<td><%=tdto.getBalance() %></td>
	</tr>
	<%
		}
	%>
	</table>
</body>
</html>