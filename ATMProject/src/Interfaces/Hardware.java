package Interfaces;

public interface Hardware {
	public String pegarNumeroDaContaCartao() throws RuntimeException;
	public void entregarDinheiro(double amount) throws RuntimeException;
	public void lerEnvelope(double amountToDeposit) throws RuntimeException;
}
