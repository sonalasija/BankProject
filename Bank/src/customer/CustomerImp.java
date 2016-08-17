package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseManager;

public class CustomerImp implements CustomerDAO {
	
	private Connection con;

	public CustomerImp(Connection con) {
		super();
		this.con = con;
		
	}
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {//setter injection
		this.con = con;
	}

	@Override
//sql="insert into cust (name,pin...) values(?,?.....)
	public String createCustomer(CustomerDTO cDTO) {
		// TODO Auto-generated method stub
				String result="Account created successfully";
				String sql="insert into customer(fname,lname,email,phone,street,city,zip,dob,picture) values(?,?,?,?,?,?,?,?,?)";
				//PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);  changed this line
				PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
				try {
					ps.setString(1, cDTO.getfName());
					ps.setString(2, cDTO.getlName());
					ps.setString(3, cDTO.getEmail());
					ps.setLong(4, cDTO.getPhone());
					ps.setString(5, cDTO.getStreet());
					ps.setString(6, cDTO.getCity());
					ps.setLong(7, cDTO.getZip());
					ps.setDate(8, cDTO.getDob());
					ps.setString(9, cDTO.getPicture());
					System.out.println("cdto.getpic......."+cDTO.getPicture());
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result="Account coudnt be created";
				}
				
				return result;
			}
//	@Override
//	public void addCustomer(CustomerDTO cDto) {
//		// TODO Auto-generated method stub
//		
//	}

}