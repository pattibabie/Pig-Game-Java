/* Patty Bailey - CMPT201 - Final Project */
/**
 * SimpleHoldPlayer Class
 * Contains one instance variable, three constructors, 
 * an isRolling method, and a main method.
 */
public class SimpleHoldPlayer extends PigPlayer{
  
  //// Instance variable ////
  
  private int holdValue;
  
  //// Constructors ////
  
  /** Default constructor that sets the holdValue to 20. */
  public SimpleHoldPlayer(){
    super("SimpleHold");
    holdValue = 20;
  }
  
  /** Constructor that takes a String (playerName), and sets the holdValue to 20. */
  public SimpleHoldPlayer(String playerName){
    super(playerName);
    holdValue = 20;
  }
  
  /** Constructor that takes a String(playerName) and an int(holdVal),
    * and sets the holdValue to holdVal. */
  public SimpleHoldPlayer(String playerName, int holdVal){
    super(playerName);
    holdValue = holdVal;
  }
  
  ////Methods////
  
  /** Method that returns true if the die should be rolled, by checking if the 
    * game is not yet won and if the turn total has not yet reached the hold value.
    * Accepts two ints(turnTotal, opponentScore). */
  public boolean isRolling(int turnTotal, int opponentScore){
    if(((super.getScore() + turnTotal) < PigGame.GOAL)){
      if(turnTotal < holdValue)
        return true;
      return false;
    }
    return false;
  }
  
  /** Main method for the SimpleHoldPlayer class. */
  public static void main(String[] args) { 
//    SimpleHoldPlayer player = new SimpleHoldPlayer("Patty");
//    System.out.println(player.isRolling(20, 20));
    SimpleHoldPlayer player = new SimpleHoldPlayer("player", 15);
    System.out.println(player.isRolling(25, 0));
    System.out.println(player.isRolling(10, 100));
  } 
}
