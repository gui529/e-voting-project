

package evoting;


public class VotingServer {

	private int voterID;
	private int[] officialTally = new int[8];

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
	 * @param userName
	 * @param Password
	 */
	public boolean validateLogin(int voterID, String lastName, int last4social) {
		return (voterID == 123 & lastName.equals("costa") && last4social == 456);
			
		
		
	}

	/**
	 * 
	 * @param voterUserName
	 * @param VoterPassword
	 */
	private void checkIfRegistered(String voterUserName, String VoterPassword) {
		throw new UnsupportedOperationException();
	}

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