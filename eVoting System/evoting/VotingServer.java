

package evoting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class VotingServer {
	int maxSize = 4;

	BufferedReader br;
	private int voterID;
	private int[] officialTally = new int[8];
	String[] voterInfo = new String [4];

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
	 */
	public boolean validateLogin(String voterID, String name, String social) throws FileNotFoundException, IOException {
		try{
			
		boolean done = false;
		br = new BufferedReader(new FileReader("registrationList.txt")); 
		    
		String line;// = br.readLine();

		while ((line = br.readLine()) != null){
	       // line = br.readLine();
	        
		    StringTokenizer st = new StringTokenizer(line);
		    int i =0;
		    while(st.hasMoreTokens()){
		    	voterInfo[i] = st.nextToken(); 
		    	i++;
		    	
		    }

		    if (voterInfo[3].contains(voterID) && voterInfo[1].contains(name) && voterInfo[2].contains(social)  ){
		    	return true;
		    }
			
		}
		    
		    
		    

		    
		    
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		return false;
		
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