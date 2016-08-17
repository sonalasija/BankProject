package listners;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import db.DatabaseManager;

/**
 * Application Lifecycle Listener implementation class InitinialzationListner
 *
 */
@WebListener
public class InitinialzationListner implements ServletContextListener,ServletContextAttributeListener {

    

	/**
     * Default constructor. 
     */
    public InitinialzationListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) 
    {
    	ServletContext context=arg0.getServletContext();
    	String dburl=context.getInitParameter("dburl");
		Enumeration<String> e=context.getInitParameterNames();
	//	ServletContext context=arg0.getServletContext();
		while(e.hasMoreElements()){
			String name=e.nextElement();
			String value=context.getInitParameter(name);
			System.out.println("name is "+name+" value is "+value);
			context.setAttribute(name, value);
			
		}
		String dbDriver=(String) context.getAttribute("dbdriver");
		DatabaseManager.loadDriver(dbDriver);
		
		//fetch current website counter from database//
		ListnerBO lb=new ListnerBO();
		lb.setContext(context);
		long fetcjedValue=lb.getValuefromDB();
		System.out.println("value fetsched is-----------------------"+fetcjedValue);
		//long fetcjedValue=10;
		//long    presentwebsitecount;
		//presentwebsitecount=fetcjedValue+1;
		context.setAttribute("presentwebsitecount", Long.toString(fetcjedValue));
		System.out.println("project initilizeds...");
    }

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		//control comes here when a person visits the home page
		//update the database
		//new ListnerBO().inserttoDB(presentwebsitecount);
		
		ServletContext context=arg0.getServletContext();
		String presentcount=(String)context.getAttribute("presentwebsitecount");
		String changedAttribute=arg0.getName();
		if(changedAttribute.equals("presentwebsitecount"))
		{
			ListnerBO lb=new ListnerBO();
			lb.setContext(context);
			lb.inserttoDB(Long.parseLong(presentcount));
		}
		
	}
	
}
