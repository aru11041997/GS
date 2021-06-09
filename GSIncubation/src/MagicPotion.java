package task9;

import java.util.Arrays;

public class MagicPotion {

	public static void main(String[] args) {
		System.out.println(minimalSteps("ABCDABCE"));
		System.out.println(minimalSteps("ABCABCE"));
		System.out.println(minimalSteps("ABCABCABCABC"));
		System.out.println(minimalSteps("AAA"));
		System.out.println(minimalSteps("AAAAAAAA"));
		System.out.println(minimalSteps("AAAAAAA"));
	}

	private static Integer minimalSteps(String ingredients) {

		if (ingredients == null)
			throw new IllegalArgumentException("invalid input");
		else if (ingredients.length() == 0)
			return 0;
		Integer[] memo = new Integer[ingredients.length()];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 1;
		String left = "";
		String right = "";
		int toPointer = 0;

		for (int i = 1; i < ingredients.length(); i++) {
			memo[i] = Math.min(memo[i], memo[i - 1] + 1);

			toPointer = 2 * i + 1;

			if (toPointer < ingredients.length()) {
				left = ingredients.substring(0, i + 1);
				right = ingredients.substring(i + 1, toPointer + 1);

				if (left.equals(right)) {
					memo[2 * i + 1] = memo[i] + 1;
				}
			}
		}

		return memo[ingredients.length() - 1];
	}
}
