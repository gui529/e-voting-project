package evoting;

<<<<<<< HEAD
		import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		import java.util.ArrayList;
		import java.util.Properties;
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
>>>>>>> 23ede0b6734030e503792ffb16b917a6944ddb7a

/**
		 This class instantiates our voting database
		 */

//Code taken from DBdemo.java

<<<<<<< HEAD
		public class VotingDatabase {
		byte[] mEncryptedVoterName;
			
=======
public class VotingDatabase {
>>>>>>> 23ede0b6734030e503792ffb16b917a6944ddb7a

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "132020gui1X";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "evoting"; //added this because of SSL error

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

		conn = DriverManager.getConnection("jdbc:mysql://" + this.serverName + ":" + this.portNumber + "/" + this.dbName + "?autoReconnect=true&useSSL=false", connectionProps);

		return conn;
	}

	/**
		  * Run a SQL command which does not return a recordset:
		  * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
		  * 
		  * @throws SQLException If something goes wrong
		  */
<<<<<<< HEAD
		 public boolean executeUpdate(Connection conn, String command) throws SQLException {
		  Statement stmt = null;
		  try {
		   stmt = conn.createStatement();
		   stmt.executeUpdate(command); // This will throw a SQLException if it fails
		   return true;
		  } finally {

		   // This will run whether we throw an exception or not
		   if (stmt != null) {
		    stmt.close();
		   }
		  }
		 }

		 public void castVoteToDB(String candidate) {

		  // Connect to MySQL
		  Connection conn = null;
		  try {
		   conn = this.getConnection();
		   //System.out.println("Connected to database");
		  } catch (SQLException e) {
		   System.out.println("ERROR: Could not connect to the database");
		   e.printStackTrace();
		   return;
		  }

		  //String string = String.format("A String %s %2d", aStringVar, anIntVar);
		  String upVote = String.format("UPDATE candidate SET TALLY = TALLY + 1 WHERE CANDIDATE_NAME = \"%s\"", candidate);

		  getTally();
		  try {
		   this.executeUpdate(conn, upVote);
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  updateCandidateChosen();
		 }
		 
		 
		/* public void EncryptData(String name,  PublicKey pubkey){
			 Connection conn = null;
			 cipher.generateKey();
			 try{
				 conn = this.getConnection();				 
			 }catch(SQLException e){
				 e.printStackTrace();
			 }
			 String query = String.format("UPDATE voter SET %s WHERE VOTER_ID = \'5639422\'", cipher.encrypt(name, )
		 }*/
		 
		 

		 public void updateHasVoted(String voterID) {
		  Connection conn = null;
		  try {
		   conn = this.getConnection();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  String query = String.format("UPDATE voter SET HAS_VOTED=1 WHERE VOTER_ID = %s", voterID);

		  try {
		   Statement st = conn.createStatement();
		 st.executeUpdate(query);
		   
		   // updateCandidateChosen(voterID);

		   // rs.next();


		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  /*
		   * 
		  String candidate = VotingDriver.chosenCandidate.getName();
		  query = String.format("UPDATE voter SET CANDIDATE_PICKED=\"%s\" WHERE VOTER_ID = \"%s\"", candidate,voterID);

		  try {
		   Statement st = conn.createStatement();
		   st.executeUpdate(query);
		   // rs.next();


		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
*/

		 }

		 public void updateCandidateChosen() {
		  Connection conn = null;
		  String voterID = VotingDriver.voterID;
		  try {
		   conn = this.getConnection();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  String candidate = VotingDriver.chosenCandidate.getName();
		  //System.out.println(candidate);
		  String query = String.format("UPDATE voter SET CANDIDATE_PICKED=\"%s\" WHERE VOTER_ID = %s", candidate, voterID);
=======
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public void castVoteToDB(String candidate) {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch(SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		String upVote = String.format("UPDATE candidate SET TALLY = TALLY + 1 WHERE CANDIDATE_NAME = \"%s\"", candidate);

		getTally();
		try {
			this.executeUpdate(conn, upVote);
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateCandidateChosen();
	}

	public void updateHasVoted(String voterID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		String query = String.format("UPDATE voter SET HAS_VOTED=1 WHERE VOTER_ID = %s", voterID);

		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCandidateChosen() {
		Connection conn = null;
		String voterID = VotingDriver.voterID;
		try {
			conn = this.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		String candidate = VotingDriver.chosenCandidate.getName();
		String query = String.format("UPDATE voter SET CANDIDATE_PICKED=\"%s\" WHERE VOTER_ID = %s", candidate, voterID);

		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getTally() {
		String tally = null;
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
>>>>>>> 23ede0b6734030e503792ffb16b917a6944ddb7a

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

			tally = String.format("Tally of Candidates: \n[%s: %d] \n[%s: %d]\n", candidate1, votes1, candidate2, votes2);

			st.close();

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tally;

<<<<<<< HEAD
		  try {
		   Statement st = conn.createStatement();
		   ResultSet rs = st.executeQuery(query);
		

		   rs.next();
		   

		   String candidate1 = rs.getString("CANDIDATE_NAME");
	
		   int votes1 = rs.getInt("TALLY");
		   rs.next();
		   String candidate2 = rs.getString("CANDIDATE_NAME");
		   int votes2 = rs.getInt("TALLY");
=======
	}

	public boolean validateVoter(String voterID, String voterlast4, String voterlastName) throws SQLException {
		Connection conn = null;
		conn = this.getConnection();

		String query = String.format("SELECT count(VOTER_NAME) FROM voter WHERE LAST_4_SOCIAL = %s AND VOTER_ID = %s AND HAS_VOTED = %s AND VOTER_NAME = \"%s\"", voterlast4, voterID, 0, voterlastName);
>>>>>>> 23ede0b6734030e503792ffb16b917a6944ddb7a

		try {
			Statement sts = conn.createStatement();

			ResultSet rs = sts.executeQuery(query);

			rs.next();

			String numberFound = rs.getString("count(VOTER_NAME)");

			if (numberFound.equals("1")) {
				updateHasVoted(voterID);

				return true;
			} else {
				return false;

			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// Validating the admin username and password

	public boolean validateAdmin(String adminID, String adminPassword) throws SQLException {
		Connection conn = null;
		conn = this.getConnection();

		String query = String.format("SELECT count(ADMIN_ID) FROM admin WHERE ADMIN_PASSWORD = \"%s\" AND ADMIN_ID = \"%s\"", adminPassword, adminID);

		try {
			Statement sts = conn.createStatement();

			ResultSet rs = sts.executeQuery(query);

			rs.next();

			String numberFound = rs.getString("count(ADMIN_ID)");
			//java.sql.ResultSetMetaData rsmdd = rs.getMetaData();

			if (numberFound.equals("1")) {

				return true;
			} else {
				return false;

			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList < Voter > getList() throws SQLException {

		ArrayList < Voter > voterList = new ArrayList < Voter > ();

		Connection conn = null;
		try {
			conn = this.getConnection();
			//Statement st = conn.createStatement();

		} catch(SQLException e) {
			e.printStackTrace();
		}

		Statement st = conn.createStatement();

		ResultSet srs = st.executeQuery("SELECT * FROM voter WHERE HAS_VOTED=1;");

		while (srs.next()) {
			Voter voter = new Voter();
			voter.setVoterID(srs.getString("VOTER_ID"));
			voter.setVotedFor(srs.getString("CANDIDATE_PICKED"));
			voterList.add(voter);
		}
		return voterList;
	}

<<<<<<< HEAD

		   rs.next();

		   String numberFound = rs.getString("count(ADMIN_ID)");
		   java.sql.ResultSetMetaData rsmdd = rs.getMetaData();

		   if (numberFound.equals("1")) {

		    return true;
		   } else {
		    return false;

		   }
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }

		  return false;
		 }


		 public ArrayList < Voter > getList() throws SQLException {

		  ArrayList < Voter > voterList = new ArrayList < Voter > ();

		  Connection conn = null;
		  try {
		   conn = this.getConnection();
		   //Statement st = conn.createStatement();


		  } catch (SQLException e) {
		   e.printStackTrace();
		  }

		  Statement st = conn.createStatement();

		  ResultSet srs = st.executeQuery("SELECT * FROM voter WHERE HAS_VOTED=1;");


		  // Connection conn = DriverManager.getConnection(url, "root", "admin");
		  //Statement st = conn.createStatement();
		  //ResultSet srs = st.executeQuery("SELECT * FROM person");
		  while (srs.next()) {
		   Voter voter = new Voter();
		   voter.setVoterID(srs.getString("VOTER_ID"));
		   voter.setVotedFor(srs.getString("CANDIDATE_PICKED"));
		   voterList.add(voter);
		  }


		  return voterList;
		 }


		 public void EncryptDB() throws SQLException{
			 Connection conn = null;
			 CryptoTool.generateKey();
			 System.out.println(CryptoTool.areKeysPresent());

			
//			File pb = new File(CryptoTool.PUBLIC_KEY_FILE);
//			 final PublicKey publicKey = (PublicKey) pb;
			 
			 ObjectInputStream inputStream = null;

		      // Encrypt the string using the public key
		      try {
				inputStream = new ObjectInputStream(new FileInputStream(CryptoTool.PUBLIC_KEY_FILE));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
		      
		      PublicKey publicKey = null;
			try {
				publicKey = (PublicKey) inputStream.readObject();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
		      //TESTING
			 //String cryptTest = ("hi its joe");
			 //final byte[] cipherText = CryptoTool.encrypt(cryptTest, publicKey);
			// System.out.println(cipherText);
			  try {
			   conn = this.getConnection();
			  } catch (SQLException e) {
				   e.printStackTrace();
				  }
			  Statement st = conn.createStatement();

			  ResultSet rs = st.executeQuery("SELECT VOTER_NAME FROM voter;");
			  while (rs.next()) {
				  String voterName = rs.getString("VOTER_NAME");
				  //System.out.print(voterName + "\n");
				  Statement st2 = conn.createStatement();
				  
				  mEncryptedVoterName = CryptoTool.encrypt(voterName, publicKey);
				 //String EVN = new String (encryptedVoterName);
				
				  String Updatequery = String.format("UPDATE voter SET VOTER_NAME= \"%s\" WHERE VOTER_NAME = \'%s\'", mEncryptedVoterName, voterName);
				  st2.executeUpdate(Updatequery);
				  //System.out.println(voterName + "change to rs2");
					
				}
		 }
		 
		 
		 public void DecryptDB() throws SQLException{
			 Connection conn = null;
			 CryptoTool.generateKey();
			 
			 ObjectInputStream inputStream = null;

		      // Encrypt the string using the public key
		      try {
				inputStream = new ObjectInputStream(new FileInputStream(CryptoTool.PRIVATE_KEY_FILE));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
		      
		      PrivateKey privateKey = null;
			try {
				privateKey = (PrivateKey) inputStream.readObject();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				   conn = this.getConnection();
				  } catch (SQLException e) {
					   e.printStackTrace();
					  }
				  Statement st = conn.createStatement();
				
				  ResultSet rs = st.executeQuery("SELECT VOTER_NAME FROM voter;");
				  while (rs.next()) {
					  String voterName =  rs.getString("VOTER_NAME");
					 // byte [] encryptedVoterName;
					  mEncryptedVoterName = voterName.getBytes();
					  
					  
					  System.out.print(voterName + "\n");
					  Statement st2 = conn.createStatement();
					  
					 String decryptedVoterNames = CryptoTool.decrypt(mEncryptedVoterName, privateKey);
					 // String EVN = new String (encryptedVoterName);
					
					  String Updatequery = String.format("UPDATE voter SET VOTER_NAME= \"%s\" WHERE VOTER_NAME = \'%s\'",decryptedVoterNames, voterName);
					  st2.executeUpdate(Updatequery);
					  System.out.println(voterName + "change to rs2");
					}
			 
			 
		 }



		 /**
=======
	/**
>>>>>>> 23ede0b6734030e503792ffb16b917a6944ddb7a
		  * Connect to MySQL, create our tables, and store our votes
		  */
	public void run() {

		// Connect to MySQL

	}

	/**
		  * Connect to the DB and do some stuff
		  * @throws SQLException 
		  */
	public static void main(String[] args) throws SQLException {
		//VotingDatabase app = new VotingDatabase();
		//app.run();

	}

}