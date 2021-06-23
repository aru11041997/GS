package com.shivam.string;

public class LengthBetweenStrings {

	public static double distance(String s, String w1, String w2) {
		String[] words = s.split("[,. ]");
        int index = 0;
        double shortest = s.length();
        double word1Loc = 0;
        double word2Loc = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase(w1)) {
                word1Loc = index + (word.length() / 2d);
            } else if (word.equalsIgnoreCase(w2)) {
                word2Loc = index + (word.length() / 2d);
            }
            if (word1Loc > 0 && word2Loc > 0) {
                double current = Math.abs(word1Loc - word2Loc);
                if (current < shortest) {
                    shortest = current;
                }
            }
            index += word.length() + 1;
        }
        if (word1Loc == 0 || word2Loc == 0) {
            return -1;
        }
        return shortest;
	}
	
	
	

	public static void main(String args[]) {

		String s = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
		String w1 = "is";
		String w2 = "a";
		System.out.print(distance(s, w1, w2));
	}
}