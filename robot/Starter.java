package robot;
import kareltherobot.*;


public class Starter implements Directions{

  public static void main(String[] args) {

    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(20,20);


    // The line below creates a Robot that we will refer to as rob
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob = new Robot(4,2,North,50);
    Robot bob = new Robot(5, 18,West,50);

    //letter P
    for(int i = 0; i <= 10; i++) {
      rob.move();
      rob.putBeeper();
    }
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    for(int i = 0; i <= 5; i++){
      rob.move();
      rob.putBeeper();
    }
    rob.putBeeper();
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    for(int i = 0; i <= 4; i++){
      rob.move();
      rob.putBeeper();
    }
    rob.putBeeper();
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    for(int i = 0; i <= 5; i++){
      rob.move();
      rob.putBeeper();
    }

    //letter C
    for(int i = 0; i <= 6; i++) {
      bob.move();
      bob.putBeeper();
    }
    bob.turnLeft();
    bob.turnLeft();
    bob.turnLeft();
    for(int i = 0; i <= 9; i++) {
      bob.move();
      bob.putBeeper();
    }
    bob.turnLeft();
    bob.turnLeft();
    bob.turnLeft();
    for(int i = 0; i <= 6; i++) {
      bob.move();
      bob.putBeeper();
    }
    bob.move();
  }
}
