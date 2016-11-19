

package evoting;

import java.util.Scanner;

public class Voter {
	
	
    private String voterName;
    private String voterID;

    boolean isLoggedIn = false;

    Candidate chosenCandidate = new Candidate();
   


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
	public void castVote(Candidate candidate1, Candidate candidate2) {
		System.out.println("Please choose between the candidates:");
		System.out.printf("1. %s\n",candidate1.getName());
		System.out.printf("2. %s\n",candidate2.getName());
	    Scanner sc = new Scanner(System.in);
		int Choice = sc.nextInt();
		chosenCandidate = null;
		
	
		if (Choice ==1){
			System.out.printf("You have chosen candidate %s, Is this correct?%n", candidate1.getName());
			chosenCandidate = candidate1;
		}
		else if (Choice ==2){
			System.out.printf("You have chosen candidate %s , Is this correct?%n", candidate2.getName());
			chosenCandidate = candidate2;
		}
		else{
			while(Choice != 1 || Choice != 2){
			System.out.println("Sorry, that is not a valid choice.  Please enter 1 or 2.");
			Choice = sc.nextInt();
			}
			
		}
		
		System.out.println("1. YES");
		System.out.println("2. NO");
		
		Choice = sc.nextInt();
		
		if (Choice ==1){  //YES
			confirmVote(chosenCandidate);
		}
		if (Choice ==2){  //NO
			editVote(candidate1,candidate2);
		}

	}



	public String writeIn(String candidateName) {
		throw new UnsupportedOperationException();
	}

	private void editVote(Candidate candidate1, Candidate candidate2) {

		System.out.println("Repicking Candidate");
		chosenCandidate = null;
		castVote(candidate1, candidate2);

		
		

	}

	private void confirmVote(Candidate candidate) {
		candidate.addVote();
	}

	public void printConfirmation() {
		System.out.printf("Thank you, you have voted");
		
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


