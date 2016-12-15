package ch.bfh.btx8053.w2016.green.SmokeStop;

/* represents the Goal defining class
*/
public class Goals {
	public int goals;
	public int dailyGoals;
/*
 * constructor to initialise the instant variables.
 */
	public Goals(int goals, int dailyGoals) {
		this.goals = goals;
		this.dailyGoals = dailyGoals;

	}
/*
 *  Gets the goals set.
 */
	public int getGoals() {
		return goals;
	}
/*
 * Getts the daily goals set.
 */
	public int getDailyGoals() {
		return dailyGoals;
	}
/*
 * Sets new goals
 */
	public void setGoals(int goals) {
		this.goals = goals;
	}
/*
 * Sets new daily goals
 */
	public void setDailyGoals(int dailyGoals) {
		this.dailyGoals = dailyGoals;
	}
}
