import java.util.Scanner;
/* Patty Bailey - CMPT201 - Final Project */
/**
 * UserPigPlayer Class
 * Contains a constructor, an isRolling method, and a main method.
 */
public class UserPigPlayer extends PigPlayer{
  
  //// Constructor ////
  
  /** Constructor that takes a name as a String. */
  public UserPigPlayer(String playerName){
    super(playerName);  
  }
  
  ////Methods////
  
  /** Method that gives the user their score and prompts them to roll or hold. 
    * Accepts two ints(turnTotal, opponentScore). */
  public boolean isRolling(int turnTotal, int opponentScore){
    String playerName = super.getName();
    if(!((turnTotal + super.getScore())>=PigGame.GOAL)){
      System.out.println("Turn total so far: " + turnTotal + "  Roll/Hold?");
      Scanner input = new Scanner(System.in);
      String x = input.nextLine();
      if (x.equals(""))
        return true;
      return false;
    }
    else
      System.out.println(playerName + " won!");
    return false;
  }
  
  /** Main method for the UserPigPlayer class. */
  public static void main(String[] args) { 
    UserPigPlayer player = new UserPigPlayer("Patty");
    System.out.println(player.isRolling(10, 9));
  }  
}
