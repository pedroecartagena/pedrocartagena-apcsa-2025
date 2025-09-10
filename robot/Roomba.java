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

	// You will need to add many variables!!
	public static void turnRight(Robot robot){
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
	}
	public boolean roomClean = false;
	int totalBeepers = 0; 

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(1);
		
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
		boolean roomIsClean = false;

		while (roomIsClean == false){
			if (roomba.frontIsClear()){
				roomba.move();
				while(roomba.nextToABeeper()){
					roomba.pickBeeper();
					totalBeepers += 1;
				}
			}
			else if(roomba.frontIsClear() == false && roomba.facingEast()){
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			}
			else if(roomba.frontIsClear() == false && roomba.facingWest()){
				turnRight(roomba);
				roomba.move();
				turnRight(roomba);
			}
			
		}

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		roomba.move();

        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}
