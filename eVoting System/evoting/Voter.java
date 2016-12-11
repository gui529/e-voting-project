package evoting;

import java.util.Scanner;

public class Voter {

	private String voterName;
	private String voterID;
	private String votedFor;

	boolean isLoggedIn = false;

	Candidate chosenCandidate = new Candidate();

	public Voter() {
		this.voterID = voterID;

		//protected int voterID;
		//private String voterName;

		/**
	 * 
	 * @param voterUserName
	 * @param voterPassword
	 */
	}
	private void login(String voterID, String name, String social) {
		this.voterName = name;
		//this.voterID = voter
		isLoggedIn = true;
	}

	/**
	 * 
	 * @param candidate
	 */
	public void castVote(Candidate candidate) {

		VotingDatabase db = new VotingDatabase();
		db.castVoteToDB(candidate.getName());

	}

	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public String getvoterID() {
		return this.voterID;
	}

	public String getVoterName() {
		return this.voterName;
	}
	public void setVotedFor(String votedFor){
		this.votedFor = votedFor;
	}
	public String getVotedFor(){
		return this.votedFor;
	}
	
}