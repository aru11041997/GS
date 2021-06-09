
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestWord {
	public static void main(String[] args) {
		String[] wordsInDictionary = new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book",
				"banana" };
		Dictionary dictionary = new Dictionary(wordsInDictionary);
		System.out.println(longestWord("oet", dictionary));
		System.out.println(longestWord("oetdg", dictionary));
		System.out.println(longestWord("", dictionary));
		System.out.println(longestWord("", null));
		System.out.println(longestWord(null, null));
	}

	private static Set<String> longestWord(String letters, Dictionary dictionary) {

		Set<String> result = new HashSet<>();
		if (letters == null || dictionary == null)
			return result;
		Map<Character, Integer> countOfChars;
		int length = 0;
		int prevlength = 0;
		String[] words = dictionary.words;
		for (int i = 0; i < words.length; i++) {
			countOfChars = new HashMap<>();
			addCharactersOfDictionaryWord(countOfChars, words, i);
			removeCharactersOfLetterInDictionarWord(letters, countOfChars);
			if (checkValuesAreZero(countOfChars)) {

				length = words[i].length();
				if (length > prevlength) {
					result.clear();
					result.add(words[i]);
					prevlength=length;
				} else if (prevlength == length) {
					result.add(words[i]);
				}
			}

		}
		return result;
	}

	private static void removeCharactersOfLetterInDictionarWord(String letters, Map<Character, Integer> countOfChars) {
		for (int j = 0; j < letters.length(); j++) {
			if (countOfChars.containsKey(letters.charAt(j))) {
				countOfChars.put(letters.charAt(j), countOfChars.get(letters.charAt(j)) - 1);
			}
		}
	}

	private static void addCharactersOfDictionaryWord(Map<Character, Integer> countOfChars, String[] words, int i) {
		for (int j = 0; j < words[i].length(); j++) {
			if (countOfChars.containsKey(words[i].charAt(j))) {
				countOfChars.put(words[i].charAt(j), countOfChars.get(words[i].charAt(j)) + 1);
			} else {
				countOfChars.put(words[i].charAt(j), 1);
			}

		}
	}

	private static boolean checkValuesAreZero(Map<Character, Integer> countOfChars) {
		for (Character ch : countOfChars.keySet()) {
			if (countOfChars.get(ch) > 0)
				return false;
		}
		return true;
	}

}

class Dictionary {
	String[] words;

	public Dictionary(String[] words) {
		this.words = words;
	}
}
