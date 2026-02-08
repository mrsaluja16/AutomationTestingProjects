package java.Interview.Examples;

public class CheckPalindromeForInteger {
	
	public static void main(String[] args) {
		
		System.out.println(checkNumberPalindrome(100001));
		System.out.println(checkNumberPalindrome(123456));
	}
	
	public static boolean checkNumberPalindrome(int num) {
		int reverse = 0;
		int remainder = 0;
		int actualVal = num; 
		
		do {
			remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num/10;
		}while(num>0);

		if(actualVal==reverse)
			return true;
		else 
			return false;
	}

}
