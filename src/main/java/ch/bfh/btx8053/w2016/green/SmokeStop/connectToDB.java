package ch.bfh.btx8053.w2016.green.SmokeStop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class connectToDB {

	public static final String DBMS_URL = "corpus.bfh.ch:55783";
	public static final String DB_NAME = "SWE_2026_3";
	private static final String USER_NAME = "SWE_2016_3_user";
	private static final String USER_PASS = "SWE_2016_3_$u";
	private Connection connection = null;
	// insert, select, update delete

	private void connectDBMS() throws ClassNotFoundException, SQLException {
		// 1 the translator, load the driver - required for all drivers before
		// version 4.0
		Class.forName("net.sourceforge.jtds.jdbc.Driver");

		connection = DriverManager.getConnection(getJdbcUrl(), USER_NAME, USER_PASS);

		System.out.println("Connection to MS SQL DB successful!");

	}

	public void disconnectDBMS() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

	private String getJdbcUrl() {
		return "jdbc:jtds:sqlserver://" + DBMS_URL + ";DatabaseName=" + DB_NAME;
	}

	public void readGoals() throws SQLException {
		// 3. creating statement object
		Statement statement = connection.createStatement();

		// 4. executing the query

		String query = "SELECT dbo.BigGoal, dbo.DailyGoal " + "FROM " + DB_NAME + ".dbo.Goals "
				+ "ORDER BY BigGoal, DailyGoal;";

		ResultSet rs = statement.executeQuery(query);

		System.out.println("readGoals()");
		System.out.println("BigGoal, DailyGoal");
		System.out.println("---------\t---------------");

		// displaying the result set, one tuple per line
		while (rs.next()) {
			System.out.println(String.format("%d\t%s, %s", rs.getDate(1), rs.getInt(2)));
		}

		// close result set and statement
		rs.close();
		statement.close();
	}
	public void updateTable(String UserName, Date newBigGaol, int newDailyGoal) throws SQLException {
		// creating statement object
		Statement statement = connection.createStatement();

		// executing the query
		String query = " UPDATE TABLE dob.Goals SET BigGoal = newBigGoal;";
	
		ResultSet rs = statement.executeQuery(query);

		// close result set and statement
		rs.close();
		statement.close();
	}
/*
 * Inserts new data into the DB table.
 */
	public void insertNewValue(Date newBigGoal, int newDailyGoal) throws SQLException {
		// creating statement object
		Statement statement = connection.createStatement();

		// executing the query
		String query = " INSERT INTO   dob.Goals VALUES(newBigGoal,newDailyGoal);";

		ResultSet rs = statement.executeQuery(query);
		// close result set and statement
		rs.close();
		statement.close();
	}


}
