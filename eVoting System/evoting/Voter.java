
package evoting;


public class Voter {

	protected int voterID;
	private String voterName;

	/**
	 * 
	 * @param voterUserName
	 * @param voterPassword
	 */
	private void login(String voterUserName, String voterPassword) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param candidate
	 */
	private void castVote(Candidate candidate) {
		throw new UnsupportedOperationException();
	}

	private String writeIn(String candidateName) {
		throw new UnsupportedOperationException();
	}

	private void editVote() {
		throw new UnsupportedOperationException();
	}

	private void confirmVote() {
		throw new UnsupportedOperationException();
	}

	public void printConfirmation() {
		throw new UnsupportedOperationException();
	}

	private void setVoterID(String voterID) {
		throw new UnsupportedOperationException();
	}

	private void setVoterName(String voterName) {
		throw new UnsupportedOperationException();
	}

	private int getvoterID() {
		return this.voterID;
	}

	private String getVoterName() {
		return this.voterName;
	}

}