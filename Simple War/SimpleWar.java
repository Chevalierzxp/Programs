/*Xuanpu Zhang;
chevalierpg@brandeis.edu;
12/02/2016;
this program plays the Simple War Game.
no bugs*/
import java.util.*;
public class SimpleWar{
  public static void main(String[] args){
    Deck d=new Deck();
    //create a new deck
    Scanner console=new Scanner(System.in);
    int start=1000;
    System.out.println("Welcome to the casino. You will start off with $1000");
    String x;
    do{
      //play the game
      System.out.print("How much do you bet? ");
      int y=console.nextInt();
      //enter the money you want to bet
      Card you=d.drawNextCard();
      System.out.println("Your card: "+you);
      d.discard(you);
      Card me=d.drawNextCard();
      System.out.println("My card: "+me);
      d.discard(me);
      int player=you.getValue();
      int computer=me.getValue();
      //get the computer's card and your card
      if(player>computer){
        System.out.println("Congrats, you won!");
        start=start+y;
      }else if(player<computer){
        System.out.println("Sorry, I won!");
        start=start-y;
      }else if(player==computer){
        System.out.println("It's tie.");
        start=start;
      }
      //compare who is bigger and find the winner
      System.out.println("Your new total is: "+start);
      System.out.println("Do you want to keep playing? Y/N: ");
      //ask if you want to play again
      x=console.next();
    }while(x.equals("y")&& start>0);
    if(start<=0){
      //if you run out of money, game over
      System.out.println("Thanks for playing!");
    }
  }
}
