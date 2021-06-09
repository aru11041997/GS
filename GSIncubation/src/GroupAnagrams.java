import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(group(new ArrayList<String>(Arrays.asList("cat", "dog", "god"))));
		System.out.println(group(null));
		System.out.println(group(new ArrayList<String>()));

	}

	private static Set<Set<String>> group(List<String> words) {
		Set<Set<String>> output = new HashSet<>();
		if (words == null || words.isEmpty())
			return output;
		else {
			Map<String, Set<String>> map = new HashMap<>();
			for (int i = 0; i < words.size(); i++) {
				char[] word = words.get(i).toCharArray();
				Arrays.sort(word);
				String obtainedWord = String.valueOf(word);
				if (!map.containsKey(obtainedWord)) {
					Set<String> newWord = new HashSet<>();
					newWord.add(words.get(i));
					map.put(obtainedWord, newWord);
				} else {
					map.get(obtainedWord).add(words.get(i));
				}
			}
			output.addAll(map.values());
			return output;
		}
		
	}
}