package task10;

import java.util.HashMap;
import java.util.Map;

public class UniqueTouplesUsingHashing {
	public static void main(String[] args) {

		System.out.println(uniqueTuples("abbccde", 2));
	}

	public static Map<Long, String> uniqueTuples(String input, int len) {
		if (input == null || len < 0)
			throw new IllegalArgumentException();
		int start = 0;
		int stop = len;
		Map<Long, String> map = new HashMap<>();
		long patternHash = 0;
		int primeNumber = 3;
		while (stop < input.length()) {
			String pattern = input.substring(start, stop);
			for (int i = 0; i < pattern.length(); i++) {
				patternHash = (long) (patternHash + (pattern.charAt(i) * Math.pow(primeNumber, i)));
			}
			if (!map.containsKey(patternHash)) {
				map.put(patternHash, pattern);
			}
			start++;
			stop++;
		}
		
		for (int i = 0; i < input.substring(start, stop).length(); i++) {
			patternHash = (long) (patternHash + (input.substring(start, stop).charAt(i) * Math.pow(primeNumber, i)));
		}
		map.put(patternHash, input.substring(start, stop));
		return map;
	}
}
