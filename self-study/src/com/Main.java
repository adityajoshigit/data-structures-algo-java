package com;

import com.competitiveprogramming.RoomManager;
import com.javabasics.userinput.UserInput;

/**
 * 
 */

/**
 * @author aditya
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		UserInput i = new UserInput();
//		i.getInput();
		
		long s = System.nanoTime();
		System.out.print(RoomManager.assignRoom(20, "3 5 2 1 7 19 2 6 7 8 15 16 19 14"));
		System.out.println("\n" + (System.nanoTime() - s) / 1000000);
		
	}

}
