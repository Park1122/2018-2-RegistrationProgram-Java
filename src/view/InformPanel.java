package view;

import java.awt.FlowLayout;
import java.io.File;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import global.Constants.EDataFileName;
import global.Constants.EInformPanel;

public class InformPanel extends JDialog {
	private JLabel nameLabel;
	private JLabel hakbeonLabel;
	private JLabel hakgwaLabel;
	private JLabel sexLabel;

	private static final long serialVersionUID = 1L;

	public InformPanel(String id) {
		this.setLayout(new FlowLayout());
		this.setSize(EInformPanel.width.getInt(), EInformPanel.height.getInt());
		this.setLocationRelativeTo(null);
		this.setTitle(id + EInformPanel.inform.getString());

		String[] arr = readToFile(id);

		JPanel nPanel = new JPanel();
		JPanel hakbeonPanel = new JPanel();
		JPanel hakgwaPanel = new JPanel();
		JPanel sexPanel = new JPanel();

		this.nameLabel = new JLabel(arr[0]);
		this.hakbeonLabel = new JLabel(arr[1]);
		this.hakgwaLabel = new JLabel(arr[2]);
		this.sexLabel = new JLabel(arr[3]);

		nPanel.add(nameLabel);
		hakbeonPanel.add(hakbeonLabel);
		hakgwaPanel.add(hakgwaLabel);
		sexPanel.add(sexLabel);

		this.add(nPanel);
		this.add(hakbeonPanel);
		this.add(hakgwaPanel);
		this.add(sexPanel);

		this.setVisible(true);
	}

	public void initialize() {
	}

	private String[] readToFile(String id) {

		File file = new File(EDataFileName.path.getString() + id + EDataFileName.inform.getString());
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				String name = scanner.next();
				String hakbeon = scanner.next();
				String hakgwa = scanner.next();
				String sex = scanner.next();

				String[] str = new String[] { name, hakbeon, hakgwa, sex };

				return str;
			}
			scanner.close();
		} catch (Exception e) {
		}
		return null;
	}
}
