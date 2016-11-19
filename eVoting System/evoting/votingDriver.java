package evoting;

import java.io.FileNotFoundException;
import java.io.IOException;
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
			String voterID = sc.next();
			System.out.println("Type your last name");
			String name = sc.next();
			System.out.println("Type last four of your social:");
			String social = sc.next();
			
			VotingServer VotingServer = new VotingServer();
			
			//If valid voter
			try {
				if (VotingServer.validateLogin(voterID, name,social))  {
					System.out.println("Registration found successfully.");

					Voter voter = new Voter(voterID);
					
					System.out.println("Please choose between the candidates:");
					System.out.printf("1. %s\n",candidate1.getName());
					System.out.printf("2. %s\n",candidate2.getName());

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
			
			


	
	}//end of main
}//end of driver
