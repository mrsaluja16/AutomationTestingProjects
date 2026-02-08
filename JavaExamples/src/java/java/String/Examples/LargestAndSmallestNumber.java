package java.String.Examples;

import java.util.Arrays;

public class LargestAndSmallestNumber {

	public static void main(String[] args) {
		int[] arr = {3, 8 , 5, 19, 34, 2, 9, 130, 42, 1};
		new LargestAndSmallestNumber().largestAndSmallest(arr);

	}
	
	public void largestAndSmallest(int[] num){
		int largest = num[0];
		int smallest = num[0];
		for(int i=1; i<num.length; i++) {
			if(num[i]>largest)
				largest = num[i];
			if(num[i]<smallest)
				smallest = num[i];
		}
		System.out.println(Arrays.toString(num));
		System.out.println("Largest number in the above array is: "+largest);
		System.out.println("Smallest number in the above array is: "+smallest);
		
	}

}
