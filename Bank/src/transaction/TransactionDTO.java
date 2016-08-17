package transaction;

import java.sql.Date;
import java.sql.Timestamp;

public class TransactionDTO {
	
	private long accid;
	private double amount,balance;
	private String description;
	private java.sql.Timestamp tstamp;
	public TransactionDTO(long accid, double amount, double balance,
			String description, Timestamp tstamp) {
		super();
		this.accid = accid;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		this.tstamp = tstamp;
	}
	public long getAccid() {
		return accid;
	}
	public void setAccid(long accid) {
		this.accid = accid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public java.sql.Timestamp getTstamp() {
		return tstamp;
	}
	public void setTstamp(java.sql.Timestamp tstamp) {
		this.tstamp = tstamp;
	}
	

	
	
}
