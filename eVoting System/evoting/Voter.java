
package evoting;


public class Voter {
	
	
    private String voterName;
    private int voterID;

	public Voter(int voterID) {
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
	}

	/**
	 * 
	 * @param candidate
	 */
	public void castVote(Candidate candidate) {
		throw new UnsupportedOperationException();
	}

	public String writeIn(String candidateName) {
		throw new UnsupportedOperationException();
	}

	private void editVote() {
		throw new UnsupportedOperationException();
	}

	private void confirmVote() {
		throw new UnsupportedOperationException();
	}

	public void printConfirmation() {
		System.out.printf("Thank you, you have voting");
		
	}

	private void setVoterID(int voterID) {
		this.voterID = voterID;
	}

	private void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	private int getvoterID() {
		return this.voterID;
	}

	private String getVoterName() {
		return this.voterName;
	}

}