<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="transactionResult.jsp" method="post"> 
		<table border="1" align="center">

			
			
			<tr>
				<td>Account Id</td>
				<td><input type="text" name="accid"></td>
			</tr>
			
			<tr>
				<td>Amount</td>
					<td><input type="text" name="amount"></td>
			</tr>
			
			<tr>
				<td>Description</td>
					<td><select name="description"><option value="withdraw">withdraw</option><option value="deposit">deposit</option></select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>