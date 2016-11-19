
package evoting;


public class Candidate {

	private String candidateName;
	private String candidateParty;
	private int numberOfVotes;

	public void setName(String candidateName) {
		this.candidateName = candidateName;
	}



	public void setParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}

	public String getName() {
		return candidateName;
	}

	public String getParty() {
		return candidateParty;
	}
	
	public void addVote(){
		
		numberOfVotes++;
	}

}