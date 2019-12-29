package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import global.Constants.EJoinPanel;
import view.Main.ActionHandler4;

public class JoinPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel namePanel;
	JPanel idPanel;
	JPanel passPanel;
	JLabel name;
	JTextField nF;
	JLabel id;
	JTextField iF;
	JLabel pass;
	JTextField pF;
	JPanel btPanel;
	JButton saveBtn;
	JButton ckBtn;
	JPanel codePanel;
	JLabel code;
	JTextField cF;
	JPanel majorPanel;
	JLabel major;
	JTextField mF;
	JPanel sexPanel;
	JLabel sex;
	JTextField sF;
	
	public JoinPanel(ActionHandler4 saveHandler) {
		this.setLayout(new FlowLayout());
		this.setTitle(EJoinPanel.join.getString());
		this.setSize(EJoinPanel.width.getInt(), EJoinPanel.height.getInt());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.namePanel = new JPanel();
		this.name = new JLabel(EJoinPanel.name.getString());
		this.namePanel.add(name);
		this.nF = new JTextField(EJoinPanel.num.getInt());
		this.namePanel.add(nF);
		
		this.idPanel = new JPanel();
		this.id = new JLabel(EJoinPanel.id.getString());
		this.idPanel.add(id);
		this.iF = new JTextField(EJoinPanel.num.getInt());
		this.idPanel.add(iF);
		
		this.passPanel = new JPanel();
		this.pass = new JLabel(EJoinPanel.password.getString());
		this.passPanel.add(pass);
		this.pF = new JTextField(EJoinPanel.num.getInt());
		this.passPanel.add(pF);
		
		this.btPanel = new JPanel();
		this.saveBtn = new JButton(EJoinPanel.save.getString());
		this.saveBtn.setActionCommand(EJoinPanel.save.getString());
		this.saveBtn.addActionListener(saveHandler);
		this.btPanel.add(this.saveBtn);
		this.ckBtn = new JButton(EJoinPanel.cancel.getString());
		this.ckBtn.setActionCommand(EJoinPanel.cancel.getString());
		this.ckBtn.addActionListener(saveHandler);
		this.btPanel.add(this.ckBtn);
		
		this.codePanel = new JPanel();
		this.code = new JLabel(EJoinPanel.code.getString());
		this.codePanel.add(this.code);
		this.cF = new JTextField(EJoinPanel.num.getInt());
		this.codePanel.add(this.cF);
		
		this.majorPanel = new JPanel();
		this.major = new JLabel(EJoinPanel.major.getString());
		this.majorPanel.add(this.major);
		this.mF = new JTextField(EJoinPanel.num.getInt());
		this.majorPanel.add(this.mF);
		
		this.sexPanel = new JPanel();
		this.sex = new JLabel(EJoinPanel.sex.getString());
		this.sexPanel.add(this.sex);
		this.sF = new JTextField(EJoinPanel.num.getInt());
		this.sexPanel.add(this.sF);
		
		
		this.add(namePanel);
		this.add(idPanel);
		this.add(passPanel);
		this.add(codePanel);
		this.add(majorPanel);
		this.add(sexPanel);
		this.add(btPanel);
		
		this.setVisible(true);
	}

	public void initialize() {		
	}

}
