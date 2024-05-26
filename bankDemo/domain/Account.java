package domain;

public class Account {
	private final String code;
	private String ownercode;
	private double balance;

	public Account(String code, String ownercode, double balance) {
		this.balance = balance;
		this.code = code;
		this.ownercode = ownercode;
	}

	@Override
	public String toString() {
		return String.format("Account [%s,%s,%f]", code, ownercode, balance);

	}

	public String geCode() {
		return code;
	}

	public String getownercode() {
		return ownercode;
	}

	public double getbalance() {
		return balance;
	}

	public boolean deposit(double amount) {
		if (amount <= 0)
			return false;
		balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		if (amount >= balance)
			return false;
		balance -= amount;
		return true;
	}
}
