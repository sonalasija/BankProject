package registeration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DatabaseManager;

public class RegisterationImp implements RegisterationDAO {

	private Connection con;
	
	public RegisterationImp(Connection con) {//constructor injection
		super();
		this.con = con;
	}


	public RegisterationImp() {
		super();
	}
	
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {//setter injection
		this.con = con;
	}

	
	
	
	@Override
	public String Register(RegisterationDTO rDTO) {
		String result="Registered successfully";
		String sql="insert into registration values (?,?,?,?,?)";
		//PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);  changed this line
		PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
		try {
		
			ps.setString(1, rDTO.getUname());
			ps.setString(2, rDTO.getPassword());
			ps.setLong(3, rDTO.getCustomerid());
			ps.setString(4, rDTO.getMlevel());
			ps.setString(5, rDTO.getActivatestatus());
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="error in registrartion";
		}
		
		return result;
	}


	@Override
	public ArrayList<Long> getAccountIdsForUname(String uname) 
	{
		String sql="select * from registration r1, customer_account ca1 where r1.uname=? and  r1.customerid = ca1.customerid";
		PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
		ArrayList<Long> arr=new ArrayList<Long>();
		try 
		{
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Long l=new Long(rs.getLong("accno"));
				arr.add(l);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

}
