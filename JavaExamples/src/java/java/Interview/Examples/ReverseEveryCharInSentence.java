package java.Interview.Examples;

public class ReverseEveryCharInSentence {

	public static void main(String[] args) {
		new ReverseEveryCharInSentence().reverseEachChar("Sentence to reverse");

	}
	
	public void reverseEachChar(String s) {
		String reversedString = "";
		for(int i=s.length()-1; i>=0; i--) {
			reversedString = reversedString + s.charAt(i);
		}
		System.out.println("Reversed string is-----------: "+reversedString);
	}

}