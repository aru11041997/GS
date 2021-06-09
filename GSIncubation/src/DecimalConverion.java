import java.lang.reflect.Method;
import java.util.HashMap;

public class DecimalConverion {
	public static void main(String[] args) {
		System.out.println(vulgarToDecimal(1L, 2L));
		System.out.println(vulgarToDecimal(1L, 3L));
		System.out.println(vulgarToDecimal(1L, 30L));
		System.out.println(vulgarToDecimal(1L, 75L));
		System.out.println(vulgarToDecimal(4L, -7L));
		System.out.println(vulgarToDecimal(0L, 7L));
		System.out.println(vulgarToDecimal(1L, 0L));
	}

	public static String vulgarToDecimal(Long numerator, Long denominator) {
		String result="";
		if(numerator==null||denominator==null) {
			throw new IllegalArgumentException("Invalid inputs");
		} else if(denominator==0) {
			throw new IllegalArgumentException("Denominator should not be Zero");
		} else if(numerator==0) {
			return "0";
		}  else if(denominator==1) {
			return String.valueOf(numerator);
		}
		if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)) {
			result+="-";
			numerator=Math.abs(numerator);
			denominator=Math.abs(denominator);
		}
		long reminder = numerator % denominator;
		long quotient = numerator / denominator;
		HashMap<Long,Integer> map = new HashMap<>();
		long obtainedQuotient = 0;
		result+=String.valueOf(quotient)+".";
		int bracketValue=0;
		while (true) {
			 
			if(map.containsKey(reminder)) {
				bracketValue=map.get(reminder);
				break;
			}
			
			map.put(reminder,result.length());
			reminder *= 10;
			numerator = reminder;
			obtainedQuotient = numerator / denominator;
			result+=String.valueOf(obtainedQuotient);
			reminder = numerator % denominator;
		}
		if(reminder==0) {
			return result;
		}
		return (result.substring(0,bracketValue)+"("+result.substring(bracketValue,result.length())+")");
	}

}
