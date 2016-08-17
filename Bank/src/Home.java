import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import db.DatabaseManager;

//javax.servlet package contains clases and interfaces that will help to work with servlets
//interfaces in the package are  Servlet,ServletRequest,ServletResponse,ServletConfig,ServletContext

//to create a servlet we need to implement the servlet interface

//Life cyccle of a servlet-
//after tomcat gets hold of recent servlet object it calls the init method only once thruout the lifecycle of servlet.
//(inilisation code should go inside init)
//in each consequnt request the service method will be called by tomcat(whatever we needs to be done by servlet is put in service method)

//destroy method will be called garbage collection of servelt object(whenever new version of serveet is destroyed)
public class Home implements Servlet
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("inside destroy"); 
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Inside init");
		//read the entry from web.xml once and stores them in servletcontext object
//		String dburl=arg0.getInitParameter("dburl");
//		Enumeration<String> e=arg0.getInitParameterNames();
//		ServletContext context=arg0.getServletContext();
//		while(e.hasMoreElements()){
//			String name=e.nextElement();
//			String value=arg0.getInitParameter(name);
//			System.out.println("name is "+name+" value is "+value);
//			context.setAttribute(name, value);
//			
//		}
//		String dbDriver=(String) context.getAttribute("dbdriver");
//		DatabaseManager.loadDriver(dbDriver);
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside serivce");
		RequestDispatcher rd=arg0.getRequestDispatcher("home.jsp");
		rd.include(arg0, arg1);
		
		
	}
	
}