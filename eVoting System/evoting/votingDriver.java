package evoting;

import java.util.Scanner;

public class votingDriver {

	public static void main(String[] args) {
		
	     Scanner sc = new Scanner(System.in);

			Candidate candidate1 = new Candidate();
			Candidate candidate2 = new Candidate();

			candidate1.setName("Henry Brown");
			candidate2.setName("Joyce Smalls");
			
			candidate1.setParty("Democrat");
			candidate2.setParty("Republican");

			
			System.out.println("Welcome to eVoting, type your voter ID number to start: ");
			int voterID = sc.nextInt();
			System.out.println("Type your last name");
			String last_name = sc.next();
			System.out.println("Type last four of your social:");
			int last4Social = sc.nextInt();
			
			VotingServer VotingServer = new VotingServer();
			
			//If valid voter
			if (VotingServer.validateLogin(voterID, last_name, last4Social))  {
				
				Voter voter = new Voter(voterID);
				
				System.out.println("Please choose between the candidates:");
				System.out.printf("1. %s\n",candidate1.getName());
				System.out.printf("2. %s\n",candidate2.getName());


						
				
				System.out.println("SUCCESS");
			}
			else
			{
				System.out.println("Your voter registration was not found.");
				return;
			}
			
			


	
	}//end of main
}//end of driver
