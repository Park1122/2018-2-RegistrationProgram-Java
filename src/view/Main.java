package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import global.Constants.EDataFileName;
import global.Constants.EJoinPanel;
import global.Constants.ELoginDialog;
import global.Constants.EMain;

public class Main {
	
	// component
	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	private JoinPanel joinPanel;
	
	// association
	private ActionListener actionHandler;
	private ActionHandler2 rejoinHandler;
	private KeyHandler keyHandler;
	private ActionHandler3 joinHandler;
	private ActionHandler4 saveHandler;
	
	public Main() {
		// child window
		this.actionHandler = new ActionHandler();
		this.keyHandler = new KeyHandler();
		this.rejoinHandler = new ActionHandler2();
		this.joinHandler = new ActionHandler3();
		
		this.saveHandler = new ActionHandler4();
		
		this.loginDialog = new LoginDialog(actionHandler, keyHandler,joinHandler);
	}
	
	private void rejoin() {
		this.keyHandler = new KeyHandler();
		this.loginDialog = new LoginDialog(actionHandler, keyHandler,joinHandler);
	}
	
	private void initialize() {
		this.loginDialog.initialize(); //extension
	}
	
	private void loginOK() {
		String id = loginDialog.validateUser();
		if(id != null) {
			loginDialog.dispose();
			
			this.mainFrame = new MainFrame(rejoinHandler);
			this.mainFrame.initialize(id);
		}
	}	
	private void loginCancel() {
		loginDialog.cancel();
		loginDialog.dispose();
	}
	
	public static void main(String[] args) {
		Main main;
		main = new Main();
		main.initialize();
	}
	
	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(ELoginDialog.okButton.getString())) {
				loginOK();
			} else if(actionEvent.getActionCommand().equals(ELoginDialog.cancelButton.getString())) {
				loginCancel();
			}
		}
	}
	
	class ActionHandler2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			mainFrame.dispose();
			rejoin();
		}
	}
	
	class ActionHandler3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event2) {
			loginDialog.dispose();
			joinPanel = new JoinPanel(saveHandler);
			joinPanel.initialize();
		}
	}
	
	class ActionHandler4 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(EJoinPanel.save.getString())) {
				String name = joinPanel.nF.getText();
				String id = joinPanel.iF.getText();
				String pass = joinPanel.pF.getText();
				String code = joinPanel.cF.getText();
				String major = joinPanel.mF.getText();
				String sex = joinPanel.sF.getText();
				
				try {
					File file = new File(EDataFileName.path.getString() + EDataFileName.login.getString());
					FileWriter fw = new FileWriter(file,true);
					fw.write(id + " ");
					fw.write(pass + "\n");
					
					fw.close();
					
					File file2 = new File(EDataFileName.path.getString() + EDataFileName.personalInfo.getString());
					FileWriter fw2 = new FileWriter(file2,true);
					fw2.write(id + " ");
					fw2.write(name + "\n");
					
					fw2.close();
					
					File file3 = new File(EDataFileName.path.getString() + id + EDataFileName.inform.getString());
					FileWriter fw3 = new FileWriter(file3);
					fw3.write(EMain.name.getString() + name + "\n");
					fw3.write(EMain.code.getString() + code + "\n");
					fw3.write(EMain.major.getString() + major + "\n");
					fw3.write(EMain.sex.getString() + sex);
					
					fw3.close();
					
					joinPanel.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getActionCommand().equals(EJoinPanel.cancel.getString())) {
				joinPanel.dispose();
			}
			
		}
	}
	
	class KeyHandler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				loginOK();
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				loginDialog.dispose();
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
		}
	}
}
