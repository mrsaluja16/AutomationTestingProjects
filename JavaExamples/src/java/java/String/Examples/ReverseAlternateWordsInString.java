package java.String.Examples;

public class ReverseAlternateWordsInString {

	public static void main(String[] args) {
		//String is "My name is Ranjit Singh"
		//Expected result : "yM name si Ranjit hgniS"
		changedString("My name is Ranjit Singh");
	}
	
	public static void changedString(String s) {
		String[] words = s.split(" ");
		int count = 2;
		char[] ch = null;
		StringBuilder reverseChars = new StringBuilder();
		String[] arrayWord = new String[words.length];
		String newWord = "";
		for(int i=0; i<words.length; i++) {
			if(count%2==0) {
				ch = words[i].toCharArray();
				for(int j=ch.length-1; j>=0; j--) {
					reverseChars = reverseChars.append(ch[j]);
				}
				arrayWord[i] = reverseChars.toString();
				reverseChars.delete(0, reverseChars.length());
			}
			if(!(count%2==0)) {
				arrayWord[i] = words[i];
			}
			count++;
		}
		String delimeter = " ";
		newWord = String.join(delimeter, arrayWord);
		System.out.println("Changed Word is:"+newWord.toString());
	}

}
