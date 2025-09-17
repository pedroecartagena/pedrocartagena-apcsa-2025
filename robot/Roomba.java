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

		// variables for use down below
		int pileCount = getPileCount();
		int pilesCleaned = 0;
		int area = World.numberOfAvenues() + World.numberOfStreets();
		int biggestPileBeepers = 0;
		double percentDirty = (double)pileCount / (double)area;

		// start cleaning the room
		while (true){
			// did roomba find a pile?
			if(roomba.nextToABeeper()) {
				pilesCleaned++;
				int pileBeepers = pickUpPile();
				if(pileBeepers > biggestPileBeepers) {
					biggestPileBeepers = pileBeepers;
				} 
				totalBeepers += pileBeepers;
			}

			// is the room clean?
			if(pilesCleaned == pileCount) {
				break;
			}

			// move roomba
			if(roomba.frontIsClear()) {
				roomba.move();
			} else if (roomba.facingEast()) {
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			} else {
				turnRight(roomba);
				roomba.move();
				turnRight(roomba);
			}
		}
		// print results
		System.out.println("The area of the room is: " + area + " square units.");
		System.out.println("The total number of piles is: " + pileCount);
		System.out.println("The largest pile of beepers has " + biggestPileBeepers + " beepers.");
		System.out.println("The average pile size is " + (double)totalBeepers / (double)pileCount);
		System.out.println("The percent dirty is " + percentDirty);
		return totalBeepers;
	}

	// gets the number of piles in the room
	private int getPileCount() {
		Enumeration piles = World.beepers();
		int pileCount = 0;
		while(piles.hasMoreElements()) {
			piles.nextElement();
			pileCount++;
		}
		return pileCount;
	}

	// gets total number of beepers in a pile and picks them all up
	private int pickUpPile() {
		int pileCount = 0;
		while (roomba.nextToABeeper()) {
			roomba.pickBeeper();
			pileCount++;
		}
		return pileCount;
	}
}
