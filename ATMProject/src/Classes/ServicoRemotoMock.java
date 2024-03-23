package Classes;

import Interfaces.ServicoRemoto;

public class ServicoRemotoMock implements ServicoRemoto{

	public ContaCorrente contaVinculada;
	
	public ServicoRemotoMock(ContaCorrente contaCorrente) {
		this.contaVinculada = contaCorrente;
	}

	@Override
	public String recuperarConta(String newContaCorrenteNumber) {
		this.contaVinculada = new ContaCorrente(newContaCorrenteNumber);
		return "PecuperarConta executado com sucesso";
	}

	@Override
	public String persistirConta() {
		return "PersistirConta executado com sucesso";
	}

}
