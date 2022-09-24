/**
 * 
 */
package com.competitiveprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @author aditya
 *
 */
public class TripletSummationProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TripletSummationProblem t = new TripletSummationProblem();
		t.tripletSum(new int[] {-9, -5, -2, 0, 2, 5, 7, 11, 15});

	}
	
	public List<List<Integer>> tripletSum(int[] nums) {
		List<List<Integer>> lst = new ArrayList<List<Integer>>();
		List<List<Integer>> tripletList = new ArrayList<List<Integer>>();
//		System.out.println("here..");
		for(int i=0;i<nums.length;i++) {
			int cmp1 = nums[i];
//			System.out.println("first loop.. " + i);
			int[] otherCmp = new int[2];
			
			for(int j=i+1;j<nums.length;j++) {
//				System.out.println("second loop.. " + j);
				for(int k=j+1;k<nums.length;k++) {

					if((nums[j] + nums[k] + nums[i]) == 0) {
//						System.out.println("BINGOOOOOOOO..");
						List<Integer> l = new ArrayList<Integer>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[k]);
//						System.out.println("i = " + i);
//						System.out.println("j = " + j);
//						System.out.println("k = " + k);
						lst.add(l);
					}
				}
			}
			
		}
		
		HashSet<String> nonDupSet = new HashSet<String>();
		for(List<Integer> l : lst) {
			BinaryOperator<String> b = (aa, bb) -> aa + bb;
			l.sort((e1, e2) -> {
				return e1.intValue() - e2.intValue();
			});
			String s = l.stream().map(i -> String.valueOf(i.intValue())).reduce("", b);
//			System.out.println("s = " + s);
			if(!nonDupSet.contains(s)) {
				tripletList.add(l);
				nonDupSet.add(s);
			}
		}
		
//		tripletList.forEach(e -> {
//			System.out.println("---");
//			e.forEach(ele -> System.out.println(ele));
//		});
		
		return tripletList;
    }

}
