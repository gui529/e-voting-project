
package evoting;


public class Voter {
	
	
    private String voterName;
    private String voterID;
    boolean isLoggedIn;

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