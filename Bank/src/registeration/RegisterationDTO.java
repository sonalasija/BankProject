package registeration;

public class RegisterationDTO {
	
	private String uname,password,mlevel,activatestatus;
	private long customerid;
	
	
	
	public RegisterationDTO() {
		super();
	}



	public RegisterationDTO(String uname, String password, String mlevel,
			String activatestatus, long customerid) {
		super();
		this.uname = uname;
		this.password = password;
		this.mlevel = mlevel;
		this.activatestatus = activatestatus;
		this.customerid = customerid;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMlevel() {
		return mlevel;
	}



	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}



	public String getActivatestatus() {
		return activatestatus;
	}



	public void setActivatestatus(String activatestatus) {
		this.activatestatus = activatestatus;
	}



	public long getCustomerid() {
		return customerid;
	}



	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	
	
	
	

}
