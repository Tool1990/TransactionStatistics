package backend.challenge;

import backend.challenge.entities.Transaction;
import backend.challenge.util.TransactionList;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ApplicationContext {
	private List<Transaction> transactions = new TransactionList();

	public List<Transaction> getTransactions() {
		return transactions;
	}
}
