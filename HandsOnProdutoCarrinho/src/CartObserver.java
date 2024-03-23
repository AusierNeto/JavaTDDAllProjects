
public interface CartObserver {
	public void receiveAddedProduct(String productName, int productValue);
	public void verifyProductAddition(String productName, int productvalue);
}
