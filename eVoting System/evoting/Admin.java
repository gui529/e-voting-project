package evoting;

import java.sql.SQLException;

public class Admin {

	private int[] unofficialTally = new int[8];
	private int adminID;
	private int adminPassword;
	VotingDatabase Database = new VotingDatabase();

	public int[] getUnofficialTally() {

		return this.unofficialTally;

	}

	public String getOfficialTally() {

		String tally = "0";
		try {
			tally = Database.getTally();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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