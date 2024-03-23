import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockCartObserver implements CartObserver{

	private String receivedProductName;
	private int receivedProductValue;
	private boolean isJammed = false;
	
	@Override
	public void receiveAddedProduct(String productName, int productValue) {
		if (isJammed) {
			throw new RuntimeException("Simulated Exception for the mock");
		}
		this.receivedProductName = productName;
		this.receivedProductValue = productValue;
	}
	
	@Override
	public void verifyProductAddition(String productName, int productvalue) {
		assertEquals(this.receivedProductName, productName);
		assertEquals(this.receivedProductValue, productvalue);
	}

	public void jam() {
		this.isJammed  = true;
	}
	
}
