package Classes;


public class JammedHardwareMock{

	public RuntimeException pegarNumeroDaContaCartao() throws RuntimeException {
		return new RuntimeException("Ocorreu um erro de hardware");
	}

	public RuntimeException entregarDinheiro(double d) throws RuntimeException {
		// TODO Auto-generated method stub
		return new RuntimeException("Ocorreu um erro de hardware");
	}

	public RuntimeException lerEnvelope(double d) throws RuntimeException {
		// TODO Auto-generated method stub
		return new RuntimeException("Ocorreu um erro de hardware");
	}
	
}
