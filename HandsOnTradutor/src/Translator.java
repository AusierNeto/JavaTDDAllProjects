import java.util.HashMap;
import java.util.Map;

public class Translator {
	
	private Map<String, String> translationsMap = new HashMap<String, String>();

	public Boolean isEmpty() {
		return translationsMap.isEmpty();
	}

	public void addTranslation(String word, String translation) {
		if (translationsMap.containsKey(word)) {
			translation = translate(word) + ", " + translation;
		}
		this.translationsMap.put(word, translation);
	}

	public String translate(String word) {
		return this.translationsMap.get(word);
	}

	private String firstWordTranslation(String word) {
		String translation = translate(word);
		if (translation.contains(","))
			translation = translation.substring(0, translation.indexOf(","));
		return translation;
	}
	
	public String translatePhrase(String phrase) {
		String[] words = phrase.split(" ");
		String phraseTranslation = "";
		for (String word: words) {
			String translation = firstWordTranslation(word);
			phraseTranslation += translation + " ";
		}
		
		return phraseTranslation.trim();
	}

}
