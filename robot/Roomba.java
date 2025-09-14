package robot;

import java.util.Enumeration;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
	}

	// declared here so it is visible in all the methods!
	private Robot roomba;
	private boolean roomClean = false;
	int totalBeepers = 0; 
	boolean roomIsClean = false;

	// You will need to add many variables!!
	public static void turnRight(Robot robot){
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
	}

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(15);
		
		roomba = new Robot(startX,startY,East,0);

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		Enumeration numBeepers = World.beepers();
		int count = 0;
		while(numBeepers.hasMoreElements()){
			numBeepers.nextElement();
			count += 1;
		}

		while (true){
			if (roomba.frontIsClear()){
				roomba.move();
				if (roomba.nextToABeeper()){
					roomba.pickBeeper();
					totalBeepers += 1;
					count -= 1;
					System.out.println(count);
				}
				if (count == 0){
					break;
				}	
			}
			else if(roomba.facingEast()){
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			}
			else if(roomba.facingWest()){
				turnRight(roomba);
				roomba.move();
				turnRight(roomba);
			}
		}
		return totalBeepers;
	}
}
