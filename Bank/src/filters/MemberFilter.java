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
@WebFilter("/member/*")
public class MemberFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MemberFilter() {
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
		
		HttpServletRequest hr=(HttpServletRequest)request;
		HttpSession hs=hr.getSession(false);
		boolean goToMemberPage=true;
		if(hs==null){
			goToMemberPage=false;
		}
		else{
			Object m=hs.getAttribute("mlevel");
			if(m==null){
				goToMemberPage=false;
			}
			else{
				String mlevel=(String)m;
				if(!mlevel.equals("m1")){
					goToMemberPage=false;
				}
				if(mlevel.equals("a1"))
				{
					goToMemberPage=true;
				}
			}
		}
		if(goToMemberPage){
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
