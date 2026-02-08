package java.Interview.Examples;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateIntUsingHashSet {
	
	public static void main(String args[]) {
		int[] arr = {1, 6, 5, 3, 3, 4, 5, 8, 2, 6, 9};
		findDuplicate(arr);
	}
	
	public static void findDuplicate(int[] a) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<a.length; i++) {
			if(!set.add(a[i]))
				System.out.println("The duplicate element is: "+a[i]);
		}
	}

}
