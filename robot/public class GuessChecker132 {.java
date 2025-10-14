public class GuessChecker132 {
    /*
 * Activity 1.3.2
 */
import java.util.Scanner;
 
public class GuessChecker132
{
  static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
    /* Add any variables you will need throughout the program here. */
    
    // Generate a random number
    int targetNumber = getRandomNumber();
    //System.out.println(targetNumber);  // uncomment for debugging
    
    // Break the random number into four variables.
    int r1 = targetNumber / 1000;
    int r2 = targetNumber / 100 % 10;
    int r3 = targetNumber / 10 % 10;
    int r4 = targetNumber % 10;
    
    // Get the user's guess
    int guess = getGuess();
    //System.out.println(guess);   // uncomment for debugging
    
    // Break the user's guess into four variables.
    int g1 = guess / 1000;
    int g2 = guess / 100 % 10;
    int g3 = guess / 10 % 10;
    int g4 = guess % 10;
    int hits = 0;
    int nearhits = 0;
    
    /*your code here*/
    if (g1 == r1){
      hits++;
    }
    if (g2 == r2){
      hits++;
    }
    if (g3 == r3){
      hits++;
    }
    if (g4 == r4){
      hits++;
    }
    else if (g1 == r2 || g1 == r3 || g1 == r4){
      nearhits++
    }
    else if (g2 == r1 || g2 == r3 || g2 == r4){
      nearhits++
    }
    else if (g3 == r1 || g3 == r2 || g3 == r4){
      nearhits++
    }
    else if (g4 == r1 || g4 == r2 || g4 == r3){
      nearhits++
    }
    
    // close Scanner when done
    sc.close();
    System.out.println("Number of hits " + hits);
	}
 
  // Checks to ensure no duplicate digits in a int.
	public static boolean hasDupes(int num)
	{ 
		boolean[] digs = new boolean[10];
		while (num > 0)
		{
			if (digs[num % 10])
			  return true;
			digs[num % 10] = true;
			num /= 10;
		}
		return false;
	}

  // Creates a new random 4 digit code 1000-9999 with no duplicates.
  public static int getRandomNumber() 
  { 
		int target = (int) (Math.random() * 9000 + 1000);
		while (hasDupes(target))
		  target = (int) (Math.random() * 9000 + 1000);
    return target;
  }

  // Prompts the user for a guess and repeats until valid guess is made.
  public static int getGuess()
  { 

    int userGuess = 0;
    boolean validGuess = false;
    
    while (!validGuess)
    {
      System.out.print("Guess a 4-digit number from 1000 to 9999 with no duplicate digits: ");
      userGuess = sc.nextInt();
      if (!(hasDupes(userGuess) || (userGuess < 1000))) 
        validGuess = true;
    }
    return userGuess;
  }
}

}
