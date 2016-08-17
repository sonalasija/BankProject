package listners;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import db.DatabaseManager;

public class ListnerBO {
	
ServletContext context;
	
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	public Connection getConnection(){
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpassword=(String)context.getAttribute("dbpassword");
		Connection con=DatabaseManager.getConnection(dburl, dbuname, dbpassword);
		return con;
		
	}
	
	public long getValuefromDB(){
		long counter = 0;
		Connection con=getConnection();
		String sql="select * from websitecounter";
		PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
		try {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				counter=rs.getInt("count");
				System.out.println("c..."+counter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counter;
	}
	
	public String inserttoDB(long count){
		Connection con=getConnection();
		String result="inserted successfully";
		String sql="update websitecounter set count = ?";
		//PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);  changed this line
		PreparedStatement ps=DatabaseManager.getPreparedStatement(con, sql);
		try {
			
			ps.setLong(1,count);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="not inserted";
		}
		
		return result;
	
}
	

}
