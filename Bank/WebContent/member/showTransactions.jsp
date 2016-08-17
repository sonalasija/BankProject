<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="registerationBObean"
		class="registeration.RegisterationBO"></jsp:useBean>
	<%
		String uname=(String)session.getAttribute("uname");
	String mlevel=(String)session.getAttribute("mlevel");
	registerationBObean.setContext(application);
	ArrayList<Long> arr=registerationBObean.getAccountIdsForUname(uname);
	%>
	<form action="recentTransaction.jsp">
		<table border="1" align="center">
			<tr>
				<td>Account Id</td>
				<%if(mlevel.equals("m1")){%>
				<td><select name="accno">
						<%
							for( Long l:arr){ 
								long ll=l.longValue();
						%>
						<option value="<%=ll%>"><%=ll%></option>
						<%
							}
						%>
				</select></td>
				<%} else{%>
				<td><input type="text" name="accno"></td>
				<% }%>
			</tr>
			<tr>
				<td>From Date(dd/mm/yyyy)</td>
				<td><input type="text" name="fromDate"></td>
			</tr>
			<tr>
				<td>To Date(dd/mm/yyyy)</td>
				<td><input type="text" name="toDate"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>