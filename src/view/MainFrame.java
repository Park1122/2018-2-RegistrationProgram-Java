package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import global.Constants.EMainFrame;
import view.Main.ActionHandler2;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = EMainFrame.serialVersionUID.getInt();

	private PersonalInfoPanel personalInfo;
	private RegistrationPanel registration;
	private String id;
	private InformPanel informPanel;

	// constructor
	public MainFrame(ActionHandler2 outHandler) {
		// attributes
		this.setTitle(EMainFrame.title.getString());
		this.setSize(EMainFrame.width.getInt(), EMainFrame.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, 
						 dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		createMenu();
		
		InfoHandler infoHandler = new InfoHandler();
		
		WindowListener windowListener = new WindowHandler();
		this.addWindowListener(windowListener);

		this.personalInfo = new PersonalInfoPanel(outHandler, infoHandler);
		this.add(this.personalInfo, BorderLayout.NORTH);

		this.registration = new RegistrationPanel();
		this.add(this.registration, BorderLayout.CENTER);

		this.setVisible(true);
	}

	private void createMenu() {
		MenuHandler menuHandler = new MenuHandler();
		
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu(EMainFrame.screen.getString());
		
		
		JMenuItem max = new JMenuItem(EMainFrame.max.getString());
		max.setActionCommand(EMainFrame.max.getString());
		max.setToolTipText(EMainFrame.maxToolTip.getString());
		max.addActionListener(menuHandler);
		screenMenu.add(max);
		
		screenMenu.addSeparator();
		
		JMenuItem hide = new JMenuItem(EMainFrame.hide.getString());
		hide.setActionCommand(EMainFrame.hide.getString());
		hide.setToolTipText(EMainFrame.hideToolTip.getString());
		hide.addActionListener(menuHandler);
		screenMenu.add(hide);
		
		screenMenu.addSeparator();
		
		JMenuItem exit = new JMenuItem(EMainFrame.exit.getString());
		exit.setActionCommand(EMainFrame.exit.getString());
		exit.setToolTipText(EMainFrame.exitToolTip.getString());
		exit.addActionListener(menuHandler);
		screenMenu.add(exit);
		
		
		mb.add(screenMenu);
		setJMenuBar(mb);
		
	}

	public void initialize(String id) {
		this.id = id;
		this.personalInfo.initialize(id);
		this.registration.initialize(id);
	}
	
	public void finish() {
		this.personalInfo.finish(this.id);
		try {
			this.registration.finish(this.id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class MenuHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(EMainFrame.max.getString())) {
				setExtendedState(MAXIMIZED_BOTH);
			}else if(e.getActionCommand().equals(EMainFrame.hide.getString())) {
				setState(ICONIFIED);
			}else if(e.getActionCommand().equals(EMainFrame.exit.getString())) {
				finish();
				dispose();
			}
			
		}
		
	}
	
	class InfoHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			informPanel = new InformPanel(id);
			informPanel.initialize();
			
		}
	}
	
	private class WindowHandler implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
		}
		@Override
		public void windowClosed(WindowEvent e) {
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			finish();
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
		}
		@Override
		public void windowIconified(WindowEvent e) {
		}
	}
}
