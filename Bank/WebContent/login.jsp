<%@page import="login.LoginCheck"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookieArr = request.getCookies();
		String name = null;
		String password = null;
		if (cookieArr != null) {
			for (int i = 0; i < cookieArr.length; i++) {
				Cookie c1 = cookieArr[i];
				String cookiename = c1.getName();
				String cookievalue = c1.getValue();
				System.out.println("cccc" + cookievalue);

				if (cookiename.equals("uname")) {
					name = cookievalue;
				}
				if (cookiename.equals("password")) {
					password = cookievalue;
				}
			}
			Connection con = DatabaseManager.getConnection(application);
			LoginCheck lc = new LoginCheck(con);
			String mlevel = lc.checkLogin(name, password);
			System.out.println("mlevel found in jsp is   " + mlevel);
			if (mlevel != null) {
				//login information from cookies is valid so before redirecting we should create  HttpSessions
				HttpSession hs = request.getSession(true);
				hs.setAttribute("uname", name);
				hs.setAttribute("password", password);
				hs.setAttribute("mlevel", mlevel);
				hs.setMaxInactiveInterval(100000);
				String  fromFilter=request.getParameter("fromFilter");
				if (mlevel.equals("m1")&&fromFilter==null) {
					response.sendRedirect("member/member.jsp");
				}
				if (mlevel.equals("a1")&&fromFilter==null) {
					response.sendRedirect("admin/admin.jsp");
				}
			}

		}
	%>
	
	
	<form action="Login" method="post">
		<table border="1" align="center">

			<tr>
				<td>User Name</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td><input type="checkbox" name="remember" /></td>
				<td><input type="submit" value="Login"></td>
			</tr>

		</table>
	</form>
</body>
</html>