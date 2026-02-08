package java.String.Examples;

public class CheckPalindrome {
	
	public static void main(String arg[]) {
		System.out.println(isPalindrome1("abba"));
		System.out.println(isPalindrome("abba"));
		System.out.print("Value NITIN is Palindrome: "+isPalindromeRecurrsion("NITIN"));
	}
	
	private static boolean isPalindrome1(String str) {
		if(str==null) return false;
		
		StringBuilder strB = new StringBuilder(str);
		strB.reverse();
		return strB.toString().equals(str);
		
	}
	
	private static boolean isPalindrome(String str) {
		if(str==null) return false;
		int length = str.length();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)!=str.charAt(length-i-1))
				return false;
		}
		return true;
	}
	private static boolean isPalindromeRecurrsion(String str) {
		if(str == null) 
			return false;
		if(str.length()<=1) 
			return true;
		String first = str.substring(0,1);
		String last = str.substring(str.length()-1, str.length());
		if(!first.equals(last))
			return false;
		else
			return isPalindromeRecurrsion(str.substring(1, str.length()-1));
	}

}
