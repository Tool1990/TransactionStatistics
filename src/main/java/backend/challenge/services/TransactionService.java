package backend.challenge.services;

import backend.challenge.dto.Statistic;
import backend.challenge.entities.Transaction;
import backend.challenge.util.TransactionList;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TransactionService {
	public Statistic getStatistic(List<Transaction> transactions) {
		double sum = 0;
		double max = -1;
		double min = -1;

		for (Transaction transaction : transactions) {
			sum += transaction.getAmount();

			if (max == -1 || transaction.getAmount() > max) {
				max = transaction.getAmount();
			}

			if (min == -1 || transaction.getAmount() < min) {
				min = transaction.getAmount();
			}
		}

		long count = transactions.size();
		double avg = sum / count;

		return new Statistic(sum, avg, max, min, count);
	}

	public List<Transaction> getLatestMinuteTransactions(List<Transaction> transactions) {
		TransactionList latestMinuteTransactions = new TransactionList();

		for (Transaction transaction : transactions) {
			if (!isLatestMinute(transaction)) {
				break;
			}

			latestMinuteTransactions.add(transaction);
		}

		return latestMinuteTransactions;
	}

	public boolean isLatestMinute(Transaction transaction) {
		return transaction.getTimestamp() > System.currentTimeMillis() - 60 * 1000;
	}
}
