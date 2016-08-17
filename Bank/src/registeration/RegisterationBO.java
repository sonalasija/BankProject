package registeration;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import admincustomer.AdminCustomerDAO;
import admincustomer.AdminCustomerDTO;
import admincustomer.AdminCustomerForm;
import admincustomer.AdminCustomerImp;
import db.DatabaseManager;

public class RegisterationBO {

ServletContext context;
	
	//entry point
	
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	public String register(RegisterationForm rForm)
	{
		Connection con=getConnection();
		
		RegisterationDAO rDao=new RegisterationImp(con);
		RegisterationDTO rDto=formTOdto(rForm);
		
		return rDao.Register(rDto);
	}
	
	
	public RegisterationDTO formTOdto(RegisterationForm rForm)
	{
		
		RegisterationDTO rDTO=new RegisterationDTO(rForm.getUname(), rForm.getPassword(), "a1", "yes", Long.parseLong(rForm.getCustomerid()));
		return rDTO;
		
		
	}
	public Connection getConnection(){
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpassword=(String)context.getAttribute("dbpassword");
		Connection con=DatabaseManager.getConnection(dburl, dbuname, dbpassword);
		return con;
		
	}
	public ArrayList<Long> getAccountIdsForUname(String uname)
	{
		Connection con=getConnection();
		RegisterationDAO rdao=new RegisterationImp(con);
		return rdao.getAccountIdsForUname(uname);
	
	}
	
}
