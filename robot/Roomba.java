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
		System.out.println("The total number of beepers is " + totalBeepers);
	}

	// declared here so it is visible in all the methods!
	private Robot roomba;
	int totalBeepers = 0; 
	boolean roomIsClean = false;
	public int area = 0;

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
		World.setDelay(1);
		
		roomba = new Robot(startX,startY,East,0);

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		int pileCount = getPileCount();
		int pilesCleaned = 0;
		int area = World.numberOfAvenues() + World.numberOfStreets();
		int currentPile = 0;
		int biggestPile = 0;

		while (true){
			// did roomba find a pile?
			if(roomba.nextToABeeper()) {
				pilesCleaned++;
				totalBeepers += pickUpPile();
				currentPile++;
			}

			if(pilesCleaned == pileCount) {
				break;
			}

			if(currentPile > biggestPile){
				biggestPile = currentPile;
			}

			if(roomba.frontIsClear()) {
				roomba.move();
				area++;
			} else if (roomba.facingEast()) {
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
				area++;
			} else {
				turnRight(roomba);
				roomba.move();
				turnRight(roomba);
				area++;
			}
		}
		System.out.println("The area of the room is: " + area);
		System.out.println("The largest pile of beepers has " + biggestPile + " beepers.");
		return totalBeepers;
	}

	private int getPileCount() {
		Enumeration piles = World.beepers();
		int pileCount = 0;
		while(piles.hasMoreElements()) {
			piles.nextElement();
			pileCount++;
		}
		return pileCount;
	}

	private int pickUpPile() {
		int pileCount = 0;
		while (roomba.nextToABeeper()) {
			roomba.pickBeeper();
			pileCount++;
		}

		return pileCount;
	}
}
