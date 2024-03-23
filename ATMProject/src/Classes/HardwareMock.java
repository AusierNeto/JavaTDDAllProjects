package Classes;

import Interfaces.Hardware;

public class HardwareMock implements Hardware{

	public ContaCorrente contaVinculada;
	
	public HardwareMock(ContaCorrente contaCorrente) {
		this.contaVinculada = contaCorrente;
	}

	@Override
	public String pegarNumeroDaContaCartao() throws RuntimeException {
		return this.contaVinculada.getAccountNumber();
	}

	@Override
	public void lerEnvelope(double amountToDeposit) throws RuntimeException {
		this.contaVinculada.addOnSaldo(amountToDeposit);
	}

	@Override
	public void entregarDinheiro(double d) {
		// TODO Auto-generated method stub
		this.contaVinculada.reduceFromSaldo(d);
	}

}
