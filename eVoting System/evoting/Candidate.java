
package evoting;


public class Candidate {

	private String candidateName;
	private String candidateParty;
	private int numberOfVotes;

	public void setName(String name) {
		candidateName = name;
	}

	private void setParty() {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return candidateName;
	}

	private String getParty() {
		throw new UnsupportedOperationException();
	}

}