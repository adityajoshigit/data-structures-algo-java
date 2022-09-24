package com.competitiveprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSubArray {
	public static int findMaxSubArrayLength(int[] n, int[] m) {
		
		ArrayList<Integer> N = (ArrayList<Integer>) IntStream.of(n);;
		ArrayList<Integer> M = (ArrayList<Integer>) IntStream.of(m);
		HashSet<String> cmpStr = new HashSet<String>(); 
		for(int i=0; i<n.length; i++) {
			String c = "" + i;
			for(int j=i+1; j<n.length; j++) {
				c = c + n[j];
				cmpStr.add(c);
			}
			cmpStr.add(c);
		}
		
		return 0;
	}
	
	public ArrayList<ArrayList<Integer>> createSubsets(int[] arr) {
		int[] ret = new int[arr.length];
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		l.add((ArrayList<Integer>) (Arrays.stream(arr).boxed().collect(Collectors.toList())));
		if(arr.length != 1) {
			for(int i=0; i<(arr.length - 1); i++) 
				ret[i] = arr[i];
			l.addAll(createSubsets(ret));
		}
		return l;
	}
}
