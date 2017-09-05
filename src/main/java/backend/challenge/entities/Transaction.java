package backend.challenge.entities;

public class Transaction implements Comparable<Transaction> {
	private double amount;
	private long timestamp;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int compareTo(Transaction transaction) {
		int result;

		if (this.timestamp < transaction.getTimestamp()) {
			result =  -1;
		} else if (this.timestamp == transaction.getTimestamp()) {
			result =  0;
		} else {
			result =  1;
		}

		return result;
	}
}
