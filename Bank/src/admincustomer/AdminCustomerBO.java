package admincustomer;

import java.sql.Connection;

import javax.servlet.ServletContext;

import db.DatabaseManager;

public class AdminCustomerBO {
	
	ServletContext context;
	
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	public String addCust_Account(AdminCustomerForm aForm)
	{
		Connection con=getConnection();
		
		AdminCustomerDAO aDao=new AdminCustomerImp(con);
		AdminCustomerDTO aDto=formTOdto(aForm);
		
		return aDao.addCust_Account(aDto);
	}
	
	public AdminCustomerDTO formTOdto(AdminCustomerForm aForm)
	{
		
		AdminCustomerDTO aDTO=new AdminCustomerDTO(1, Long.parseLong(aForm.getCustomerid()),Long.parseLong(aForm.getAccno()));
		return aDTO;
		
		
	}
	public Connection getConnection(){
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpassword=(String)context.getAttribute("dbpassword");
		Connection con=DatabaseManager.getConnection(dburl, dbuname, dbpassword);
		return con;
		
	}

}
