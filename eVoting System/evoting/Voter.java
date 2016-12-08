package evoting;

import java.util.Scanner;

public class Voter {

	private String voterName;
	private String voterID;

	boolean isLoggedIn = false;

	Candidate chosenCandidate = new Candidate();

	public Voter(String voterID) {
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

	private void setVoterID(String voterID) {
		this.voterID = voterID;
	}

	private void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	private String getvoterID() {
		return this.voterID;
	}

	private String getVoterName() {
		return this.voterName;
	}
}