package evoting;

import java.sql.SQLException;

public class Voter {

	private String voterName;
	private String voterID;
	private String votedFor;

	Candidate chosenCandidate = new Candidate();

	/**
	 * 
	 * @param candidate
	 * @throws SQLException 
	 */
	public void castVote(Candidate candidate) throws SQLException {

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
	public void setVotedFor(String votedFor) {
		this.votedFor = votedFor;
	}
	public String getVotedFor() {
		return this.votedFor;
	}

}