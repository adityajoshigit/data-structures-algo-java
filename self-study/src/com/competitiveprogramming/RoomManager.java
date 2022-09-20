/**
 * 
 */
package com.competitiveprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author aditya
 * 
 * The hotel manager wants to assign the room to the customer. The hotel has N rooms, and each room numbered
 * with 1 to N. Now all rooms are available. The manager wants assign the room according to the following rules.
 * 1. Each customer gives the room number they wish to stay in
 * 2. If the room is available, manager can assign the room
 * 3. If the room is already assigned, the manager can assign the room with the lowest number among the
 * available rooms and also with a larger number than the desired room
 * 
 * Input:
 * The first line contains one positive integer N which is total number of rooms
 * The second line, list of customers’ desired room numbers with space-separated
 * Output:
 * Print, list of room numbers that assigned to customer with space-separated
 * 
 * Sample:
 * No. 
 * Sample Input 
 * Sample Output
 * 
 * 1 - 
 * 10
 * 1 3 4 1 3 1
 * 1 3 4 2 5 6
 * 
 * 2 -  
 * 20
 * 3 5 2 1 7 19 2 6 7 8 15 16 19 14
 * 3 5 2 1 7 19 4 6 8 9 15 16 20 14
 *
 */
public class RoomManager {
	public static String assignRoom(int numOfRooms, String demandedRoomNumbersStr) {
//		List<Integer> assignedRoomNumbers = new ArrayList<Integer>();
//		
		Map<Boolean, ArrayList<Integer>> mapOfAvailability = new HashMap<Boolean, ArrayList<Integer>>();
		ArrayList<Integer> l = Arrays.asList(demandedRoomNumbersStr.split(" "))
		.stream()
		.map(n -> Integer.valueOf(n))
		.collect(Collectors.toCollection(ArrayList::new));
		
		mapOfAvailability.put(
				true, 
				l
		);
		
		Map<Integer, Boolean> mapAvail = new HashMap<Integer, Boolean> (); 
		for (int i = 1; i <= numOfRooms; i++) {
			mapAvail.put(i, true);
		}
		int foundAt = -999;
		String a = "";
		for (Integer room : l) {
			foundAt = room;
			boolean available = mapAvail.get(foundAt);
			while(!available) {
				if(foundAt == l.size()) 
				{
					foundAt = -999;
					break;
				}
				foundAt +=1;
				System.out.println(foundAt);
				available = mapAvail.get(foundAt);
			}
			if(foundAt != -999) {
				a = a + " " + foundAt;
				mapAvail.put(foundAt, false);
			}
			
		}
		System.out.println(a);
		
		return a.trim();
		
	}
}
