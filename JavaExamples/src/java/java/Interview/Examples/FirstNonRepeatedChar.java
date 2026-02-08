package java.Interview.Examples;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		new FirstNonRepeatedChar().nonRepeatedChar("swiss");
		new FirstNonRepeatedChar().nonRepeatedChar("programming");

	}
	
	public void nonRepeatedChar(String s) {
		int count = 1;
		char[] ch = s.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0; i<ch.length; i++) {
			if(!map.containsKey(ch[i]))
				map.put(ch[i], count);
			else
				map.put(ch[i], map.get(ch[i])+1);
		}
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1) {
				System.out.println("The first non-repeated character in "+s+" is: "+entry.getKey());
				break;
			}
		}
	}

}
