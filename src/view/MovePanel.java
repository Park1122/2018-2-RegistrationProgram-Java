package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MovePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton leftButton;
	private JButton rightButton;
	
	public JButton getLeftButton() {
		return leftButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}

	public MovePanel(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.rightButton = new JButton(">");
		this.rightButton.setBackground(Color.GREEN);
		this.rightButton.setActionCommand("rightButton");
		this.rightButton.addActionListener(actionHandler);
		this.add(rightButton);
		
		this.leftButton = new JButton("<");
		this.leftButton.setBackground(Color.RED);
		this.leftButton.setActionCommand("leftButton");
		this.leftButton.addActionListener(actionHandler);
		this.add(this.leftButton);
	}
	
	public void initialize() {
	}
}
