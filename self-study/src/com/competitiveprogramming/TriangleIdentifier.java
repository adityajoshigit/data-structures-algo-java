/**
 * 
 */
package com.competitiveprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author aditya
 *
 */
public class TriangleIdentifier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TriangleIdentifier t = new TriangleIdentifier();
		
		Scanner s = new Scanner(System.in);
		String sizeString = s.nextLine();
		
		if(sizeString != null && !sizeString.trim().isEmpty() && Integer.parseInt(sizeString) > 0) {
			int[] arr = Arrays.stream(s.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
			System.out.println(t.findTriangles(arr));
		} else {
			System.out.println("0");
		}
	}

	
	public int findTriangles(int[] arr) {
		if (arr.length < 3) {
			return 0;
		}
		// 9 2 8 8 2 7 8 3 6 6 5 8 9 4 2 1
		
		
		List<Integer> lastLongerBase = new ArrayList<Integer>();
		List<Integer> longestBase = new ArrayList<Integer>();

		int a = 0;
		int b = 1;
		int c = 2;
		int score = 0;
		
		
		while(c < arr.length) {
//			System.out.println("a " + a);
//			System.out.println("b " + b);
//			System.out.println("c " + c);
			if(
				(arr[a] < arr[b]) && (arr[b] < arr[c])
			||  (arr[a] > arr[b]) && (arr[b] > arr[c])
			||  (arr[a] < arr[b]) && (arr[b] > arr[c])
			) {
				if(longestBase.size() == 0) {
					longestBase.add(arr[a]);
					longestBase.add(arr[b]);
				}
				longestBase.add(arr[c]);
//				System.out.println("---");
//				longestBase.forEach(e -> System.out.println(e));
			} else {
				longestBase.clear();
			}
			
			if(lastLongerBase.size() < longestBase.size()) {
				lastLongerBase.clear();
				lastLongerBase.addAll(longestBase);	
				score = lastLongerBase.size();
			}
			
			a += 1;
			b += 1;
			c += 1;

		}
		
		return score;
		
		
		
	}

}
