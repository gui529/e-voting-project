import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This class sets up our voting database.
 * 
 */

public class VoteDatabase {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "test?autoReconnect=true&useSSL=false"; //added this because of SSL error
	
	/** The name of the table we are testing with */
	private final String tableName = "VOTING";
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 */
	public void run() {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		// Create a table
		// Modified for question 1
		try {
		    String createString =
			        "CREATE TABLE " + this.tableName + " ( " +
			        "VOTE_ID INTEGER NOT NULL, " +
			        "VOTER_ID INTEGER NOT NULL, " +
			        "VOTED_FOR_ID INTEGER NOT NULL, " +
			        "VOTE_DOWN INTEGER NOT NULL, " +
			        "VOTE_UP INTEGER NOT NULL, " +
			        "PRIMARY KEY (VOTE_ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		
	    }
		
		// Insert into table	
		// Created for Question 2
		// Inserts 3 votes into the table 
		try {
		   String insertString = 
				    "INSERT INTO " + this.tableName + 		   
		            "(VOTE_ID, VOTER_ID, VOTED_FOR_ID, VOTE_DOWN, VOTE_UP )" + 				
		            "VALUES" +								
				    "(1, 1, 1234, 0, 1)";
		   String insertString2 = 
				    "INSERT INTO " + this.tableName + 		   
		            "(VOTE_ID, VOTER_ID, VOTED_FOR_ID, VOTE_DOWN, VOTE_UP )" + 				
		            "VALUES" +								
				    "(2, 2, 5678, 1, 0)";
		   String insertString3 = 
				    "INSERT INTO " + this.tableName + 		   
		            "(VOTE_ID, VOTER_ID, VOTED_FOR_ID, VOTE_DOWN, VOTE_UP )" + 				
		            "VALUES" +								
				    "(3, 3, 91011, 0, 1)";
		   this.executeUpdate(conn, insertString);
		   this.executeUpdate(conn, insertString2);
		   this.executeUpdate(conn, insertString3);
		   System.out.println("Inserted into table");
	     } catch (SQLException f) {
			System.out.println("ERROR: Could not insert into table");
			f.printStackTrace();
			return;
	     
	     }	
		
		
		// Display the table
		// Created for question 3
//		try {
//			String displayString = "SELECT * FROM " + this.tableName;
//			   System.out.println("Table displayed");
//			   this.executeUpdate(conn, displayString);
//		} catch (SQLException h) {
//			System.out.println("ERROR: Could not display table");
//			h.printStackTrace();
//			return;
//		}
		
		// Drop the table
		// Comment this out when you don't want your table to be deleted
		try {
		    String dropString = "DROP TABLE " + this.tableName;
			this.executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
	    } catch (SQLException g) {
			System.out.println("ERROR: Could not drop the table");
			g.printStackTrace();
			return;
	    }
	     
	
	}

	    
		
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		VoteDatabase app = new VoteDatabase();
		app.run();
	}
}

	