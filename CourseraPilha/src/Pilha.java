import java.util.function.BooleanSupplier;

public class Pilha {
	
	private Object[] elementArray;
	private int size = 0;

	public Pilha(int maxSize) {
		this.elementArray = new Object[maxSize];
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public Integer getSize() {
		return size;
	}

	public void push(Object elementToPush) {
		if (this.size == this.elementArray.length) {
			throw new FullStackException("Cannot push any more element. Stack is full");
		}
		this.elementArray[size] = elementToPush;
		this.size++;
	}

	public Object top() {
		return this.elementArray[size - 1];
	}

	public Object pop() {
		if (isEmpty()) {
			throw new EmptyStackException("The stack is empty, so cannot pop element");
		}
		Object poppedElement = this.top();
		this.size--;
		return poppedElement;
	}

}
