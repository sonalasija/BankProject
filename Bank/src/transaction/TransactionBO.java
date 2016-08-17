package transaction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletContext;

import bankaccount.BankAccountDAO;
import bankaccount.BankAccountDTO;
import bankaccount.BankAccountImp;
import db.DatabaseManager;

public class TransactionBO {

	ServletContext context;

	// entry point

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public String transaction(TransactionForm tForm) {
		Connection con = getConnection();

		TransactionDAO tDao = new TransactionImp(con);
		TransactionDTO tDto = formTOdto(tForm);

		return tDao.transaction(tDto);
	}

	public Connection getConnection() {
		String dburl = (String) context.getAttribute("dburl");
		String dbuname = (String) context.getAttribute("dbuname");
		String dbpassword = (String) context.getAttribute("dbpassword");
		Connection con = DatabaseManager.getConnection(dburl, dbuname,
				dbpassword);
		return con;

	}

	private TransactionDTO formTOdto(TransactionForm tForm) {
		Calendar calnedar = Calendar.getInstance();
		java.util.Date now = calnedar.getTime();
		java.sql.Timestamp timestamp = new Timestamp(now.getTime());

		// query from database for this account number----to get the balance
		// from previous transaction
		// calculate the latest balance
		Connection con = getConnection();
		TransactionDAO tDao = new TransactionImp(con);
		System.out.println("accid is ----" + tForm.getAccid());

		String accid = tForm.getAccid();
		TransactionDTO tDto = tDao.getLatestTransaction(Long.parseLong(accid));
		String desc = tForm.getDescription();
		double amount = Double.parseDouble(tForm.getAmount());
		System.out.println("tdto-----" + tDto);
		double prevBalance = 0;
		if (tDto != null) {
			prevBalance = tDto.getBalance();
		}

		double presentBalance = 0;
		System.out.println("previous balance 11..........." + prevBalance);
		if (desc.equals("deposit")) {
			presentBalance = prevBalance + amount;
			System.out.println("present balance after  deposit---"
					+ presentBalance);
		} else {
			presentBalance = prevBalance - amount;
			System.out.println("present balance after  withdraw---"
					+ presentBalance);
		}
		// we can call the daoimp again to update the bankaccount table

		BankAccountDAO ba = new BankAccountImp(con);

		ba.update(Long.parseLong(accid), presentBalance);

		System.out.println("accid---" + tForm.getAccid());
		System.out.println("amoutn---" + tForm.getAmount());
		System.out.println("desc---" + tForm.getDescription());
		TransactionDTO tDTO = new TransactionDTO(Long.parseLong(tForm
				.getAccid()), Double.parseDouble(tForm.getAmount()),
				presentBalance, tForm.getDescription(), timestamp);

		return tDTO;

	}

	public ArrayList<TransactionDTO> showRecentTansactions(long accno,
			String fromDate, String toDate) {
		Timestamp fDate = null;
		Timestamp tDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date d1 = sdf.parse(fromDate);
			fDate = new Timestamp(d1.getTime());
			java.util.Date d2 = sdf.parse(toDate);
			tDate = new Timestamp(d2.getTime());
			tDate.setDate(tDate.getDate()+1);


		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = getConnection();

		TransactionDAO tDao = new TransactionImp(con);
		ArrayList<TransactionDTO> ar=tDao.showRecentTransaction(accno,fDate,tDate);

		return ar;
	}

}
