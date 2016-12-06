package evoting;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class AdminUI {
	JFrame adminFrame = new JFrame();
	JPanel adminWelcomePanel = new JPanel();
	JPanel adminFunPanel = new JPanel();
	
	//Admin Welcome Panel GUI
	JLabel adminWelcomePanelLabel = new JLabel("Admin Login.");
	JLabel adminIDLabel = new JLabel("Enter Admin ID");
	JLabel adminPassLabel = new JLabel("Enter Admin Password");
	JTextField adminIDTextBox = new JTextField();
	JTextField adminPassTextBox = new JTextField();
	JButton adminLoginButton = new JButton("LOGIN");
	JButton homeButton = new JButton("HOME");
	
	
	//Admin Function Panel GUI
	JLabel adminFunPanelLabel = new JLabel("Welcome, Admin");
	JButton adminLogoutButton = new JButton("LOGOUT");
	
	
	
	
	public AdminUI(){
		
		adminLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		adminLogoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		adminWelcomePanel.setLayout(new BoxLayout(adminWelcomePanel, BoxLayout.Y_AXIS));
		adminWelcomePanel.add(adminWelcomePanelLabel);
		adminWelcomePanel.add(adminIDLabel);
		adminWelcomePanel.add(adminIDTextBox);
		adminWelcomePanel.add(adminPassLabel);
		adminWelcomePanel.add(adminPassTextBox);
		adminWelcomePanel.add(adminLoginButton);
		adminWelcomePanel.add(homeButton);
		adminWelcomePanel.setPreferredSize(new Dimension(1000, 400));
		
		adminFrame.getContentPane().add(adminWelcomePanel);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.pack();
		adminFrame.setVisible(true);
		
		adminFunPanel.setLayout(new BoxLayout(adminFunPanel, BoxLayout.Y_AXIS));
		adminFunPanel.add(adminFunPanelLabel);
		adminFunPanel.add(adminLogoutButton);
		
		
		
		
		
		
		
	adminLoginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent o) {

    		String adminID = adminIDTextBox.getText();
    		String adminPass = adminPassTextBox.getText();
        	VotingServer VS = new VotingServer();
        	System.out.println("try 2" + adminID + " " + adminPass);
        		
        	try {
				if(VS.validateAdminLogin(adminID, adminPass)){
					adminWelcomePanel.setVisible(false);
					adminFunPanel.setVisible(true);
					adminFrame.getContentPane().add(adminFunPanel);
				}
				else{
					adminIDTextBox.setText("");
					adminPassTextBox.setText("");
					JOptionPane.showMessageDialog(adminWelcomePanel, "Invalid Login Credentials.");
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
	});
	
	
	homeButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent o){
			adminWelcomePanel.setVisible(false);
			adminIDTextBox.setText("");
			adminPassTextBox.setText("");
		}
	});
	
	
	adminLogoutButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent o){
			adminWelcomePanel.setVisible(true);
			adminFunPanel.setVisible(false);
			adminIDTextBox.setText("");
			adminPassTextBox.setText("");
		}
	});
	
	}
}
	

