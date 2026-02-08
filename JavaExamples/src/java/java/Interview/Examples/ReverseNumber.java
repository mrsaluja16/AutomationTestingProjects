package java.Interview.Examples;

public class ReverseNumber {

	public static void main(String[] args) {
		reverse(1234);

	}
	
	public static void reverse(int num) {
		int result = 0;
		while (num>0) {
			result=result*10+num%10;
			num  = num/10;
		}
		System.out.println("Result of the reversed number is: "+result);
	}

}
