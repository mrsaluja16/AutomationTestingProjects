package java.String.Examples;

import java.util.HashMap;
import java.util.Map;

public class CharacterOccurence {
	
	public static void main(String args[]) {
		new CharacterOccurence().characterOccur("abracadabra");
	}

	public void characterOccur(String str) {
		char[] ch = str.toCharArray();
		int count = 1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0 ; i<ch.length; i++) {
			if(!map.containsKey(ch[i]))
				map.put(ch[i], count);
			else
				map.put(ch[i], map.get(ch[i])+1);
		}
		for(char c: map.keySet()) {
			System.out.println("Character "+c+" came "+map.get(c)+ " time in the String");
		}
		//Printing DUPLICATES
		for(char cc : map.keySet()) {
			if(map.get(cc)>1)
				System.out.println("Character "+cc+" is the duplicate word which came "+map.get(cc)+" times");
		}
	}
}
