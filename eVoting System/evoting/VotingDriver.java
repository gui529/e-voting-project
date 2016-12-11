package evoting;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing. * ;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VotingDriver {

	static Candidate chosenCandidate;
	static String voterID;
	String name;
	String social;
	Voter voter;

	public void createAndShowGUI() {
		Candidate candidate1 = new Candidate();
		Candidate candidate2 = new Candidate();
		
		candidate1.setName("Henry Brown");
		candidate2.setName("Joyce Smalls");
		//Create a frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("eVoting");
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		//create a panel
		JPanel p = new JPanel();
		frame.getContentPane().add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(1000, 450));

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
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.setPreferredSize(new Dimension(1000, 400));

		JCheckBox candidate2chebox = new JCheckBox(candidate2.getName());

		JCheckBox candidate1chebox = new JCheckBox(candidate1.getName());
		candidate1chebox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (candidate1chebox.isSelected()) {
					candidate2chebox.setSelected(false);
				}
			}
		});
		candidate1chebox.setHorizontalAlignment(SwingConstants.CENTER);
		candidate2chebox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (candidate2chebox.isSelected()) {
					candidate1chebox.setSelected(false);
				}
			}
		});
		candidate2chebox.setHorizontalAlignment(SwingConstants.CENTER);

		JButton nextButton2 = new JButton("NEXT");
		JButton confirm = new JButton("CONFIRM");
		JButton edit = new JButton("EDIT");
		confirm.setVisible(false);
		edit.setVisible(false);
		JButton adminButton = new JButton("ADMIN");
		adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		edit.setCursor(new Cursor(Cursor.HAND_CURSOR));

		VotingServer VotingServer = new VotingServer();

		////////////

		JButton nextButton = new JButton("NEXT");
		nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voterID = voterId_textf.getText();
				String name = voterName_textf.getText();
				String social = last4ss_textf.getText();
				voter = new Voter();

				try {

					try {
						if (VotingServer.validateLogin(voterID, name, social)) {

							p.setVisible(false);
							p2.setVisible(true);
							JLabel confirmationMessage = new JLabel("");
							JLabel confirmationMessage2 = new JLabel("");

							nextButton2.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent o) {
									if (candidate1chebox.isSelected()) {
										confirmationMessage.setBounds(190, 450, 1000, 40);
										confirmationMessage2.setBounds(190, 475, 1000, 40);
										confirmationMessage.setText("Please press <CONFIRM> to confirm your vote to " + candidate1.getName());
										confirmationMessage2.setText("or <EDIT> to change");
										nextButton2.setVisible(false);
										candidate1chebox.setEnabled(false);
										candidate2chebox.setEnabled(false);
										confirm.setVisible(true);
										edit.setVisible(true);
										chosenCandidate = candidate1;

									}

									if (candidate2chebox.isSelected()) {
										confirmationMessage.setBounds(190, 450, 1000, 40);
										confirmationMessage2.setBounds(190, 475, 1000, 40);
										confirmationMessage.setText("Please press <CONFIRM> to confirm your vote to " + candidate2.getName());
										confirmationMessage2.setText("or <EDIT> to change");
										candidate2chebox.setEnabled(false);
										candidate1chebox.setEnabled(false);
										nextButton2.setVisible(false);
										confirm.setVisible(true);
										edit.setVisible(true);
										chosenCandidate = candidate2;
									}

									p2.add(confirmationMessage);
									p2.add(confirmationMessage2);

									p2.repaint();

								}

							});

						}
						else {

							voterId_textf.setText("");
							voterName_textf.setText("");
							last4ss_textf.setText("");
							JOptionPane.showMessageDialog(p, "Invalid Login Credentials.");
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				catch(FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch(IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//finally
				//{
				//return;
				//}

			}
		});

		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent o) {
				p2.removeAll();
				JLabel confirmMessage = new JLabel("Thank you for voting! Your vote was recorded.");
				confirmMessage.setBounds(200, 117, 800, 200);

				p2.add(confirmMessage);
				p2.repaint();

				int delay = 5000; // wait for 5 seconds

				Timer timer = new Timer(delay, new AbstractAction() {@Override
					public void actionPerformed(ActionEvent ae) {
						//action that you want performed 

						voter.castVote(chosenCandidate);
						frame.dispose();
						VotingDriver GUI = new VotingDriver(); //createAndShowGUI(candidate1,candidate2);
						GUI.createAndShowGUI();
					}
				});
				timer.setRepeats(false); //the timer should only go off once
				timer.start();

			}
		});
		edit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent o) {
				candidate1chebox.setEnabled(true);
				candidate2chebox.setEnabled(true);
				confirm.setVisible(false);
				edit.setVisible(false);
				nextButton2.setVisible(true);
				nextButton2.setEnabled(true);



			}});
        
        adminButton.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
               AdminUI adminui = new AdminUI();
               frame.setVisible(false);
               adminui.adminFrame.setVisible(true);
            }  
            
            
        });
        //The following is taken from http://stackoverflow.com/questions/10586395/jtextfield-how-to-limit-the-number-of-charaters
        int maxVoterID = 10;
        voterId_textf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int a =voterId_textf.getText().length();
                if(a >= maxVoterID)
                {
                    e.consume();
                }
                //Only take numbers:
                if (!((c >= '0') && (c <= '9') || (c ==   KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE)
                       )) {
                   
                    e.consume();
                }
            }
           });
        
        int maxVoterSS = 4;
        last4ss_textf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int a =last4ss_textf.getText().length();
                if(a >= maxVoterSS)
                {
                    e.consume();
                }
                //Only take numbers:
                if (!((c >= '0') && (c <= '9') || (c ==   KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE)
                       )) {
                   
                    e.consume();
                }
            }
           });
        
        
        int maxVoterName = 16;
		voterName_textf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	char c = e.getKeyChar();
                int a = voterName_textf.getText().length();
                if(a >= maxVoterName)
                {
                    e.consume();
                }
                if (!((c >= 'A') && (c <= 'z') || (c ==   KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE)
                       )) {
                   
                    e.consume();
                }
            }
           });
        
        
        
       
        
   
        greet.setBounds(550, 25, 400, 40);
        adminButton.setBounds(650, 25, 250, 40);

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
		confirm.setBounds(470, 550, 400, 40);
		edit.setBounds(470, 500, 400, 40);

		//add all labels and textfields
		p.add(greet);
		p.add(greetmessage);
		p.add(lastName);
		p.add(voterName_textf);
		p.add(voterId);
		p.add(voterId_textf);
		p.add(last4ss);
		p.add(last4ss_textf);
		frame.add(p);
		frame.pack();
		frame.setVisible(true);

		p.add(nextButton);
		p.add(adminButton);

		p2.setVisible(false);

		p2.add(candidate2chebox);
		p2.add(candidate1chebox);
		p2.add(nextButton2);
		p2.add(confirm);
		p2.add(edit);
		frame.add(p2);

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
				VotingDriver GUI = new VotingDriver(); //createAndShowGUI(candidate1,candidate2);
				GUI.createAndShowGUI();
			}
		});

	} //end of main
} //end of driver
