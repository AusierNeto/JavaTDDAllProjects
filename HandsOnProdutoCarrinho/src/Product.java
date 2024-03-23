
public class Product {

	private String nameString;
	private int value;
	
	public Product(String name, int value) {
		this.nameString = name;
		this.value = value;
	}
	
	public String getName() {
		return this.nameString;
	}
	
	public int getValue() {
		return this.value;
	}
}
