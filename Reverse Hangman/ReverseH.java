/*Xuanpu Zhang;
chevalierpg@brandeis.edu;
11/02/2016;
this program plays a game of reverse hangman.
no bugs*/
import java.util.*;
public class ReverseH{
  public static void main(String[ ] args){
    System.out.println("This program plays a game of reverse hangman.");
    System.out.println("You think up a word and I'll try to guess the letters.");
    System.out.println(" ");
    Scanner console=new Scanner(System.in);
    //Let the player think of the number of letters in the word
    System.out.print("How many letters are in your word? ");
    int length=console.nextInt();
    //Let the player think of a word
    System.out.print("Please enter the word for me to guess: ");
    String word=console.next();
    start(length, word);
  }
  public static void start(int length, String word){
    //print the initial image of the hangman
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
    //Create a string contain the "_"
    String c="";
    for(int d=0;d<length;d++){
      c=c+"_";
    }
    //Create a String that store the letters the computer guesses
    String g="";
    while(all<=6 && a!=length){
    System.out.println("I've got "+a+" of the "+length+" letters so far");
    Random rand= new Random();
    //Let the computer guess letters between A-Z
    char guess=(char)(rand.nextInt(26)+65);
    g=g+guess;
    //Check if the computer has guessed the same letter, if so, change another letter
    for(int e=0;e<g.length();e++){
      if(guess==g.charAt(e)){
        guess=(char)(rand.nextInt(26)+65);
      }else{
        guess=guess;
      }
    }
    System.out.println("I guess: "+guess);
    Scanner console=new Scanner(System.in);
    System.out.print("Is that letter in the word? ");
    String answer=console.next();
    char answer1=answer.charAt(0);
    //If the computer guess right, put the letter into the image
    if(answer1=='y'){
      if(a!=length){
        for(int b=0; b<length;b++){
          if(guess==word.charAt(b)){
              String x=c.substring(0,b);
              String y=c.substring(b+1);
              c=x+guess+y;
              a=a+1;
          }else{
            c=c;
          }
        }
        System.out.println(c);
        //The image that the computer guess wrong 0 time
        if(all==0){
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          int n=1;
          while(n<=4){
            System.out.println("|");
            n=n+1;
          }
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 1 time
        }else if(all==1){
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          int o=1;
          while(o<=3){
            System.out.println("|");
            o=o+1;
          }
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 2 times
        }else if(all==2){
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |");
          int p=1;
          while(p<=2){
            System.out.println("|");
            p=p+1;
          }
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 3 times
        }else if(all==3){
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |");
          System.out.println("|   \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 4 times
        }else if(all==4){
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |");
          System.out.println("| / \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 5 times
        }else if(all==5){
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |\\");
          System.out.println("| / \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 6 times
        }else if(all==6){
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("| /|\\");
          System.out.println("| / \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
        }
      }else if(a==length){
        //If the compter find out the whole word
        System.out.println("I win!");
      }
      //If the computer guess wrong
    }else if(answer1=='n'){
      all=all+1;
      //The image that the computer guess wrong 1 time
        if(all==1){
          System.out.println(c);
          System.out.println(" ");
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          int m=1;
          while(m<=3){
            System.out.println("|");
            m=m+1;
          }
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 2 times
        }else if(all==2){
          System.out.println(c);
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |");
          int q=1;
          while(q<=2){
            System.out.println("|");
            q=q+1;
          }
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 3 times
        }else if(all==3){
          System.out.println(c);
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |");
          System.out.println("|   \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 4 times
        }else if(all==4){
          System.out.println(c);
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |");
          System.out.println("| / \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 5 times
        }else if(all==5){
          System.out.println(c);
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("|  |\\");
          System.out.println("| / \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
          //The image that the computer guess wrong 6 times
        }else if(all==6){
          System.out.println(c);
          System.out.println();
          System.out.println("+--+");
          System.out.println("|  |");
          System.out.println("|  O");
          System.out.println("| /|\\");
          System.out.println("| / \\");
          System.out.println("|");
          System.out.println("+-----");
          System.out.println();
        }
      }
}
//If the computer does not guess the word and runs out chance to guess
System.out.println("You beat me this time.");
}
}
