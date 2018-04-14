/*Xuanpu Zhang
 * 9/23/2017
 * chevalierpg@brandeis.edu
 * This class check a person's birthday
 * no bugs
 */
import java.util.*;
public class Birthday {
	public static void main(String[] args){
		//tell the reader to input their birthday
		Scanner console= new Scanner(System.in);
		System.out.print("What month, day, and year were you born? ");
		int month=console.nextInt();
		int day=console.nextInt();
		int year=console.nextInt();
		//using the object in TeacherDate class
		TeacherDate today = new TeacherDate();
		TeacherDate date = new TeacherDate(year, month, day);
		System.out.println("You were born on "+date.toString()+", which was a "+date.getDayOfWeek());
		//check the reader's birthday if it is in a leap year
		if(date.isLeapYear()){
			System.out.println(date.getYear()+" was a leap year.");
		}
		//check if today is the reader's birthday
		if(date.getMonth()==today.getMonth() &&date.getDay()==today.getDay()){
			System.out.println("Happy birthday! You are now age "+ age(date, today));
		//calculate how many days until the reader has his or her birthday after today
		}else{
			System.out.println("It will be your birthday in "+ calcbirth(date, today)+ " days.");
		}
		// calculate how many days has the reader born
		System.out.println("You are "+ calcday(date, today)+ " days old.");
	}
	public static int age(TeacherDate today, TeacherDate date){
		// get the reader's age
		return date.getYear()-today.getYear();
	}
	public static int calcbirth(TeacherDate today, TeacherDate date){
		// calculate how many days remain for the reader to have the next birthday
		TeacherDate add= new TeacherDate(today.getYear(),today.getMonth(), today.getDay());
		int days=0;
		while(add.getMonth()!= date.getMonth() || add.getDay()!= date.getDay()){
			// if it is not the reader's birthday, keep tracking
			add.nextDay();
			days++;
		}
		return days;
	}
	public static int calcday(TeacherDate date, TeacherDate today){
		// calculate how many days the reader has born
		TeacherDate add= new TeacherDate(date.getYear(), date.getMonth(), date.getDay());
		int original=0;
		while(!add.equals(today)){
			//keep tracking unless the date is today
			add.nextDay();
			original++;
		}
		return original;
	}
}
