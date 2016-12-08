	package evoting;
	
	import java.awt.Cursor;
	import java.awt.Dimension;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;
	
	public class AdminUI {
	 JFrame adminFrame = new JFrame();
	 JPanel adminWelcomePanel = new JPanel();
	 JPanel adminFunPanel = new JPanel();
	
	 //Admin Welcome Panel GUI
	 JLabel adminWelcomePanelLabel = new JLabel("Admin Login.");
	 JLabel adminIDLabel = new JLabel("Enter Admin ID");
	 JLabel adminPassLabel = new JLabel("Enter Admin Password");
	 JTextField adminIDTextBox = new JTextField();
	 //JTextField adminPassTextBox = new JTextField();
	 JButton adminLoginButton = new JButton("LOGIN");
	 JButton homeButton = new JButton("HOME");
	
	
	 //Admin Function Panel GUI
	 JLabel adminFunPanelLabel = new JLabel("Welcome, Admin");
	 JButton adminLogoutButton = new JButton("LOGOUT");
	 JButton adminUnofficialTallyButton = new JButton("UNOFFICIAL TALLY");
	 JButton adminOfficialTallyButton = new JButton("OFFICIAL TALLY");
	 JButton adminRecountButton = new JButton("RECOUNT");
	 JPasswordField passwordField = new JPasswordField(10);
	
	
	
	
	 public AdminUI() {
	
	  adminLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	  adminLogoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	  homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
	  adminWelcomePanel.setLayout(new BoxLayout(adminWelcomePanel, BoxLayout.Y_AXIS));
	  adminWelcomePanel.add(adminWelcomePanelLabel);
	  adminWelcomePanel.add(adminIDLabel);
	  adminWelcomePanel.add(adminIDTextBox);
	  adminWelcomePanel.add(adminPassLabel);
	  adminWelcomePanel.add(passwordField);
	  adminWelcomePanel.add(adminLoginButton);
	  adminWelcomePanel.add(homeButton);
	  adminWelcomePanel.setPreferredSize(new Dimension(1000, 400));
	
	  adminFrame.getContentPane().add(adminWelcomePanel);
	  adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  adminFrame.pack();
	  adminFrame.setVisible(true);
	
	  adminFunPanel.setLayout(new BoxLayout(adminFunPanel, BoxLayout.Y_AXIS));
	  adminFunPanel.add(adminFunPanelLabel);
	  adminFunPanel.add(adminUnofficialTallyButton);
	  adminFunPanel.add(adminOfficialTallyButton);
	  adminFunPanel.add(adminRecountButton);
	  adminFunPanel.add(adminLogoutButton);
	
	
	  //***************THE FOLLOWING IS WHERE THE LISTENERS ARE LOCATED*********************\\
	  int maxAdminUserChar = 16;
	  adminIDTextBox.addKeyListener(new KeyAdapter() {
	   public void keyTyped(KeyEvent e) {
	    char c = e.getKeyChar();
	    int a = adminIDTextBox.getText().length();
	    if (a >= maxAdminUserChar) {
	     e.consume();
	    }
	    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
	
	     e.consume();
	    }
	   }
	  });
	
	  passwordField.addKeyListener(new KeyAdapter() {
	   public void keyTyped(KeyEvent e) {
	    char c = e.getKeyChar();
	    int a = passwordField.getText().length();
	    if (a >= maxAdminUserChar) {
	     e.consume();
	    }
	    if (!((c >= 'A') && (c <= 'z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
	
	     e.consume();
	    }
	   }
	  });
	
	
	  
	
	  adminLoginButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent o) {
	
	    String adminID = adminIDTextBox.getText();
	    String adminPass = String.valueOf(passwordField.getPassword());
	    VotingServer VS = new VotingServer();
	   
	
	    try {
	     if (VS.validateAdminLogin(adminID, adminPass)) {
	      adminWelcomePanel.setVisible(false);
	      adminFunPanel.setVisible(true);
	      adminFrame.getContentPane().add(adminFunPanel);
	     } else {
	      adminIDTextBox.setText("");
	      passwordField.setText("");
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
	
	
	  homeButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent o) {
	    adminWelcomePanel.setVisible(false);
	    adminIDTextBox.setText("");
	    passwordField.setText("");
	    adminFrame.dispose();
	    VotingDriver GUI = new VotingDriver(); //createAndShowGUI(candidate1,candidate2);
	    GUI.createAndShowGUI();
	
	
	
	   }
	  });
	
	
	  adminLogoutButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent o) {
	    adminWelcomePanel.setVisible(true);
	    adminFunPanel.setVisible(false);
	    adminIDTextBox.setText("");
	    passwordField.setText("");
	
	
	   }
	  });
	
	 }
	}