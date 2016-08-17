package admincustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseManager;

public class AdminCustomerImp implements AdminCustomerDAO{
	
	private Connection con;
	
	public AdminCustomerImp(Connection con) {//constructor injection
		super();
		this.con = con;
	}


	public AdminCustomerImp() {
		super();
	}
	
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {//setter injection
		this.con = con;
	}


	@Override
	public String addCust_Account(AdminCustomerDTO aDTO) {
		// TODO Auto-generated method stub
				String result="Account created successfully";
				String sql="insert into customer_account(customerid,accno) values(?,?)";
				//PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);  changed this line
				PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
				try {
					System.out.println("customerid...."+aDTO.getCustomerid());
					System.out.println("accnooo...."+aDTO.getAccno());
					ps.setLong(1, aDTO.getCustomerid());
					ps.setLong(2, aDTO.getAccno());
					
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result="Account coudnt be created";
				}
				
				return result;
			
	}

}
