import java.util.Arrays;

public class LongestUniformSubString {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(longestUniformSubstring("aabbbbbCdAA")));
		System.out.println(Arrays.toString(longestUniformSubstring("aabbbbbBCdAA")));
		System.out.println(Arrays.toString(longestUniformSubstring("abcd")));
		System.out.println(Arrays.toString(longestUniformSubstring("a")));
		System.out.println(Arrays.toString(longestUniformSubstring("")));
	}

	public static int[] longestUniformSubstring(String input) {
		if(input==null) {
			throw new IllegalArgumentException("Inavlid input");
		} 
		else if(input.equals("")) {
			return new int[] {0,0};
		} else {
			int startIndexOfLongestSubString = 0;
			int longestSubStringLength = 1;
			int tempLongestSubStringLength = 1;
			for (int i = 0; i < input.length(); i++) {
				if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
					tempLongestSubStringLength++;
				} else {
					tempLongestSubStringLength = 1;
				}
				if (tempLongestSubStringLength > longestSubStringLength) {
					startIndexOfLongestSubString=i-longestSubStringLength+1;
					longestSubStringLength = tempLongestSubStringLength;
				}
			}
			return new int[] {startIndexOfLongestSubString, longestSubStringLength};
		}
		
	}
}
