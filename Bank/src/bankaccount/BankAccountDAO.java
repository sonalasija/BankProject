package bankaccount;

import java.util.ArrayList;

//
public interface BankAccountDAO 
{
	public String createAccount(BankAccountDTO bDTO);

	public ArrayList<BankAccountDTO> getAllAccounts();

	public void update(long accid, double balance);
}
