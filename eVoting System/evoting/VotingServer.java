package evoting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class VotingServer {
	int maxSize = 4;

	VotingDatabase db = new VotingDatabase();
	BufferedReader br;
	private int voterID;
	private int[] officialTally = new int[8];
	String[] voterInfo = new String[4];
	String[] adminInfo = new String[4];

	protected void getTally() {
		throw new UnsupportedOperationException();
	}

	protected void getNumRegisteredVoters() {
		throw new UnsupportedOperationException();
	}

	protected void getNumTotatlVotes() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param voterID
	 * @param lastName
	 * @param social
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public boolean validateLogin(String voterID, String name, String social) throws FileNotFoundException,
	IOException, SQLException {
		
		if (voterID.equals("") || name.equals("") || social.equals("")){
			
			return false;
		}
		
			return (db.validateVoter(voterID, social, name));
			//  Auto-generated catch block
		
		
	}

	//The following validates the Admin's Login
	public boolean validateAdminLogin(String adminID, String adminPass) throws SQLException{

		return (db.validateAdmin(adminID, adminPass));

	}

	/**
	 * 
	 * @param voterUserName
	 * @param VoterPassword
	 */

	protected void displayCandidate() {
		throw new UnsupportedOperationException();
	}

	protected void displayLoginErrorMessage() {
		throw new UnsupportedOperationException();
	}

	protected void displayVoterToVotesRatio() {
		throw new UnsupportedOperationException();
	}

	private void displayUnofficialTally() {
		throw new UnsupportedOperationException();
	}

	private void addVoteToTally() {
		throw new UnsupportedOperationException();
	}

	protected void updateResult() {
		throw new UnsupportedOperationException();
	}

	private void printConfirmation() {
		throw new UnsupportedOperationException();
	}

}