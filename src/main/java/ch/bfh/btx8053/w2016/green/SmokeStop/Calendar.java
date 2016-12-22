package ch.bfh.btx8053.w2016.green.SmokeStop;

/*
 * Represents the Calendar in the SmokeStop App
 * The user can see every day, how many goal he did
 */
public class Calendar {
	public final int day, month, year;
	public String s;
	public int i; 
	public final static int DAY_OF_WEEK = 7; 
	public final static int MONTH_OF_YEAR = 12;
	public final static int DAY_OF_YEAR = 365;
	private static final int[] LAST_DAY_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	/*
	 * Represents the day in the year
	 */
	public enum Day{
		SUNDAY(), MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	/*
	 * Represents the Month in the year
	 */
	public enum Year{
		JANUARY(), FEBRUARY(), MARCH(), APRIL, MAY(), JUNE(), JULY(), AUGUST(), SEPTEMBER(), OCTOBER(), 
		NOVEMBER(), DECEMBER();
	}
	/*
	 * For day, month and year an format dd.mm.yyy
	 */
	public Calendar(String aDate){
		day = Integer.parseInt(aDate.substring(0,2));
		month = Integer.parseInt(aDate.substring(3,5));
		year = Integer.parseInt(aDate.substring(6,10));
	}
	
/*
 * daily goals
 */
	public void setGoal(String s){
	this.s = s; 
	}
	

/*
 * Specifies daily goals
 */
	public void setDailyGoal(int i){
	this.i = i;
	}
	
	
}
