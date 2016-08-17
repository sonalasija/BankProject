package bankaccount;

import java.sql.Date;

//dto- data trasfer object-an object of this class represent one row of db table
//thsi class will have instance variables based on column in db tables
public class BankAccountDTO 
{
	private long accno;
	private String name,acctype,accdetails;
	private double balance;
	private java.sql.Date creationDate;
	
	public BankAccountDTO(long accno, String name, String acctype,
			String accdetails, double balance, Date creationDate) {
		super();
		this.accno = accno;
		this.name = name;
		this.acctype = acctype;
		this.accdetails = accdetails;
		this.balance = balance;
		this.creationDate = creationDate;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public String getAccdetails() {
		return accdetails;
	}
	public void setAccdetails(String accdetails) {
		this.accdetails = accdetails;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public java.sql.Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(java.sql.Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
