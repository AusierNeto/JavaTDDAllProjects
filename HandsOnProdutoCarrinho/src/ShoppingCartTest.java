import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

	@Test
	public void totalTest() {
		ShoppingCart cart = new ShoppingCart();
		cart.addProduct(new Product("Tenis", 100));
		cart.addProduct(new Product("Camisa", 50));
		cart.addProduct(new Product("aposdfij", 70));
		assertEquals(220, cart.total());
	}
	
	@Test
	public void ObserverAddTest() {
		ShoppingCart cart = new ShoppingCart();
		MockCartObserver mock = new MockCartObserver();
		cart.addObserver(mock);
		cart.addProduct(new Product("Camisa", 50));
		mock.verifyProductAddition("Camisa", 50);
	}
	
	@Test
	public void AddTwoObserverTest() {
		ShoppingCart cart = new ShoppingCart();
		MockCartObserver mock1 = new MockCartObserver();
		MockCartObserver mock2 = new MockCartObserver();
		cart.addObserver(mock1);
		cart.addObserver(mock2);
		cart.addProduct(new Product("Camisa", 50));
		mock1.verifyProductAddition("Camisa", 50);
		mock2.verifyProductAddition("Camisa", 50);
	}
	
	@Test
	public void stillNotifyWithObserverInError() {
		ShoppingCart cart = new ShoppingCart();
		MockCartObserver mock1 = new MockCartObserver();
		MockCartObserver mock2 = new MockCartObserver();
		CartObserver mock3 = new JammedMockObserver();
		cart.addObserver(mock1);
		cart.addObserver(mock2);
		cart.addObserver(mock3);
		cart.addProduct(new Product("Camisa", 50));
		mock1.verifyProductAddition("Camisa", 50);
		mock2.verifyProductAddition("Camisa", 50);
	}

}
