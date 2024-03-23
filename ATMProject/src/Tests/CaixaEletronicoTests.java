package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Classes.CaixaEletronico;

class CaixaEletronicoTests {
	
	private CaixaEletronico caixaEletronico;

	@BeforeEach
	public void initialize() {
		caixaEletronico = new CaixaEletronico();
	}
	
	@Test
	void checkUnloggedAccount() {
		assertEquals(null, caixaEletronico.contaVinculada);
		caixaEletronico.login("1234567890");
		assertEquals("1234567890", caixaEletronico.contaVinculada.getAccountNumber());
	}
	
	@Test
	void checkEmptyAccount() {
		caixaEletronico.login("1234");
		assertEquals("O saldo é R$00,00", caixaEletronico.saldo());
	}
	
	@Test
	void depositMoneyOnAccount() {
		caixaEletronico.login("1234");
		assertEquals("O saldo é R$00,00", caixaEletronico.saldo());
		caixaEletronico.depositar(10.00);
		assertEquals("O saldo é R$10,00", caixaEletronico.saldo());
	}
	
	@Test
	void sacarFromAccount() {
		caixaEletronico.login("1234");
		assertEquals("Saldo insuficiente", caixaEletronico.sacar(1));
		caixaEletronico.depositar(10.00);
		assertEquals("Retire seu dinheiro", caixaEletronico.sacar(1));
		assertEquals("Saldo insuficiente", caixaEletronico.sacar(10));
	}
	
	@Test
	void logIntoAccount() {
		assertEquals("Usuário autenticado", caixaEletronico.login("7890"));
		assertEquals("Não foi possível autenticar o usuário", caixaEletronico.login("Invalid"));
		assertEquals("Não foi possível autenticar o usuário", caixaEletronico.login(""));
		assertEquals("7890", caixaEletronico.contaVinculada.getAccountNumber());
	}

}
