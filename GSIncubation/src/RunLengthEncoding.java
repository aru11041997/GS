import java.util.Arrays;

public class RunLengthEncoding {

	public static void main(String[] args) {
		System.out.println(rle("aaabbbaad"));
		System.out.println(rle("a"));
		System.out.println(rle("aa"));
		System.out.println(rle("aabbb"));
		System.out.println(rle("aabbbaa"));
		System.out.println(rle("aA"));
		System.out.println(rle(""));
	}
	
	public static String rle(String input) {
		if(input==null) {
			throw new IllegalArgumentException("Inavlid input");
		} 
		else if(input.equals("")) {
			return "";
		} 
		String output="";
		String temp="";
		for(int i=0;i<input.length();i++) {
			if(i < input.length() - 1 && input.charAt(i)==input.charAt(i+1)) {
				temp+=input.charAt(i);
			} else {
				output+=input.charAt(i);
				output+=temp.length()+1;
				temp="";
			}
		}
		return output;
	}

}
