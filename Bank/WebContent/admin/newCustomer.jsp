<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="newCustomerResult.jsp" method="post"  enctype="multipart/form-data"> 
		<table border="1" align="center">

			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"></td>
			</tr>			
			
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			
			
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"></td>
			</tr>
			
			
			<tr>
				<td>Street</td>
				<td><input type="text" name="street"></td>
			</tr>
			
			<tr>
				<td>City</td>
				<td><input type="text" name="city"></td>
			</tr>
			
			<tr>
				<td>Zip</td>
				<td><input type="text" name="zip"></td>
			</tr>
			
			<tr>
				<td>DOB</td>
				<td>
				<select name="dd">
				<option value="01">01</option>
				<option value="02">01</option>
				<option value="03">01</option>
				</select>
				<select name="mm">
				<option value="01">01</option>
				<option value="02">01</option>
				<option value="03">01</option>
				</select>
				<select name="yy">
				<option value="2000">2000</option>
				<option value="2001">2001</option>
				<option value="2002">2002</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Picture</td>
				<td><input type="file" name="picture1"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Create Account"></td>
			</tr>
		</table>
	</form>
</body>
</html>