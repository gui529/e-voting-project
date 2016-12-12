package evoting;

public class Admin {

	private int[] unofficialTally = new int[8];
	private int adminID;
	private int adminPassword;
	VotingDatabase Database = new VotingDatabase();

	public int[] getUnofficialTally() {

		return this.unofficialTally;

	}

	public String getOfficialTally() {

		String tally = Database.getTally();
		return tally;

	}

	/**
  *
  * @param adminUserName
  * @param adminPassword
  */

	public int getAdminID() {

		return this.adminID;

	}

	public String getAdminPassword() {

		throw new UnsupportedOperationException();

	}

}