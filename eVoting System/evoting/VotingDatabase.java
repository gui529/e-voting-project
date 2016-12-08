package evoting;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.DatabaseMetaData;

/**
 This class instantiates our voting database
 */

//Code taken from DBdemo.java

public class VotingDatabase {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "murach"; //added this because of SSL error
	

	
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
	
	public void castVoteToDB(String candidate){

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
		
		//String string = String.format("A String %s %2d", aStringVar, anIntVar);
		String upVote = String.format("UPDATE candidate SET TALLY = TALLY + 1 WHERE CANDIDATE_NAME = '%s'",candidate);
		
		getTally();
		try {
			this.executeUpdate(conn, upVote);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getTally(){
		String tally = null;
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return null;
		}
		
	      String query = "SELECT * FROM candidate";

	      try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);

		      
		    rs.next();
		    
		    
		    String candidate1 = rs.getString("CANDIDATE_NAME");
	        int votes1 = rs.getInt("TALLY");
		    rs.next();
		    String candidate2 = rs.getString("CANDIDATE_NAME");
	        int votes2 = rs.getInt("TALLY");
	        
	        
			tally = String.format("Tally Candidates: \n%s: %d \n%s:%d\n",candidate1,votes1,candidate2,votes2 );

	        st.close();

		      
		      
		      
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tally;
		
		
	}

		
	
	
	
	

	
	/**
	 * Connect to MySQL, create our tables, and store our votes
	 */
	public void run() {

		// Connect to MySQL
		Connection conn = null;
		
			
	}

	    
		
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		VotingDatabase app = new VotingDatabase();
		app.run();
	}
}

	
