package com.competitiveprogramming;

import java.util.Scanner;

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 * Example 1:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * Example 2:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * 
 * @author aditya
 *
 */
public class StringReversal2 {

	public static void main(String[] args) {
		StringReversal2 sr = new StringReversal2();
		StringBuilder b = new StringBuilder("");
		Scanner s = new Scanner(System.in);
		String in = s.nextLine();
		int k = s.nextInt();
//		for (String string : sr.divideInParts(in, k*2)) {
////			System.out.println(string);
//			int endIndex = 0;
//			int nextStartIndex = 0;
//			int nextEndIndex = 0;
//			if(string.length() <= k) {
//				endIndex = string.length();
//				nextStartIndex = -999;
//			} else {
//				endIndex = k;
//				nextStartIndex = k;
//				nextEndIndex = string.length();
//			}
//			StringBuilder sk = new StringBuilder("");
//			String[] p = string.substring(0, endIndex).split("");
//			String[] np = new String[p.length];
//			for(int j=0; j<p.length; j++) {
//				sk.append(p[p.length - 1 - j]);
//			}
//			b.append(
//					sk.toString() + (nextStartIndex != -999 ? string.substring(nextStartIndex, nextEndIndex) : "")
//			);
//		}
//		
//		System.out.println(b.toString());
		
		sr.reverseStr(in, k);

	}
	
	public String reverseStr(String s, int k) {
		StringBuilder b = new StringBuilder("");
        for (String string : divideInParts(s, k*2)) {
//			System.out.println(string);
			int endIndex = 0;
			int nextStartIndex = 0;
			int nextEndIndex = 0;
			if(string.length() <= k) {
				endIndex = string.length();
				nextStartIndex = -999;
			} else {
				endIndex = k;
				nextStartIndex = k;
				nextEndIndex = string.length();
			}
			StringBuilder sk = new StringBuilder("");
			String[] p = string.substring(0, endIndex).split("");
			String[] np = new String[p.length];
			for(int j=0; j<p.length; j++) {
				sk.append(p[p.length - 1 - j]);
			}
			b.append(
					sk.toString() + (nextStartIndex != -999 ? string.substring(nextStartIndex, nextEndIndex) : "")
			);
		}
		
		System.out.println(b.toString());
		return b.toString();
    }
    
	public static String[] divideInParts(String s, int partSize) {
        int iteration = 0;
        int parts = ( (s.length() % partSize) == 0 ) ? s.length() / partSize : ((s.length() / partSize) + 1);
        String[] strParts = new String[parts];
        
        for (int i=0; i<parts; i++) {
            int endIndex = ((partSize * (i+1)) < s.length()) ? (partSize * (i+1)) : s.length();
            strParts[i] = s.substring(iteration * partSize, endIndex);
            iteration++;
        }
        return strParts;
    }
	
	
}
