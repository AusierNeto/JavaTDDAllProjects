import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TranslatorTests {
	
	private Translator translator;

	@BeforeEach
	public void initializePilha() {
		translator = new Translator();
	}

	@Test
	void emptyTranslator() {
		assertTrue(translator.isEmpty());
	}
	
	@Test
	void translateOne() {
		translator.addTranslation("bom", "good");
		assertFalse(translator.isEmpty());
		assertEquals("good", translator.translate("bom"));
	}
	
	@Test
	void translateTwo() {
		translator.addTranslation("bom", "good");
		translator.addTranslation("mau", "bad");
		assertEquals("good", translator.translate("bom"));
		assertEquals("bad", translator.translate("mau"));
	}
	
	@Test
	void twoTranslationsForSameWord() {
		translator.addTranslation("bom", "good");
		translator.addTranslation("bom", "nice");
		assertEquals("good, nice", translator.translate("bom"));
	}

	@Test
	void translatePhrase() {
		translator.addTranslation("guerra", "war");
		translator.addTranslation("é", "is");
		translator.addTranslation("ruim", "bad");
		assertEquals("war is bad", translator.translatePhrase("guerra é ruim"));
	}
	
	@Test
	void translatePhraseWithTwoTranslationsWord() {
		translator.addTranslation("paz", "peace");
		translator.addTranslation("é", "is");
		translator.addTranslation("bom", "good");
		translator.addTranslation("bom", "nice");
		assertEquals("peace is good", translator.translatePhrase("paz é bom"));
	}

}
