
package evoting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Candidate {

	private String candidateName;
	private String candidateParty;
	private int numberOfVotes;
	FileWriter myWriter;



	public void setName(String candidateName) {
		this.candidateName = candidateName;
	}



	public void setParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}

	public String getName() {
		return candidateName;
	}

	public String getParty() {
		return candidateParty;
	}
	
	public void addVote(){
		numberOfVotes++;
		

		
		
	}
	
	
	public int getVotes(){
		return numberOfVotes;
	}

}