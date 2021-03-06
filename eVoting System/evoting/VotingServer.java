package evoting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class VotingServer {
	int maxSize = 4;

	VotingDatabase db = new VotingDatabase();
	BufferedReader br;
	String[] voterInfo = new String[4];
	String[] adminInfo = new String[4];

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
	public boolean validateAdminLogin(String adminID, String adminPass) throws SQLException {

		return (db.validateAdmin(adminID, adminPass));

	}
}