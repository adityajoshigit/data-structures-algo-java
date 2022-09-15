/**
 * 
 */
package com.javabasics.userinput;

import java.util.Scanner;

/**
 * @author aditya
 *
 */
public class UserInput {
	public void getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your input here:\n");
		sc.useDelimiter("\\.end");
		String someInput = sc.next();
		System.out.println("This is your input = " + someInput);
		sc.close();
	}
}
