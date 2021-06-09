
public class ReverseStringBug {

	public static void main(String[] args) {
		System.out.println(reverseStr("abcd"));
		System.out.println(reverseStr(""));
		System.out.println(reverseStr("d"));
		System.out.println(reverseStr(null));
	}
	
	public static String reverseStr(String str){
		if(str==null) {
			throw new IllegalArgumentException("Inavlid input");
		}  else {
			StringBuffer output=new StringBuffer(str);
			int i = 0;
			int j = str.length()-1;
			while(i < j) {
				char temp = output.charAt(i);
				output.setCharAt(i, output.charAt(j));
				output.setCharAt(j, temp);
				i++;
				j--;
			}  
			return output.toString();
		}
	}

}
