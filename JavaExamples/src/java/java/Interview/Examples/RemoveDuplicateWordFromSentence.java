package java.Interview.Examples;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWordFromSentence {

	public static void main(String[] args) {
		removeDuplicateWords("I am Ranjit Ranjit Singh Saluja Singh Saluja");

	}
	
	public static void removeDuplicateWords(String s) {
		String[] str = s.split(" ");
		Set<String> set = new LinkedHashSet<String>();
		for(int i=0; i<str.length; i++) {
			set.add(str[i]);
		}
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
	}

}
