package registeration;

import java.util.ArrayList;

import bankaccount.BankAccountDTO;

public interface RegisterationDAO {

	
	public String Register(RegisterationDTO rDTO);
	public ArrayList<Long> getAccountIdsForUname(String uname);
}
