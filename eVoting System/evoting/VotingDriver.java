package evoting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

<<<<<<< HEAD:eVoting System/evoting/VotingDriver.java
public class VotingDriver {
=======
public class votingDriver {
	
>>>>>>> d7505a46d0b563b8682592c92c23b467c96a2e7d:eVoting System/evoting/votingDriver.java


	public static void main(String[] args) {
			boolean done= false;

			while (!done){
		
			     	Scanner sc = new Scanner(System.in);
		
					Candidate candidate1 = new Candidate();
					Candidate candidate2 = new Candidate();
		
					candidate1.setName("Henry Brown");
					candidate2.setName("Joyce Smalls");
					
					candidate1.setParty("Democrat");
					candidate2.setParty("Republican");
		
					
					System.out.println("Welcome to eVoting, type your voter ID number to start: ");
					String voterID = sc.next();
					System.out.println("Type your last name");
					String name = sc.next();
					System.out.println("Type last four of your social:");
					String social = sc.next();
					
					VotingServer VotingServer = new VotingServer();
					
					try {
						if (VotingServer.validateLogin(voterID, name,social))  {
							System.out.println("Registration found successfully.");
		
							Voter voter = new Voter(voterID);
							
							voter.castVote(candidate1, candidate2);
							
							System.out.printf("%s has %d,%n%s has %d%n",candidate1.getName(),candidate1.getVotes(),candidate2.getName(), candidate2.getVotes());
								
		
						}
						else
						{
							System.out.println("Your voter registration was not found.");
							return;
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			
			}//end while loop

	
	}//end of main
}//end of driver
