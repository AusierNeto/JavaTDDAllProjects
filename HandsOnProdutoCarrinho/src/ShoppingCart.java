import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<Product> itemsList = new ArrayList<Product>();
	private List<CartObserver> observerList = new ArrayList<CartObserver>();
	
	public void addProduct(Product p) {
		itemsList.add(p);
		for (CartObserver observer : observerList) {
			try {
				observer.receiveAddedProduct(p.getName(), p.getValue());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public int total() {
		int total = 0;
		for (Product product : itemsList) {
			total += product.getValue();
		}
		return total;
	}

	public void addObserver(CartObserver mock) {
		this.observerList.add(mock);
	}
	
}
