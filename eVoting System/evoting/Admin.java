

package evoting;


public class Admin {

	private int[] unofficialTally = new int[8];
	private int[] officialTally = new int[8];
	private int adminID;
	private int adminPassword;
	private int numTotalVotes;
	private int numTotalVoters;

	private int[] getUnofficialTally() {
		return this.unofficialTally;
	}

	private int[] getOfficialTally() {
		return this.officialTally;
	}

	/**
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 */
	private void adminLogin(String adminUserName, String adminPassword) {
		throw new UnsupportedOperationException();
	}

	public int[] RecountVotes() {
		throw new UnsupportedOperationException();
	}

	private int[] voterToVotesRatio() {
		throw new UnsupportedOperationException();
	}

	private void PrintOfficialTally() {
		throw new UnsupportedOperationException();
	}

	private int getAdminID() {
		return this.adminID;
	}

	public String getAdminPassword() {
		throw new UnsupportedOperationException();
	}

}