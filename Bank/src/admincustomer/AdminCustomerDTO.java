package admincustomer;

public class AdminCustomerDTO {
	
	private long sid,customerid;
	private long accno;
	public AdminCustomerDTO() {
		super();
	}
	public AdminCustomerDTO(long sid, long customerid, long accno) {
		super();
		this.sid = sid;
		this.customerid = customerid;
		this.accno = accno;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	
	

}
