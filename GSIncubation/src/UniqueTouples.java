package task10;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class UniqueTouples {
	public static void main(String[] args) {

		System.out.println(uniqueTuples("abbccde", 2));
	}

	public static HashSet<String> uniqueTuples(String input, int len) {
		if (input == null || len < 0)
			throw new IllegalArgumentException();
		int start = 0;
		int stop = len;
		HashSet<String> result = new LinkedHashSet<>();
		while (stop < input.length()) {
			result.add(input.substring(start, stop));
			start++;
			stop++;
		}
		result.add(input.substring(start, stop));
		return result;
	}
}
