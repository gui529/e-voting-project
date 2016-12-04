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

public class VotingDatabase {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "voting?autoReconnect=true&useSSL=false"; //added this because of SSL error
	
	/** The name of the table we are testing with */
	private final String tableName = "Voter";
	
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
		    String createVoter =
			        "CREATE TABLE IF NOT EXISTS " + "Voter" + "(" +
			        "NAME VARCHAR(50), " +
			        "LAST_4_SOCIAL INTEGER NOT NULL, " +
			        "VOTER_ID INTEGER NOT NULL)";
			this.executeUpdate(conn, createVoter);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		
	    }
		
		// Create Candidate table
		try {
		    String createCandidate =
			        "CREATE TABLE IF NOT EXISTS " + "Candidate" + "(" +
			        "NAME VARCHAR(50))";
			this.executeUpdate(conn, createCandidate);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		
	    }
		
		
		
		// Inserts votes into the Voter table 
		try {
		   String insertVoter1 = 
				    "INSERT INTO Voter " + 		   
		            "(NAME, LAST_4_SOCIAL, VOTER_ID) " + 				
		            "VALUES " +								
				    "('Diane Verville', 4533, 768342)"; 
		   String insertVoter2 = 
				    "INSERT INTO Voter " + 		   
		            "(NAME, LAST_4_SOCIAL, VOTER_ID) " + 				
		            "VALUES " +								
				    "('Nadia Lozier', 6421, 492342)";
		   String insertVoter3 = 
				    "INSERT INTO Voter " + 		   
		            "(NAME, LAST_4_SOCIAL, VOTER_ID) " + 				
		            "VALUES " +								
				    "('Lemuel Mosbey', 1356, 134233)";
		   String insertVoter4 = 
				    "INSERT INTO Voter " + 		   
		            "(NAME, LAST_4_SOCIAL, VOTER_ID) " + 				
		            "VALUES " +								
				    "('Stacee Shuler', 9034, 6323494)";
		   this.executeUpdate(conn, insertVoter1);
		   this.executeUpdate(conn, insertVoter2);
		   this.executeUpdate(conn, insertVoter3);
		   this.executeUpdate(conn, insertVoter4);
		   System.out.println("Inserted into Voter table");
	     } catch (SQLException f) {
			System.out.println("ERROR: Could not insert into table");
			f.printStackTrace();
			return;
	     
	     }	
		
		// Inserts Candidates into the Candidate table 
				try {
				   String insertCandidate1 = 
						    "INSERT INTO Candidate " + 		   
				            "(NAME) " + 				
				            "VALUES " +								
						    "('Henry Brown')"; 
				   String insertCandidate2 = 
						    "INSERT INTO Candidate " + 		   
				            "(NAME) " + 				
				            "VALUES " +								
						    "('Joyce Smalls')";
				   this.executeUpdate(conn, insertCandidate1);
				   this.executeUpdate(conn, insertCandidate2);
			
				   System.out.println("Inserted into Candidate table");
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
//		try {
//		    String dropString = "DROP TABLE " + this.tableName;
//			this.executeUpdate(conn, dropString);
//			System.out.println("Dropped the table");
//	    } catch (SQLException g) {
//			System.out.println("ERROR: Could not drop the table");
//			g.printStackTrace();
//			return;
//	    }
	     
	
	}

	    
		
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		VotingDatabase app = new VotingDatabase();
		app.run();
	}
}

	
