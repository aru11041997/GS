public class IsPowerOf10 {
	public static void main(String[] args) {
		System.out.println(isPowerOfTen(10000));
		System.out.println(isPowerOfTen(100));
		System.out.println(isPowerOfTen(15));
		System.out.println(isPowerOfTen(8192));
	}

	private static boolean isPowerOfTen(int number) {
		int baseValueTen=10;
		int baseValue=baseValueTen;
		if(number==baseValueTen||number==1) {
			return true;
		} else if(number == 0 ) {
			return false;
		}
		int i=1;
		while(baseValueTen<number){
			baseValueTen*=baseValueTen;
			i*=2;
		}
		int lowerValue=i/2;
		int higherValue=i;
		return checkIfNumberIsPowerOfTen(lowerValue,higherValue,number,baseValue);
	}
	
	public static boolean checkIfNumberIsPowerOfTen(int lowerValue, int higherValue, int number,int baseValue){
		int midValue = (lowerValue + higherValue) / 2;
		int result;
        while (lowerValue <= higherValue) {
            result = (int) Math.pow(baseValue, midValue);
            if (result < number) {
                lowerValue = midValue + 1;
            } else if (result == number) {
                return true;
            } else {
                higherValue = midValue - 1;
            }
            midValue=(lowerValue+higherValue)/2;
        }
        return false;
	}
	
}
