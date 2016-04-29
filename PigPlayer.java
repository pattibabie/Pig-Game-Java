/* Patty Bailey - CMPT201 - Final Project */
/**
 * PigPlayer Class
 * Contains three instance variables, one constructor, and ten methods.
 * Methods include: abstract isRolling, setName, getName, reset, addPoints,
 * won, getScore, getWinRecord, toString, and main method.
 */

public abstract class PigPlayer {
  
  //// Instance variables ////
  
  private String name;
  private int currentScore=0;
  private int gamesWon=0;
  
  //// Constructor ////
  
  /** Constructor that sets the player's name. 
    * Accepts playerName as a String. */
  public PigPlayer(String playerName){
    name = playerName;  
  }
  
  //// Methods ////
  
  /** Method that returns whether or not the player wants to roll the die. 
    * Accepts two ints. */
  public abstract boolean isRolling(int turnTotal, int opponentScore);
  
  /** Method that records the player's name as input by the user. 
    * Accepts a String(playName). */
  public void setName(String playName){
    name = playName;
  }  
  
  /** Method that returns the player's chosen name as a String. */
  public String getName(){
    return name;
  }
  
  /** Method that gets the player ready for a new game by setting the score to 0. */
  public void reset(){
    currentScore = 0;
  }
  
  /** Method that adds the turn total to the player's score. 
    * Also increments the number of wins if the player's score is greater 
    * than or equal to the goal.
    * Accepts an int(turnTotal). */
  public void addPoints(int turnTotal){
    currentScore = turnTotal+currentScore;
    if (won()){
      gamesWon = gamesWon+1;
    }
  }  
  
  /** Method that returns true if this player has won the game. */
  boolean won(){
    return currentScore >= PigGame.GOAL;
  }
  
  /** Method that returns the player's current score. */
  int getScore(){
    return currentScore;
  }
  
  /** Method that returns the number of games the player has won. */
  int getWinRecord(){
    return gamesWon;
  }
  
  /** Method that returns a String with the player's name and score. */
  public String toString(){
    return name + "'s score is " + currentScore + "."; 
  }
  
  /** Main Method of the PigPlayer class. */
  /*public static void main(String[] args) { 
   PigPlayer player = new PigPlayer("Miaka");
   System.out.println(player.getName());
   player.setName("Anakin");
   System.out.println(player.getName());
   player.addPoints(10);
   System.out.println(player.getScore());
   player.addPoints(11);
   System.out.println(player.getScore());
   System.out.println(player.won());
   System.out.println(player.getWinRecord());
   System.out.println(player.toString());
   }*/  
}
