import java.util.Scanner;
/* Patty Bailey - CMPT201 - Final Project */
/**
 * PigGame Class
 * Contains three instance variables, three constructors, and nine methods.
 * Methods include: reset, setVerbose, playTurn, playGame, rules, userVsUser, 
 * userVsComputer, computerVsComputer, and main method.
 */
public class PigGame {
  
  //// Instance variables ////
  
  public static final int GOAL = 100;
  private static boolean verbose = true;
  private PigPlayer playerOne;
  private PigPlayer playerTwo;
  
  //// Constructors ////
  
  /** Default constructor that creates two UserPigPlayers (Player 1 and Player 2). */
  public PigGame(){
    playerOne = new UserPigPlayer("player 1");
    playerTwo = new UserPigPlayer("player 2");    
  }
  /** Constructor that takes two Strings and creates two UserPigPlayers with those two 
    * Strings as the names. */
  public PigGame(String p1Name, String p2Name){
    playerOne = new UserPigPlayer(p1Name);
    playerTwo = new UserPigPlayer(p2Name);   
  }
  /** Constructor that takes two PigPlayers. */
  public PigGame(PigPlayer player1, PigPlayer player2){
    playerOne = player1;
    playerTwo = player2;  
  }
  
  ////Methods////
  
  /** Method to reset the two PigPlayers. */
  public void reset(){
    playerOne.reset();
    playerTwo.reset();
  }
  
  /** Method to set whether comments print or not. 
    * Set to true, comments print. Set to false, comments don't print.
    * Accepts a boolean(answer). */
  public void setVerbose(boolean answer){
    verbose = answer;    
  }
  
  /** Method that allows the player to roll or hold the die until the turn is over, by calling
    * the isRolling method. 
    * Returns the turn total rolled (0 if 1 was rolled, or the turn total if the player chose to hold). 
    * Accepts two PigPlayers(player, opponent). */
  public static int playTurn(PigPlayer player, PigPlayer opponent){
    int turnTotal=0;
    boolean result;
    do{
      int rolled = Die.roll(); //Roll
      if (verbose){
        System.out.println("Rolled: " + rolled);
      }
      if(rolled == 1){ //Checks if 1 is rolled
        turnTotal = 0;
        result = false;    
      }
      else{
        turnTotal += rolled; //Increments turnTotal
        result = player.isRolling(turnTotal, opponent.getScore()); //Roll/Hold?
      }
    }while(result);
    
    player.addPoints(turnTotal); //Increments total score
    
    if(!player.won()){ //checks if player hasn't won and prints prompts to continue game.
      if (verbose){
        System.out.println("Turntotal: " + turnTotal); 
        System.out.println(player.toString()); //Prints player's score
        System.out.println(opponent.toString()); //Prints opponent's score
        System.out.println("It's " + opponent.getName() + "'s turn.");
      }
      return turnTotal;
    }
    else
      if (verbose){
      System.out.println(player.getName() + " won!");
      System.out.println(player.getName() + "'s winning score is " + player.getScore() + 
                         " and win record is now " + player.getWinRecord() + ".");
      System.out.println(opponent.toString()); //Prints opponent's score
    }
    return turnTotal;
  }
  
  /** Method that plays an entire game of Pig. */
  public void playGame(){
    while (!playerOne.won() && !playerTwo.won()){
      int playerOneTurnTotal = playTurn(playerOne, playerTwo);
      if (playerOne.won())
        return;
      int playerTwoTurnTotal = playTurn(playerTwo, playerOne);
    }
  } 
  
  /** Method that contains the rules for Pig. */
  private static void rules(){
    if (verbose){
      System.out.println("Let's play Pig!");
      System.out.println("");
      System.out.println("Two players race to reach 100 points.");
      System.out.println("");
      System.out.println("Each turn, a player repeatedly rolls a die until either a 1 is rolled,");
      System.out.println("or the player holds and scores the sum of the rolls (i.e. the turn total).");
      System.out.println("");
      System.out.println("If a 1 is rolled, the player will lose their points for that round.");
      System.out.println("");
      System.out.println("When given a choice to roll or hold, please press ENTER to roll,");
      System.out.println("or press any other key to hold.");
      System.out.println("");
      System.out.println("Good luck!");  
      System.out.println("");
    }
  }                            
  
  /** Method that allows for two users to play Pig. 
    * It prints the rules, and prompts the users for their names. 
    * It decides randomly (using Math.random) which player will go first, creates a PigGame object,
    * then calls playGame to run the game. */
  public static void userVsUser(){
    rules(); //Prints the rules for Pig
    
    if (verbose){
      System.out.println("First player, please enter your player name.");
    }
    Scanner input = new Scanner(System.in);
    String playName1 = input.nextLine();
    while(playName1.equals("")){
      if (verbose){
        System.out.println("Invalid player name entered. Please enter a valid player name.");
      }
      playName1 = input.nextLine();
    } 
    if (verbose){
      System.out.println("Second player, please enter your player name.");
    }
    String playName2 = input.nextLine();
    while(playName2.equals("")){
      if (verbose){
        System.out.println("Invalid player name entered. Please enter a valid player name.");
      }
      playName2 = input.nextLine();   
    } 
    if(Math.random()>=0 && Math.random()<0.5){
      if (verbose){
        System.out.println(playName1 + " will be the first to roll.");
      }
      PigGame newGame = new PigGame(playName1, playName2);
      newGame.playGame();
    }
    else{
      if (verbose){
        System.out.println(playName2 + " will be the first to roll.");
      }
      PigGame newGame = new PigGame(playName2, playName1);
      newGame.playGame();
    }
  } 
  
  /** Method that allows the user to play Pig against the computer. 
    * It prints the rules, and prompts the user for their name. 
    * It decides randomly (using Math.random) which player will go first, then calls playGame 
    * to run the game. */
  public static void userVsComputer(){
    rules(); //Prints the rules for Pig
    
    if (verbose){
      System.out.println("Please enter your player name.");
    }
    Scanner input = new Scanner(System.in);
    String human = input.nextLine();
    while(human.equals("")){
      if (verbose){
        System.out.println("Invalid player name entered. Please enter a valid player name.");
      }
      human = input.nextLine();
    }
    if (verbose){
      System.out.println(human + " will be the first to roll.");
    }
    UserPigPlayer player = new UserPigPlayer(human);
    SimpleHoldPlayer computer = new SimpleHoldPlayer("Franky 8-bit");
    
    PigGame newGame = new PigGame(player, computer);
    newGame.playGame();      
  }
  
  /** Method that plays the computer against itself at Pig. */
  public static void computerVsComputer(){
    SimpleHoldPlayer computerOne = new SimpleHoldPlayer("Player 1");
    SimpleHoldPlayer computerTwo = new SimpleHoldPlayer("Player 2");
    if (verbose){
      System.out.println(computerOne.getName() + " will be the first to roll.");
    }
    PigGame newGame = new PigGame(computerOne, computerTwo);
    newGame.playGame(); 
  } 
  
  /** Main method of the PigGame class.*/
  public static void main(String[]args){
    userVsUser();
    //userVsComputer();
    //computerVsComputer();
  }
}
