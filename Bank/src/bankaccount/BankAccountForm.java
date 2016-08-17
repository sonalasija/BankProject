package bankaccount;
//java beans-its is a simple java class with an empty constructor and public getter and setters method
//of all private instance variables

//form class bean represent ui class.this class will contain instance variable based on the form elements in the ui
public class BankAccountForm 
{
	private String accno,name,acctype,accdetails;

	public BankAccountForm() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
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
	
}
