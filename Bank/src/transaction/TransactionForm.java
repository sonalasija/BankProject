package transaction;

public class TransactionForm {
	
	private String accid,amount,description;

	public TransactionForm() {
		super();
	}

	public TransactionForm(String accid, String amount, String description) {
		super();
		this.accid = accid;
		this.amount = amount;
		this.description = description;
	}

	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}


	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
