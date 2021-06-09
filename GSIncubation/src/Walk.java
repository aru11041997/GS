package task8;

import java.util.Arrays;

public class Walk {
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(walk("")));
		System.out.println(Arrays.toString(walk("L")));
		System.out.println(Arrays.toString(walk("UUU")));
		System.out.println(Arrays.toString(walk("ULDR")));
	}

	public static Integer[] walk(String path) {
		if (path == null) {
			throw new IllegalArgumentException();
		}
		Integer[] finalPosition=new Integer[2];
		finalPosition[0]=0;
		finalPosition[1]=0;
		for(int i=0;i<path.length();i++) {
			
			if(path.charAt(i)=='U') {
				finalPosition[1]+=1;
			} else if(path.charAt(i)=='D') {
				finalPosition[1]-=1;
			} else if(path.charAt(i)=='L') {
				finalPosition[0]-=1;
			} else if(path.charAt(i)=='R') {
				finalPosition[0]+=1;
			}
		}
		return finalPosition;
	}
}
