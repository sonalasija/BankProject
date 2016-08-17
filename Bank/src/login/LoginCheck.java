package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DatabaseManager;

public class LoginCheck
{
	private Connection con;

	public LoginCheck(Connection con) {
		super();
		this.con = con;
		
	}
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {//setter injection
		this.con = con;
	}
	
	//below function will chevk wether the username and password exists..if yess it will return mlevel or null
	public String checkLogin(String uname, String pass)
	{
		String mlevel=null;
		String sql= "select * from registration where uname = ? and password = ? ";
		PreparedStatement ps= DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				mlevel=rs.getString("mlevel");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlevel;
	}
}
