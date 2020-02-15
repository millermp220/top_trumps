package commandline;
/** 
 * Calculates the maximum number of rounds played in single game
 * @author Rebecca Dinneen
 *<br> <br>
 *
 *  */

import java.sql.*;

public class mostRounds {
	
	/**Method establishes database connection to PostgreSQL server
	 *@param url specifies location of database server and database name
	 *@param username database user name
	 *@param password database password
	 *@return Connection object
	 *@throws java.sql.SQLException
	 * */
	
	private final String url = "jdbc:postgresql://localhost:5432/TopTrumps3";
	private final String username = "postgres";
	private final String password = "bex182";
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url, username, password);	
	}
	
	/**Method selects the no_rounds column from 'Games' table
	 * @param rs ResultSet object represents database result set returned after query executed
	 *@returns count largest integer in column 
	 *@throws java.sql.SQLException */
	
	public int countRounds() {
		
		//String stores SQL query
		String SQL = "SELECT MAX (no_rounds) FROM GAMES";
		
		int count = 0; //Stores results of query
		
		try (Connection conn = connect(); //Create Connection object
			Statement stmt = conn.createStatement(); //Statement object created from Connection object, Statement object represents SQL query
			ResultSet rs = stmt.executeQuery(SQL)) { //Statement object executed to get ResultSet object
			rs.next();								//next() method of ResultSet moves pointer to next row (1st row) from initial position (0)
			count = rs.getInt(1);					//Gets the value from ResultSet 
		}catch (SQLException e) {
			System.out.println(e.getMessage()); //Gets the JDBC driver's error message for an error handled by driver or Oracle error number and message for database error
		}
		return count;
	}
	
	public static void main(String [] args) {
		
		mostRounds mr = new mostRounds(); //Create instance of class
		int maxRounds = mr.countRounds(); //Instantiates countRounds method, stores in maxRounds
		
		System.out.println(String.format("%d : most rounds in a game", maxRounds));
		
	}

}