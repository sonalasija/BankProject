package login;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DatabaseManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet
{
	ServletContext context=null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		context=request.getServletContext();
		Connection con=getConnection();
		LoginCheck lc=new LoginCheck(con);
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String mlevel=lc.checkLogin(uname, password);
		if(mlevel!=null)//logged in
		{
			//we will create session objects
			HttpSession hs=request.getSession(true);
			hs.setAttribute("uname", uname);
			hs.setAttribute("password", password);
			hs.setAttribute("mlevel", mlevel);
			hs.setMaxInactiveInterval(100000);
			
			System.out.println("mlevel !=null..............");
			String remember=request.getParameter("remember");
			if(remember!=null)
			{
				System.out.println("remember !=null..............");
				//create cookies
				Cookie c1=new Cookie("uname",uname);
				Cookie c2=new Cookie("password",password);
				//persistance cookies
				c1.setMaxAge(10000);
				c2.setMaxAge(10000);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			//we should redirect to member or admin page
			if(mlevel.equals("m1"))
			{
				response.sendRedirect("member/member.jsp");
			}
			if(mlevel.equals("a1"))
			{
				response.sendRedirect("admin/admin.jsp");
			}
			
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		
	}
	public Connection getConnection()
	{
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpassword=(String)context.getAttribute("dbpassword");
		Connection con=DatabaseManager.getConnection(dburl, dbuname, dbpassword);
		return con;
		
	}

}
