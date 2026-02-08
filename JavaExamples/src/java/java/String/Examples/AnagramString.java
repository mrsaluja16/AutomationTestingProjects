package java.String.Examples;

import java.util.Arrays;

public class AnagramString {
	
	//When two string has the same characters that is called ANAGRAM string & can be a different word.

	public static void main(String[] args) {
		new AnagramString().checkAnagram("stop", "tops");
	}
	
	public void checkAnagram(String s1, String s2) {
		char[] ch1 = s1.toLowerCase().toCharArray();
		char[] ch2 = s2.toLowerCase().toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		if(Arrays.equals(ch1, ch2))
			System.out.println("Provided string is ANAGRAM String");
		else
			System.out.println("Provided string is NOT ANAGRAM String");
	}

}
