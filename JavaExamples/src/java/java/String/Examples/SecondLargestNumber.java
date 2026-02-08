package java.String.Examples;

import java.util.Arrays;

public class SecondLargestNumber {

	public static void main(String[] args) {
		int[] arr = {1, 4,99, 44, 21, 89, 45, 77, 13, 120, 42, 42, 54};
		secondLargestForLoop(arr);
		secondLargestUsingArrays(arr);
	}
	
	//Using Arrays sort the array and print the second last number
	public static void secondLargestUsingArrays(int[] a) {
		Arrays.sort(a);
		System.out.println("Second largest value using Arrays class is: "+a[a.length-2]);
	}
	
	//Sort the array using for loop & then print the second last number
	public static void secondLargestForLoop(int[] a) {
		int temp;
		int size = a.length;
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				if(a[i]>a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Second largest number using FOR loop is: "+a[size-2]);
	}

}
