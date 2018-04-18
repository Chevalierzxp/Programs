import java.util.*;
public class Problem3{
  public static void main(String[ ] args){
    System.out.println("This program plays a game of reverse hangman.");
    System.out.println("You think up a word and I'll try to guess the letters.");
    System.out.println(" ");
    Scanner console=new Scanner(System.in);
    System.out.print("How many letters are in your word? ");
    int length=console.nextInt();
    System.out.print("Please enter the word for me to guess: ");
    String word=console.next();
    start(length, word);
  }
  public static void start(int length, String word){
    for(int i=1; i<=length; i++){
      System.out.print("_");
    }
    System.out.println();
    System.out.println("+--+");
    System.out.println("|  |");
    int j=1;
    while(j<=4){
      System.out.println("|");
      j=j+1;
    }
    System.out.println("+-----");
    System.out.println();
    int a=0;
    int all=0;
    String c;
    for(int d=0;d<=length;d++){
      c=c+"_";
    }
    while(all<=6){
      System.out.println("I've got "+a+" of the "+length+" letters so far");
      Random rand= new Random();
      char guess=(char)(rand.nextInt(26)+65);
      System.out.println("I guess: "+guess);
      Scanner console=new Scanner(System.in);
      System.out.print("Is that letter in the word? ");
      String answer=console.next();
      char answer1=answer.charAt(0);
      if(answer1=='y'){
        if(a!=length){
          for(int b=0; b<length;b++){
            if(guess==word.charAt(b)){
              guess=c.charAt(b)
            }else{
              
            }
          }
        }
      }
