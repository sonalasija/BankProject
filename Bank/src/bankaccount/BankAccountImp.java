package bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DatabaseManager;

public class BankAccountImp implements BankAccountDAO
{

	//dependency injection-is a popular design pattern that helps to inject dependency to a class
	private Connection con;
	
	
	public BankAccountImp(Connection con) {//constructor injection
		super();
		this.con = con;
	}


	public BankAccountImp() {
		super();
	}


	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {//setter injection
		this.con = con;
	}


	@Override
	public String createAccount(BankAccountDTO bDTO) 
	{
		// TODO Auto-generated method stub
		String result="Account created successfully";
		String sql="insert into bankaccount values(?,?,?,?,?,?)";
		//PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);  changed this line
		PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setLong(1, bDTO.getAccno());
			ps.setString(2, bDTO.getName());
			ps.setString(3, bDTO.getAcctype());
			ps.setString(4, bDTO.getAccdetails());
			ps.setDouble(5, bDTO.getBalance());
			ps.setDate(6, bDTO.getCreationDate());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Account coudnt be created";
		}
		
		return result;
	}


	@Override
	public ArrayList<BankAccountDTO> getAllAccounts() {
		
		String query="Select * from bankaccount ";
		PreparedStatement ps=DatabaseManager.getPreparedStatement(con, query);
		ArrayList<BankAccountDTO> ar=new ArrayList<BankAccountDTO>();
		try {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BankAccountDTO bDto=new BankAccountDTO(rs.getLong("accno"), rs.getString("name"), rs.getString("acctype"), rs.getString("accdetails"), rs.getDouble("balance"), rs.getDate("creationDate"));
				System.out.println("Bankaccount    ....."+bDto);
				ar.add(bDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ArrayList in the the BO class is "+ar);
		return ar;
	}


	@Override
	public void update(long accid, double balance) {
		String sql="update bankaccount set balance = ? where accno = ? ";
		PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setDouble(1, balance);
			ps.setLong(2, accid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
