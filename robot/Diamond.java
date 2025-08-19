package robot;
import kareltherobot.*;

public class Diamond implements Directions{

    public static void main(String[] args) {

        World.setVisible(true);// allows us to see the run output
        // the bigger the street, the farther north
        World.setSize(10,10);
        World.setDelay(5);


        // The line below creates a Robot that we will refer to as rob
        // Find out what the numbers and direction do!
        // Put rob in a better location for your initials.
        Robot rob = new Robot(6,2,North,90);

        createOctagon(rob, 4);
    }

    public static void turnRight(final Robot robot) {
            robot.turnLeft();
            robot.turnLeft();
            robot.turnLeft();
        } 

    private static void createOctagon(final Robot robot, final int length) {
        for(int i = 1; i<=length; i++){
            robot.move();
            turnRight(robot);
            robot.putBeeper();
            robot.move();
            robot.turnLeft();
            robot.move();
            robot.putBeeper();
            turnRight(robot);
            robot.move();
            robot.putBeeper();
            robot.move();
            robot.putBeeper();
            robot.move();
            robot.putBeeper();
        }
    }
}
