package transaction;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface TransactionDAO {
	
	public String transaction(TransactionDTO tDTO);
	public TransactionDTO getLatestTransaction(long accid);
	public ArrayList<TransactionDTO> showRecentTransaction(long accno,
			Timestamp fDate, Timestamp tDate);

}
