/* Patty Bailey - CMPT201 - Final Project */
/**
 * Die Class
 * Contains a roll method and a main method.
 */
public class Die {
  
  ////Methods////
  
  /** Method that simulates a six-sided die roll, using Math.random. */
  public static int roll(){
    int x = (int)(Math.random()*6)+1;
    return x;
  }
  
  /** Main method of the Die class.*/
  public static void main(String[] args) { 
    
    Die die = new Die();
    System.out.println(die.roll());
    //  while(die.roll()>=1 && die.roll()<=6){
    //    System.out.println(die.roll());
    //  }
  }
}
