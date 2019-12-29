package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CLogin;
import global.Constants.EErrorDialog;
import global.Constants.ELoginDialog;
import view.Main.ActionHandler3;

public class LoginDialog extends JDialog {
	
	private static final long serialVersionUID = ELoginDialog.serialVersionUID.getInt();

	// components
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	private JButton joinButton;

	// association
	private CLogin cLogin;
	
	public LoginDialog(ActionListener actionHandler, KeyListener keyHandler, ActionHandler3 joinHandler) {
		// attributes
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
	    this.setLocation(
	    		dim.width/2 - this.getSize().width/2, 
	    		dim.height/2 - this.getSize().height/2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle(ELoginDialog.login.getString());
		
		// components
		
		this.setLayout(new FlowLayout());
		ImageIcon icon = new ImageIcon(ELoginDialog.loginImage.getString());
		
		JPanel imagePanel = new JPanel();
		JLabel imageLabel = new JLabel(icon);
		imagePanel.add(imageLabel);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		nameLabel = new JLabel(ELoginDialog.nameLabel.getString());
		panel1.add(nameLabel);
		nameText = new JTextField(ELoginDialog.nameTextSize.getInt());
		nameText.addKeyListener(keyHandler);
		panel1.add(nameText);
		
		JPanel panel2 = new JPanel();
		passwordLabel = new JLabel(ELoginDialog.passwordLabel.getString());
		panel2.add(passwordLabel);
		passwordText = new JTextField(ELoginDialog.passwordTextSize.getInt());
		passwordText.addKeyListener(keyHandler);
		panel2.add(passwordText);
		
		JPanel panel3 = new JPanel();
		okButton = new JButton(new ImageIcon(ELoginDialog.okImage.getString()));
		okButton.setBorderPainted(false);
		okButton.setContentAreaFilled(false);
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(ELoginDialog.okButton.getString());
		panel3.add(okButton);
		
		cancelButton = new JButton(new ImageIcon(ELoginDialog.cancelImage.getString()));
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.addActionListener(actionHandler);
		cancelButton.setActionCommand(ELoginDialog.cancelButton.getString());
		panel3.add(cancelButton);
		
		JPanel panel4 = new JPanel();
		joinButton = new JButton(new ImageIcon(ELoginDialog.joinImage.getString()));
		joinButton.setBorderPainted(false);
		joinButton.setContentAreaFilled(false);
		joinButton.addActionListener(joinHandler);
		panel4.add(joinButton);
		
		loginPanel.add(panel1);
		loginPanel.add(panel2);
		loginPanel.add(panel3);
		loginPanel.add(panel4);
		
		this.add(imagePanel);
		this.add(loginPanel);
		
		this.setVisible(true);
	}
	
	public void initialize() {
	}
	
	public String validateUser() {
		String ID = nameText.getText();
		String password = passwordText.getText();
		
		this.cLogin = new CLogin();
		boolean result = cLogin.validateUser(ID, password);
		if(result) {
			return ID;
		} else {
			JOptionPane.showMessageDialog(this,
						EErrorDialog.message.getString(),
						EErrorDialog.title.getString(), JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
	}
	
	public void cancel() {
	}
}
