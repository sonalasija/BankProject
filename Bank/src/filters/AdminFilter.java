package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MemberFilter
 */
//@WebFilter("/member/*")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		System.out.println("admin filter got executed.........................");
		HttpServletRequest hr=(HttpServletRequest)request;
		HttpSession hs=hr.getSession(false);
		boolean goToAdminPage=true;
		if(hs==null){
			goToAdminPage=false;
		}
		else{
			Object m=hs.getAttribute("mlevel");
			if(m==null){
				goToAdminPage=false;
			}
			else{
				String mlevel=(String)m;
				if(!mlevel.equals("a1")){
					goToAdminPage=false;
				}
			}
		}
		if(goToAdminPage){
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		else{
			HttpServletResponse hsr=(HttpServletResponse)response;
			hsr.sendRedirect("../login.jsp?fromFilter=yes");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
