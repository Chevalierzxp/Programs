/*Xuanpu Zhang;
chevalierpg@brandeis.edu;
12/02/2016;
this program creates a deck class.
no bugs*/
import java.util.*;
public class Deck{
  Card[]deck=new Card[52];
  Card[]a=new Card[52];
  int b=0;
  public Deck(){
    //create a deck
    for(int i=0; i<52; i++){
      if(i<13){
        Card ca=new Card(i+1,"Hearts");
        deck[i]=ca;
      }else if(i>=13 && i<26){
        Card ca=new Card(i+1,"Diamonds");
        deck[i]=ca;
      }else if(i>=26 && i<39){
        Card ca=new Card(i+1,"Spades");
        deck[i]=ca;
      }else if(i>=39 && i<52){
        Card ca=new Card(i+1,"Clubs");
        deck[i]=ca;
      }
    }
    shuffle();
  }
  public String toString(){
    //print the card
    return Arrays.deepToString(deck);
  }
  public void shuffle(){
    //shuffle the cards
    Random rand=new Random();
    for(int i=0;i<(52-b);i++){
      int m=rand.nextInt(52-b);
      int n=rand.nextInt(52-b);
      Card temp=deck[m];
      deck[m]=deck[n];
      deck[n]=temp;
    }
  }
  public Card drawNextCard(){
    //give you nect card
    if(b>51){
      //if you take all the cards, then shuffle
      deck=a;
      a=new Card[52];
      shuffle();
    }
    return deck[b];
  }
  public void discard(Card c){
    //put the card to the discard pile
    c=a[b];
    b++;
  }
}
