public class Pangram {

	public static void main(String[] args) {
		System.out.println(findMissingLetters("The slow purple oryx meanders past the quiescent canine"));
		System.out.println(findMissingLetters("a"));
		System.out.println(findMissingLetters("aa"));
		System.out.println(findMissingLetters("aabbb"));
		System.out.println(findMissingLetters(""));
	}
	
	public static String findMissingLetters(String sentence) {
		
		if(sentence==null) {
			throw new IllegalArgumentException("Inavlid input");
		} 
		String output="";
		char charNotPresentInSentence;
		sentence=sentence.toLowerCase();
		int[] charCount=new int[26];
		for(int i=0;i<sentence.length();i++) {
			if(sentence.charAt(i)>=97&&sentence.charAt(i)<=122)
				charCount[sentence.charAt(i)-'a']=sentence.charAt(i);
		}
		for(int i=0;i<charCount.length;i++) {
			if(charCount[i]==0) {
				charNotPresentInSentence=(char)('a'+i);
				output+=charNotPresentInSentence;
			}
		}
		
		return output;
		
	}

}
