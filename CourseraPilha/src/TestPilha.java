import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPilha {
	
	private Pilha p;
	
	@BeforeEach
	public void initializePilha() {
		p = new Pilha(10);
	}

	@Test
	public void emptyPilha() {
		assertTrue(p.isEmpty());
		assertEquals(0, p.getSize());
	}
	
	@Test
	public void pushPilha() {
		p.push("element");
		assertFalse(p.isEmpty());
		assertEquals(1, p.getSize());
		assertEquals("element", p.top());
	}
	
	@Test
	public void pushAndPopElementPilha() {
		p.push('a');
		p.push('b');
		assertFalse(p.isEmpty());
		assertEquals(2, p.getSize());
		assertEquals('b', p.top());
		
		Object popped = p.pop();
//		assertFalse(p.isEmpty());
		assertEquals(1, p.getSize());
		assertEquals('a', p.top());
		assertEquals('b', popped);
	}
	
	@Test
	public void removeFromEmptyPilha() {
		assertThrows(EmptyStackException.class, () -> p.pop());
	}

	@Test
	public void pushOnFullStack() {
		for (int i=0; i<10; i++) {
			p.push("Element" + i);
		}
		assertThrows(FullStackException.class, () -> p.push("Element"));
	}

}

