package bankaccount;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import db.DatabaseManager;

//from the jsp this is the entry point
public class BankAccountBO {
	ServletContext context;

	// entry point

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public String createAccount(BankAccountForm bForm) {
		Connection con = getConnection();

		BankAccountDAO bDao = new BankAccountImp(con);
		BankAccountDTO bDto = formTOdto(bForm);

		return bDao.createAccount(bDto);
	}

	// dto represent database table
	public BankAccountDTO formTOdto(BankAccountForm bForm) {

		BankAccountDTO bDTO = new BankAccountDTO(Long.parseLong(bForm
				.getAccno()), bForm.getName(), bForm.getAcctype(),
				bForm.getAccdetails(), 0, getSystemDate());
		return bDTO;

	}

	public Connection getConnection() {
		String dburl = (String) context.getAttribute("dburl");
		String dbuname = (String) context.getAttribute("dbuname");
		String dbpassword = (String) context.getAttribute("dbpassword");
		Connection con = DatabaseManager.getConnection(dburl, dbuname,
				dbpassword);
		return con;

	}

	public Date getSystemDate() {
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		return d2;
	}

	public ArrayList<BankAccountDTO> getallAccounts() {
		Connection con = getConnection();

		BankAccountDAO bDao = new BankAccountImp(con);
		ArrayList<BankAccountDTO> ar=bDao.getAllAccounts();

		return null;

	}
	public void update(long accid,double balance)
	{
		Connection con = getConnection();

		BankAccountDAO bDao = new BankAccountImp(con);
		bDao.update(accid,balance);
	}
}
