package evoting;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 This class instantiates our voting database
 */

public class VotingDatabase extends VotingDriver{

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

		// Create Voter table
		
		try {
		    String createString =
			        "CREATE TABLE " + "Voter" + " ( " +
			        "VOTER_ID INTEGER NOT NULL, " +
			        "LAST_NAME INTEGER NOT NULL, " +
			        "LAST_4_SOCIAL INTEGER NOT NULL,";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		
	    }
		
		// Insert into table Voter	
		
		// Inserts 3 votes into the table 
		try {
		   String insertString = 
				    "INSERT INTO Voter" + 		   
		            "(NAME, VOTER_ID , SOCIAL)" + 				
		            "VALUES" +								
				    "(John Smith, 123, 458488457)"; 
//		   String insertString2 = 
//				    "INSERT INTO " + this.tableName + 		   
//		            "(VOTE_ID, VOTER_ID, VOTED_FOR_ID, VOTE_DOWN, VOTE_UP )" + 				
//		            "VALUES" +								
//				    "(2, 2, 5678, 1, 0)";
//		   String insertString3 = 
//				    "INSERT INTO " + this.tableName + 		   
//		            "(VOTE_ID, VOTER_ID, VOTED_FOR_ID, VOTE_DOWN, VOTE_UP )" + 				
//		            "VALUES" +								
//				    "(3, 3, 91011, 0, 1)";
		   this.executeUpdate(conn, insertString);
//		   this.executeUpdate(conn, insertString2);
//		   this.executeUpdate(conn, insertString3);
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
		VotingDatabase app = new VotingDatabase();
		app.run();
	}
}

	
