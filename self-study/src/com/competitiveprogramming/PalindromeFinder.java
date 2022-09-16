/**
 * 
 */
package com.competitiveprogramming;

/**
 * @author aditya
 *
 */
public class PalindromeFinder {
	public boolean isPalindrome(String inputString) {
		boolean isPal = true;
		int i = 0;
		int len = inputString.length();
		while (i <= ((len / 2) - 1)) {
			if(inputString.charAt(i) != inputString.charAt(len - 1 - i)) {
				isPal = false;
				break;
			}
            i++;
		}
		return isPal;
	}
	
	public boolean isPalindrome(int inputNumber) {
		boolean isPal = false;
		String numberString = Integer.toString(inputNumber);
		return isPalindrome(numberString);
	}
}
