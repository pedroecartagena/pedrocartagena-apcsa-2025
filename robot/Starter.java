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
    Robot rob = new Robot(15,2,South,50);
    Robot bob = new Robot(15, 11,South,50);

    // Want a second robot?  No prob.  They are cheap :)
    //Robot dude = new Robot(7,5,West,9);
    // examples of commands you can invoke on a Robot
    rob.move();// move one step in the direction it is facing


    //letter P
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.turnLeft();
    rob.turnLeft();
    rob.move();
    rob.move();
    rob.move();
    rob.move();
    rob.move();
    rob.move();
    rob.move();
    rob.move();
    rob.move();
    rob.move();

    // letter C
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.move();
    bob.putBeeper();
    bob.turnLeft();
    bob.turnLeft();
    bob.move();
    bob.move();
    bob.move();
    bob.move();
    bob.move();
    bob.move();
    bob.move();
    bob.move();
    bob.move();
    bob.move();
  }
}
