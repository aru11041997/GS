import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		System.out.println(findFirst("apple"));
		System.out.println(findFirst("0"));
		System.out.println(findFirst("xxyyzz"));
		System.out.println(findFirst(null));
	}

	private static char findFirst(String str1) {

		if (str1 == null || str1.length() == 0)
			throw new IllegalArgumentException("Provided input is invalid");

		char nonRepatedChar = '0';
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			if (map.containsKey(str1.charAt(i)))
				map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
			else
				map.put(str1.charAt(i), 1);
		}
		for (int i = 0; i < str1.length(); i++) {
			if (map.get(str1.charAt(i)) == 1) {
				nonRepatedChar=str1.charAt(i);
				break;
			}
				
		}
		return nonRepatedChar;

	}

}