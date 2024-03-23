package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.ContaCorrente;
import Classes.ServicoRemotoMock;

class ServicoRemotoTests {

	@Test
	void persistirContaTest() {
		ServicoRemotoMock sr = new ServicoRemotoMock(new ContaCorrente("12345"));
		assertEquals("PersistirConta executado com sucesso", sr.persistirConta());
	}
	
	@Test 
	void recuperarContaTest() {
		ServicoRemotoMock sr = new ServicoRemotoMock(new ContaCorrente("12345"));
		sr.recuperarConta("123456789");
		assertEquals("123456789", sr.contaVinculada.getAccountNumber());
	}

}
