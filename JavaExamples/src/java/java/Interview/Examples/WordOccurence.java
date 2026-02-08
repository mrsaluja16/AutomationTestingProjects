package java.Interview.Examples;

public class WordOccurence {
	
	public static void main(String args[]) {
		new WordOccurence().wordCount("Java is an object oriented language", "a");
	}
	
	public void wordCount(String str, String s) {
		String strCountWithoutS = str.toLowerCase().replaceAll(s, "");
		int result = str.toLowerCase().length()-strCountWithoutS.length();
		System.out.println("Count of word "+s+" is "+result);
	}

}
