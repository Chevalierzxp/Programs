/*Xuanpu Zhang;
chevalierpg@brandeis.edu;
12/02/2016;
this program creates a card class.
no bugs*/
public class Card{
  int value;
  String suit;
  public Card(int value,String suit){
    //fix shadowing
    this.value=value;
    this.suit=suit;
  }
  public int getValue(){
    return value;
  }
  public String getColor(){
    //seperate Spades,Clubs,Diamonds and Hearts.
    if(suit.equals("Spades")||suit.equals("Clubs")){
      return "black";
    }else{
      return "red";
    }
  }
  public String getSuit(){
    return suit;
  }
  public String toString(){
    String card;
    //print out the card
    if(value==1){
      card="Ace of "+suit;
    }else if(value>1&&value<11){
      card=value+" of "+suit;
    }else if(value==11){
      card="Jack of "+suit;
    }else if(value==12){
      card="Queen of "+suit;
    }else{
      card="King of "+suit;
    }
    return card;
  }
}
