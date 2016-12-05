package evoting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VotingDriver {
	
	private static void createAndShowGUI(Candidate candidate1,Candidate candidate2) {
		//Create a frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("eVoting");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //create a panel
        JPanel p = new JPanel(); 
        frame.getContentPane().add(p);
        p.setLayout(null);
        
        
        //Labels and fields
        UIManager.put("Label.font", UIManager.getFont("Label.font").deriveFont((float) 30.0));
        UIManager.put("TextField.font", UIManager.getFont("TextField.font").deriveFont((float) 30.0));
        UIManager.put("Button.font", UIManager.getFont("Button.font").deriveFont((float) 30.0));
        UIManager.put("CheckBox.font", UIManager.getFont("CheckBox.font").deriveFont((float) 30.0));


        SwingUtilities.updateComponentTreeUI(frame);        
             
        JTextField voterId_textf = new JTextField("");
        JTextField voterName_textf = new JTextField("");
        JTextField last4ss_textf = new JTextField("");

        JLabel greet = new JLabel("eVoting System");       
        JLabel greetmessage = new JLabel("Please type your information and press the <NEXT> button.");

        JLabel lastName = new JLabel("Last name:");
        JLabel voterId = new JLabel("Voter ID number:");
        JLabel last4ss = new JLabel("Last four of social:");
        
        JLabel warningMessage = new JLabel("Voter registration not found.");
        warningMessage.setForeground(Color.RED);

////////////////
        JPanel p2 = new JPanel(); 
        frame.getContentPane().add(p2);
        p2.setLayout(null);        
                JCheckBox candidate2chebox = new JCheckBox(candidate2.getName());

        JCheckBox candidate1chebox = new JCheckBox(candidate1.getName());
        candidate1chebox.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if (candidate1chebox.isSelected()){
        			candidate2chebox.setSelected(false); }
        	}
        });
        candidate1chebox.setHorizontalAlignment(SwingConstants.CENTER);
        candidate2chebox.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		if (candidate2chebox.isSelected()){
        			candidate1chebox.setSelected(false); }
        	}
        });
        candidate2chebox.setHorizontalAlignment(SwingConstants.CENTER);

        
        
        JButton nextButton2 = new JButton("NEXT");

        
        
        
        
////////////
        
        JButton nextButton = new JButton("NEXT");
        nextButton.addActionListener(new ActionListener() {
        	@SuppressWarnings("finally")
			public void actionPerformed(ActionEvent e) {
				VotingServer VotingServer = new VotingServer();
				
				String voterId = voterId_textf.getText();
				String name = voterName_textf.getText();
				String social = last4ss_textf.getText();

				
				
				try {

					
					
					if (VotingServer.validateLogin(voterId, name,social))  {
						System.out.println("Registration found successfully.");
	
						Voter voter = new Voter(voterId);
						p.setVisible(false);
						p2.setVisible(true);
								JLabel confirmationMessage = new JLabel("");

				        nextButton2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent o) {
								
								
								
								if (candidate1chebox.isSelected()){
							        confirmationMessage.setBounds(190, 450, 1000, 40);

									confirmationMessage.setText("Please press <NEXT> to confirm your vote to "+candidate1.getName()+".");
								
								}
								
								if (candidate2chebox.isSelected()){
							        confirmationMessage.setBounds(190, 450, 1000, 40);

									confirmationMessage.setText("Please press <NEXT> to confirm your vote to "+candidate2.getName()+".");

								}
								


						               
						        p2.add(confirmationMessage);
						        
					
						        p2.repaint();

								
								
								
							}

				        });

						
						
							
	
					}
					else
					{
						p.add(warningMessage);
						p.repaint();
						
						
					} }
					
					catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//finally
					//{
						//return;
					//}
        	
        	}});     
        
   
        greet.setBounds(550, 25, 400, 40);
		greetmessage.setBounds(290, 100, 900, 40);
		warningMessage.setBounds(470, 630, 900, 40);

		candidate2chebox.setBounds(205, 117, 400, 200);
		candidate1chebox.setBounds(766, 117, 400, 200);


        
        voterId.setBounds(100, 250, 900, 40);
		voterId_textf.setBounds(370, 250, 400, 40);
		
		lastName.setBounds(100, 350, 900, 40);
		voterName_textf.setBounds(370, 350, 400, 40);
		
		last4ss.setBounds(100, 450, 900, 40);
		last4ss_textf.setBounds(370, 450, 400, 40);
		
		nextButton.setBounds(470, 550, 400, 40);
		nextButton2.setBounds(470, 550, 400, 40);




        
		//add all labels and textfields
		p.add(greet);
		p.add(greetmessage);
		
		p.add(lastName);
		p.add(voterId);
		p.add(last4ss);
		
		p.add(voterId_textf);
		p.add(voterName_textf);
		p.add(last4ss_textf);
		
		p.add(nextButton);
		p2.setVisible(false);
		
		p2.add(candidate2chebox);
		p2.add(candidate1chebox);
		p2.add(nextButton2);
		


	}

	public static void main(String[] args) {
			
			
					Candidate candidate1 = new Candidate();
					Candidate candidate2 = new Candidate();
		
					candidate1.setName("Henry Brown");
					candidate2.setName("Joyce Smalls");
					
					candidate1.setParty("Democrat");
					candidate2.setParty("Republican");	

			        javax.swing.SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			                createAndShowGUI(candidate1,candidate2);
			            }
			        });
					
			
			

	
	}//end of main
}//end of driver
