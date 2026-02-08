package java.Interview.Examples;

public class DuplicateValue {

	public static void main(String[] args) {
		int[] arr = {1, 4, 7, 4, 8, 9, 4, 7, 9 , 3};
		findDuplicate(arr);

	}
	
	public static void findDuplicate(int[] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]==a[j]) {
					System.out.println("Value "+a[i]+ " is Duplicate.");
				}
			}
		}
	}

}
