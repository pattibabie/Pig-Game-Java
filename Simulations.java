/* Patty Bailey - CMPT201 - Final Project */
/**
 * Simulations Class
 * Class for the purpose of running simulations on the Pig game.
 * Contains four methods: firstAdvantage, isFirstBetter, bestHoldValue, and main method.
 */
public class Simulations {
  
  ////Methods////
  
  /** Method to run simulations of Pig.
    * Accepts a long(simulations). */
  public static void firstAdvantage(long simulations){
    SimpleHoldPlayer computerOne = new SimpleHoldPlayer("Player 1");
    SimpleHoldPlayer computerTwo = new SimpleHoldPlayer("Player 2");
    //System.out.println(computerOne.getName() + " will be the first to roll.");
    PigGame newGame = new PigGame(computerOne, computerTwo);
    
    for(long i=0;i<simulations;i++){
      newGame.setVerbose(false);
      newGame.playGame();
      newGame.reset();
    }
    System.out.println(computerOne.getName() + "'s win record is " + computerOne.getWinRecord()+ ".");
    System.out.println(computerTwo.getName() + "'s win record is " + computerTwo.getWinRecord()+ ".");
  }
  
  /** Method that runs half the simulations with "first" PigPlayer first, and half the simulations 
    * with "second" PigPlayer first. This removes the bias favoring the player who rolls first.
    * Reports the percentage of games won by the better PigPlayer. 
    * Returns true if the "first" PigPlayer is better, and returns false otherwise. 
    * Accepts a long(simulations), and two PigPlayers(first, second). */
  public static boolean isFirstBetter(long simulations, PigPlayer first, PigPlayer second){
    boolean result = true;
    //first = new SimpleHoldPlayer("Player 1");
    //second = new SimpleHoldPlayer("Player 2");
    //System.out.println(computerOne.getName() + " will be the first to roll.");
    PigGame newGame = new PigGame(first, second);
    PigGame newGame2 = new PigGame(second, first);
    
    for(long i=0;i<(simulations/2);i++){
      newGame.setVerbose(false);
      //newGame2.playGame();
      newGame.playGame();
      //newGame2.reset();
      newGame.reset();
    }
    for(long i=0;i<(simulations/2);i++){
      newGame.setVerbose(false);
      newGame2.playGame();
      //newGame.playGame();
      newGame2.reset();
      //newGame.reset();
    }
    double firstPercent = (first.getWinRecord()/(double)simulations)*100;
    System.out.println(firstPercent);
    double secondPercent = (second.getWinRecord()/(double)simulations)*100;
    System.out.println(secondPercent);
    if(firstPercent>50){
      System.out.println(first.getName() + " won " + firstPercent + "% of the Pig games played.");
      result = true;
    }
    else if(secondPercent>50){
      System.out.println(second.getName() + " won " + secondPercent + "% of the Pig games played.");
      result = false;
    }
    else if(firstPercent==50 && secondPercent==50){
      System.out.println(first.getName() + " & " + second.getName() + " tied at 50%.");
    }
    return result;
  } 
  
  /** Method to determine the most advantageous hold value. */
  public static int bestHoldValue(){
    int holdVal = 0;
    for(int i=0; i<PigGame.GOAL;i++){
      holdVal = i;
      SimpleHoldPlayer first = new SimpleHoldPlayer("hold at"+holdVal, holdVal);
      SimpleHoldPlayer second = new SimpleHoldPlayer("hold at 20", 20);
      if(isFirstBetter(100,first,second)){
        System.out.println(holdVal);
      }
    }
    return holdVal;
  }
  
  /** Main method for the Simulations class. */
  public static void main(String[] args) { 
    //firstAdvantage(1000000);
    bestHoldValue();
  }
}
