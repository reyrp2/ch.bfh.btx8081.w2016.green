package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.util.Date;

/**
 * Represents a user of the SmockeStop App.
 */
public class Person_class {

	private String name;
	private String FirstName;
	private Date BirthDate;
	private String userName;
	private String passWord;
	public int howLongSmocking;

	/**
	 * Creates a new Person with the given name,FirstName,Birth date, user name,
	 * password and smocking experience duration.
	 */
	public Person_class(String name, String FirstName, Date BirthDate, String userName, String password, int howLongSmoking) {
	}
	/** Name getter
	 */
	private String getName() {
		return name;
	} 
/** Name setter
	 */
	private void setName(String name) {
		this.name = name;
	}
/** FirstName getter
	 */
	private String getFristName() {
		return FirstName;
	}
/** FirstName setter
	 */
	private void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
/** BirthDate getter
	 */
	private Date getBirthDate() {
		return BirthDate;
	}
/** BirthDate setter
	 */
	private void setBirthDate(Date BirthDate) {
		this.BirthDate = BirthDate;
	}
/** userName getter
	 */
	private String getUserName() {
		return userName;
	}
/** userName setter
	 */
	private void setUserName(String userName) {
		this.userName = userName;
	}
/** smockig experience duration getter
	 */
	public int getHowLongSmocking() {
		return howLongSmocking;
	}
/** smocking experience duration setter
	 */
	public void setHowLongSmocking(int howLongSmocking) {
		this.howLongSmocking = howLongSmocking;
	}
}
