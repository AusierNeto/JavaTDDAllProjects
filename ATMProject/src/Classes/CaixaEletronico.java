package Classes;

import java.text.DecimalFormat;

public class CaixaEletronico {
	
	public ContaCorrente contaVinculada;

	public String sacar(double value) {
		return this.contaVinculada.reduceFromSaldo(value);
	}

	public void depositar(double valueToDeposit) {
		this.contaVinculada.addOnSaldo(valueToDeposit);
	}
	
	private String formatSaldoOutput(double saldoValue) {
		DecimalFormat df = new DecimalFormat();
	    df.setMinimumFractionDigits(2);
	    df.setMaximumFractionDigits(2);
	    df.setMinimumIntegerDigits(2);
	    df.setMaximumIntegerDigits(2);
	    return df.format(saldoValue);
	}

	public String saldo() {
		return "O saldo é R$" + formatSaldoOutput(this.contaVinculada.getSaldo());
	}
	
	private static boolean isNumeric(String str) { 
	  try {  
		Integer.parseInt(str);  
		return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }
	}

	public Object login(String string) {
		if (string.isEmpty() || !isNumeric(string)) {
			return "Não foi possível autenticar o usuário";
		}else {
			this.contaVinculada = new ContaCorrente(string);
			return "Usuário autenticado";
		}
	}

}
