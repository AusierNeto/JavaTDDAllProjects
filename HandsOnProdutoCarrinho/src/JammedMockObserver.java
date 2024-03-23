
public class JammedMockObserver implements CartObserver{
	
	@Override
	public void receiveAddedProduct(String productName, int productValue) {
		throw new RuntimeException("Simulated Exception for the mock");
	}

	@Override
	public void verifyProductAddition(String productName, int productvalue) {
		// TODO Auto-generated method stub
		
	}
}
