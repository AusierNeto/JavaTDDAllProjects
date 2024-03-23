package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.ContaCorrente;
import Classes.HardwareMock;
import Classes.JammedHardwareMock;

class HardwareTests {

	HardwareMock hardware;
	JammedHardwareMock jammedHardware;
	@BeforeEach
	public void initialize() {
		hardware = new HardwareMock(new ContaCorrente("123456789"));
		jammedHardware = new JammedHardwareMock();
	}
	
	@Test
	void pegarNumeroDaContaCartaoTest() {
		assertEquals("123456789", hardware.pegarNumeroDaContaCartao());
	}
	
	@Test
	void pegarNumeroDaContaCartaoExceptionTest() {
		assertEquals(new RuntimeException("Ocorreu um erro de hardware").getClass().getName(), 
				jammedHardware.pegarNumeroDaContaCartao().getClass().getName());
	}
	
	@Test
	void lerEnvelopeTest() {
		hardware.lerEnvelope(10.00);
		assertEquals(10.00, hardware.contaVinculada.getSaldo());
	}
	
	@Test
	void lerEnvelopeExceptionTest() {
		assertEquals(new RuntimeException("Ocorreu um erro de hardware").getClass().getName(), 
				jammedHardware.lerEnvelope(10.00).getClass().getName());
	}
	
	@Test
	void entregarDinheiroTest() {
		hardware.lerEnvelope(10.00);
		assertEquals(10.00, hardware.contaVinculada.getSaldo());
		hardware.entregarDinheiro(10.00);
		assertEquals(0.00, hardware.contaVinculada.getSaldo());
	}
	
	@Test
	void entregarDinheiroSemSaldoTest() { 
		assertEquals(new RuntimeException("Ocorreu um erro de hardware").getClass().getName(), 
				jammedHardware.entregarDinheiro(10.00).getClass().getName());
	}

}
