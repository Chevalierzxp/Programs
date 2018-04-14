/*Xuanpu Zhang
 * 9/23/2017
 * chevalierpg@brandeis.edu
 * This class calculate the date
 * no bugs
 */
import java.util.*;
public class Date {
	private int year=1970;
	private int month=1;
	private int day=1;
	public Date(int year, int month, int day){
		this.year=year;
		this.month=month;
		this.day=day;
	}
	public Date(){
		int daysSinceEpoch = TeacherDate.getDaysSinceEpoch();
		for(int i=0; i<daysSinceEpoch; i++){
			// from 1970/1/1, keep tracking the next day
			this.nextDay();
		}
	}
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
	public String toString(){
		return this.year+"/"+this.month+"/"+this.day;
	}
	public boolean equals(Object o){
		if(o instanceof Date){
			//check if the given date is equals to this date
			Date other=(Date)o;
			return this.year == other.year && this.month == other.month && this.day == other.day; 
		}else{
			return false;
		}
	}
	public boolean isLeapYear(){
		// check if this year is a leap year
		if(year%4==0){
			if(year%100==0 && year%400!=0){
				return false;
			}else if(year%100==0 && year%400==0){
				return true;
			}else{
				return true;
		    }
		}else{
			return false;
		}
	}
	public void nextDay(){
		//calculate the next day of the date
		if(this.day < numberofdays()){
			this.day++;
		}
		else if(this.day == numberofdays()){
			this.day=1;
			if(this.month == 12){
				this.month=1;
				this.year++;
			}
			else{
				this.month++;
			}
		}
	}
	public int numberofdays(){
		// list all the months in a year
		int month=this.month;
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			return 31;
		}
		else if(month==2 && isLeapYear()){
			return 29;
		}
		else if(month==2 && !isLeapYear()){
			return 28;
		}
		else{
			return 30;
		}
	}
	public String getDayOfWeek(){
		//get the week of the date
		Date know= new Date(1753,1,1);
		// set the original date first
		Date today=new Date(this.year, this.month, this.day);
		int days=0;
		while(!know.equals(today)){
			know.nextDay();
			days++;
			// keep adding the date until it is today
		}
		if(days%7==0){
			return "Monday";
		}
		else if(days%7==1){
			return "Tuesday";
		}
		else if(days%7==2){
			return "Wednesday";
		}
		else if(days%7==3){
			return "Thursday";
		}
		else if(days%7==4){
			return "Friday";
		}
		else if(days%7==5){
			return "Saturday";
		}
		else{
			return "Sunday";
		}
	}
}
