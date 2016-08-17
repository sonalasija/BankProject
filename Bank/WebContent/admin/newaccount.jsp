<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="newAccountResult.jsp" method="post">  
		<table border="1" align="center">

			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>Account Number</td>
				<td><input type="text" name="accno"></td> 
			</tr>
			<tr>
				<td>Account Type</td>
				<td>
				<select name="acctype">
				<option value="Saving Account">Saving Account</option>
				<option value="Checking Account">Checking Account</option>
				</select>
							
				</td>
			</tr>
			<tr>
				<td>Account Details</td>
				<td><textarea name="accdetails"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create Account"></td>
			</tr>
		</table>
	</form>
</body>
</html>