package java.Interview.Examples;

import org.apache.commons.codec.binary.StringUtils;

public class LOOKCheckPalindromeUsingStringBuilder {

	public static void main(String[] args) {
		System.out.println(checkPalindrome("abccba"));
		System.out.println(checkPalindrome("abccbas"));
		System.out.println(checkPalindromeUsingLoop("abccba"));
		System.out.println(checkPalindromeUsingLoop("abccbas"));
		System.out.println(checkPalindromeUsingRecurrsion("abccba"));
		System.out.println(checkPalindromeUsingRecurrsion("abccbas"));

	}
	
	//check Palindrome using StringBuilder
	private static boolean checkPalindrome(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		if(s.equals(reverse))
			return true;
		else
			return false;
	}
	
	//Check Palindrome using Loop
	private static boolean checkPalindromeUsingLoop(String s) {
		if(s==null)
			return false;
		int length = s.length();
		for(int i=0; i<length; i++) {
			if(s.charAt(i) != s.length()-1-i)
				return false;
		}
		return true;
	}
	
	//Check palindrom using Recurrsion
	private static boolean checkPalindromeUsingRecurrsion(String s) {
		boolean value = false;
		if(s==null) {
			value = false;
		}
		if(s.length()<=1) {
			value = true;
		}
		String first = s.substring(0,1);
		String last = s.substring(s.length()-1, s.length());
		if(!first.equals(last)) {
			value = false;
		}
		else {
			checkPalindromeUsingRecurrsion(s.substring(1,s.length()-1));
		}
		return value;
	}

}
