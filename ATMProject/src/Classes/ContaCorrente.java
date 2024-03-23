package Classes;

public class ContaCorrente {
	
	private String accountNumber = " ";
	private double saldo = 0.0;
	
	public ContaCorrente(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void addOnSaldo(double valueToAdd) {
		this.saldo += valueToAdd;
	}

	public String reduceFromSaldo(double value) {
		if (value > this.saldo) {
			return "Saldo insuficiente";
		}
		this.saldo -= value;
		return "Retire seu dinheiro";
	}
	
}
