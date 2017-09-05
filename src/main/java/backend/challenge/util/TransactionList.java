package backend.challenge.util;

import backend.challenge.entities.Transaction;

import java.util.LinkedList;
import java.util.ListIterator;

public class TransactionList extends LinkedList<Transaction> {
	public boolean add(Transaction transaction) {
		ListIterator<Transaction> iterator = listIterator();

		while (true) {
			if (!iterator.hasNext()) {
				iterator.add(transaction);
				return true;
			}

			if (iterator.next().compareTo(transaction) < 0) {
				iterator.previous();
				iterator.add(transaction);
				return true;
			}
		}
	}
}
