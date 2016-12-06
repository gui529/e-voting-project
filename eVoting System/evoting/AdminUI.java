package evoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class AdminUI {
	JFrame adminFrame = new JFrame();
	JPanel adminPanel = new JPanel();
	
	JLabel adminWelcomeLabel = new JLabel("Welcome, Admin.");
	JLabel adminIDLabel = new JLabel("Enter Admin ID");
	JLabel adminPassLabel = new JLabel("Enter Admin Password");
	JTextField adminIDTextBox = new JTextField();
	JTextField adminPassTextBox = new JTextField();
	JButton adminLoginButton = new JButton("LOGIN");
	
	
	public AdminUI(){
		
		adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
		adminPanel.add(adminWelcomeLabel);
		adminPanel.add(adminIDLabel);
		adminPanel.add(adminIDTextBox);
		adminPanel.add(adminPassLabel);
		adminPanel.add(adminPassTextBox);
		adminPanel.add(adminLoginButton);
		adminPanel.setPreferredSize(new Dimension(1000, 400));
		
		adminFrame.getContentPane().add(adminPanel);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.pack();
		adminFrame.setVisible(true);
		
		
		
		String adminID = adminIDTextBox.getText();
		String adminPass = adminPassTextBox.getText();
	
	adminLoginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	VotingServer VS = new VotingServer();
        	
        		
        	try {
				if(VS.validateAdminLogin(adminID, adminPass)){
					adminFrame.setVisible(false);
					adminPanel.setVisible(false);
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
	}
}
	

