package com.competitiveprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class LongestSubstring {

	static Comparator<String> compareByLength = (String a, String b) -> b.length() - a.length();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String in = "";
//		int start = 0;
//		int maxSubstringLength = in.length();
//		
//		
//		while((start + maxSubstringLength) <= in.length()) {
//			String s = in.substring(start, start + maxSubstringLength);
//			List<String> ls = Arrays.asList(in.split(""));
//			String ele = ls.remove(0);
//			if (ls.contains(ele)) { 
//				maxSubstringLength--;
//				start = 0;
//			}
//			start++;
//		}
//		
//		System.out.println(isCharRepeated(""));
		
//		System.out.println("ad".substring(0, 1));
		
		
		
//		ls.forEach(e -> System.out.println(e));
		
		System.out.println(findMaxSubstringWithoutRep("puuywsnezdufctcjqmrkiwhwerepqyehsyirqvxryrwbmbmepfpzeyvkrzajzesteakwvhnwalznmnrbu").length());
		
		
	}
	
	public static String findMaxSubstringWithoutRep(String str) {
		List<String> ls = getAllSubstrings(str);
		Collections.sort(ls, compareByLength);
		
		for (String s : ls) {
			if (!isCharRepeated(s)) {
				return s;
			}
		}
		
		return "";
	}
	
	public static boolean isCharRepeated(String s) {
		if (!s.trim().isEmpty()) {
			HashSet<Character> charSet = new HashSet<Character>();
			for(String c : s.split("")) {
				if(charSet.contains(c.charAt(0))) return true;
				else charSet.add(c.charAt(0));
			}	
		}
		return false;
	}
	
//	
//	public static void printList(List<String> l) {
//		System.out.print("{ ");
//		l.forEach(e -> System.out.print(e + " "));
//		System.out.println(" }");
//	}
//	
	public static List<String> getAllSubstrings(String s) {

		HashSet<String> substrings = new HashSet<String>();
		if(s != null && !s.trim().isEmpty()) {
			
			for(int i=0;i<s.length();i++) {
				for(int j=i+1;j<=s.length();j++) {
					substrings.add(s.substring(i, j));
				}
			}

		} 
		
		return new ArrayList<String>(substrings);
	}
	
	
	

}
