package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import global.Constants.EPersonalInfoPanel;
import valueObject.VCPersonalInfo;
import view.Main.ActionHandler2;
import view.MainFrame.InfoHandler;

public class PersonalInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel lbInsa;
	private JLabel lbInsaPostfix;
	private JButton btnInfo;
	private JButton btnLogout;
	
	public PersonalInfoPanel(ActionHandler2 outHandler, InfoHandler infoHandler) {
		this.setBackground(Color.LIGHT_GRAY);
		
		this.lbInsa = new JLabel();
		this.add(this.lbInsa);
		this.lbInsaPostfix = new JLabel(EPersonalInfoPanel.lbInsaPostfix.getString());
		this.add(this.lbInsaPostfix);
		this.btnInfo = new JButton(EPersonalInfoPanel.btnInfo.getString());
		this.btnInfo.addActionListener(infoHandler);
		this.add(this.btnInfo);
		this.btnLogout = new JButton(EPersonalInfoPanel.btnLogout.getString());
		this.btnLogout.addActionListener(outHandler);
		this.add(this.btnLogout);
	}
	public void initialize(String id) {
		this.showPersonalInfo(id);
	}
	
	private void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vPersonalInfo = cPersonalInfo.getPersonalInfo(id);
		this.lbInsa.setText(vPersonalInfo.getName());	
	}
	public void finish(String id) {
	}
	
}
