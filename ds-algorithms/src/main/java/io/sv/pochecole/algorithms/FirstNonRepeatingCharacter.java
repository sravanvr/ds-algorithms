package io.sv.pochecole.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Problem: Given an input string find the first non repeating character. 
 *
 */
public class FirstNonRepeatingCharacter {

	private static Map <Character, Integer > counts = new LinkedHashMap<Character, Integer> ();

	private void m1(String str){

		for (int i=0; i< str.length(); i++){
			Character c = str.charAt(i);
			if (counts.containsKey(c))
				counts.put(c, counts.get(c) + 1); 
			else
				counts.put(c,1);
		}

		System.out.println ( "Given String is: " + str);

		for (Entry<Character, Integer> entry: counts.entrySet()){
		
			if (entry.getValue().intValue() ==1){
				System.out.println ( "Method1: Firt non repeating character is: " + entry.getKey());
				return;
			}
		}
	}
	
	private void m2(String str){
		LinkedHashSet<Character> set1 = new LinkedHashSet<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		
		for (int i = 0; i< str.length(); i++){
			if (! list2.contains(str.charAt(i))){
				list2.add(str.charAt(i));
				set1.add(str.charAt(i));
			}
			else{
				//System.out.println("removing..."+ str.charAt(i));
				set1.remove(str.charAt(i));
				
			}
		}
		System.out.println ( "Method2: Firt non repeating character is: " + set1.toArray()[0]);
		
	}
	
	

	public static void main(String[] args) {
		
		FirstNonRepeatingCharacter firstNonRepChar = new FirstNonRepeatingCharacter();
		
		String str = "parrambamabam";
		firstNonRepChar.m1(str);
		firstNonRepChar.m2(str);
		

	}

}
