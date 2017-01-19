package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class provides access to the data base and offers methods to interact
 * with it
 * 
 * @author Pero Grgic
 */
public class connectToDB {

	public static final String DB_URL = "jdbc:jtds:sqlserver://corpus.bfh.ch:55783";
	public static final String DB_NAME = ";DatabaseName=SWE_2026_3";
	private static final String USER_NAME = "SWE_2016_3_user";
	private static final String USER_PASS = "SWE_2016_3_$u";

	static Connection c = null;

	/**
	 * Connects to the data base
	 */
	private static void connectDB() {

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.err.println("Couldn't load driver");
		}

		try {
			c = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASS);
			System.out.println("Connection to data base successful!");
		} catch (SQLException e) {
			System.err.println("Connection to data base failed");
		}

	}

	/**
	 * Cuts connection to the data base
	 */
	private static void disconnectDB() {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				System.err.println("Couldn't disconnect!");
			}
			System.out.println("Disconnected!");
			c = null;
		}
	}

	/**
	 * Gets the motivation text of the given user name
	 * 
	 * @param userName
	 *            user name which motivation text will be returned
	 */
	public static String readMotivationTxt(String userName) {
		connectDB();
		String MotiTxt = null;
		String query = "SELECT MotivationTxt FROM Motivator WHERE UserName = '" + userName + "';";
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				MotiTxt = rs.getString("MotivationTxt");
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			System.err.println("Couldn't read motivation text!");
		}
		disconnectDB();
		return MotiTxt;
	}

	/**
	 * Inserts motivation text into the data base
	 * 
	 * @param MotivationTxt
	 *            text that will be inserted
	 * @param userName
	 *            user where the text will be inserted
	 */
	public static void writeMotivationText(String MotivationTxt, String userName) {
		connectDB();

		String query = "UPDATE Motivator SET MotivationTxt = '" + MotivationTxt + "' WHERE UserName = '" + userName
				+ "';";

		try {
			Statement st = c.createStatement();
			st.executeUpdate(query);
			st.close();
		} catch (SQLException e) {
			System.err.println("Couldn't insert motivation text!");
		}
		disconnectDB();
	}

	/**
	 * Checks if the user name and the password are correct
	 * 
	 * @param userName
	 *            user name which will be checked
	 * @param userPass
	 *            password which will be checked
	 * @return returns true if user name and password are correct else false
	 */
	public static boolean checkAuthen(String userName, String userPass) {
		connectDB();
		boolean check = false;
		String query = "SELECT UserName, Password FROM Person WHERE UserName = '" + userName + "' AND Password = '"
				+ userPass + "';";
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String Username = rs.getString("UserName");
				String PW = rs.getString("Password");
				if (userName.equals(Username) && userPass.equals(PW)) {
					check = true;
				}
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnectDB();
		return check;
	}

}
