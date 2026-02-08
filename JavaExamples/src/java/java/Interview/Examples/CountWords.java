package java.Interview.Examples;

import java.util.HashMap;
import java.util.Map;

public class CountWords {
	
	public static void main(String args[]) {
		new CountWords().countWordsMethod("I am learning learning java program in java programming");
	}

	
	public void countWordsMethod(String str) {
		int count =1;
		String[] arr = str.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i<arr.length; i++) {
			if(!map.containsKey(arr[i]))
				map.put(arr[i], count);
			else
				map.put(arr[i], map.get(arr[i])+1);
		}
		for(String s: map.keySet())
			System.out.println("The count of word "+s+" = "+map.get(s));
	}
}
