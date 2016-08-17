package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.DatabaseManager;

public class TransactionImp implements TransactionDAO {

	private Connection con;

	public TransactionImp(Connection con) {
		super();
		this.con = con;

	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {// setter injection
		this.con = con;
	}

	@Override
	public String transaction(TransactionDTO tDTO) {
		String result = "Account created successfully";
		String sql = "insert into transaction(accid,balance,amount,tstamp,description) values(?,?,?,?,?)";
		// PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
		// changed this line
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setLong(1, tDTO.getAccid());
			ps.setDouble(2, tDTO.getBalance());
			ps.setDouble(3, tDTO.getAmount());
			ps.setTimestamp(4, tDTO.getTstamp());
			ps.setString(5, tDTO.getDescription());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "transaction coudnt be created";
		}

		return result;
	}

	public TransactionDTO getLatestTransaction(long accid) {
		TransactionDTO td = null;
		System.out.println("accid in imp clas is ..." + accid);
		String query = "select * from transaction where accid = ? order by tstamp desc LIMIT 1";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, query);
		try {
			ps.setLong(1, accid);
			ResultSet rs = ps.executeQuery();
			System.out.println("result set got is    " + rs);
			while (rs.next()) {
				System.out
						.println("......................................................");
				// System.out.println("Account id retrieved is    "+rs.getLong("accid"));
				// System.out.println("amount "+rs.getDouble("amount---in imp class"));
				// System.out.println("balace "+rs.getDouble("balance.....in impl class"));
				// TransactionDTO t=new TransactionDTO(accid, amount, balance,
				// description, tstamp);
				td = new TransactionDTO(0, rs.getDouble("amount"),
						rs.getDouble("balance"), rs.getString("description"),
						null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return td;
	}

	@Override
	public ArrayList<TransactionDTO> showRecentTransaction(long accno,
			Timestamp fDate, Timestamp tDate) {
		System.out.println("From Time stamp............"+fDate);
		System.out.println("To Time stamp............"+tDate);
		System.out.println("acc no got is---"+accno);
		ArrayList<TransactionDTO> ar = new ArrayList<TransactionDTO>();
		//String sql = "select * from transaction where accid = ? and tstamp between ? and ? ";
		String sql="select * from transaction where accid=? and tstamp>=? and tstamp<?";

		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setLong(1, accno);
			ps.setTimestamp(2, fDate);
			ps.setTimestamp(3, tDate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TransactionDTO td = new TransactionDTO(rs.getLong("accid"),
						rs.getDouble("amount"), rs.getDouble("balance"),
						rs.getString("description"), rs.getTimestamp("tstamp"));
				ar.add(td);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

}
