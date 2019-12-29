package view;

import java.awt.Color;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import control.CDirectory;
import global.Constants.EDataFileName;
import valueObject.VCDirectory;

public class DirectoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private DirectoryList directoryList1;
	private DirectoryList directoryList2;
	private DirectoryList directoryList3;

	public DirectoryPanel(ListSelectionListener listSelectionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JScrollPane scrollPane;

		scrollPane = new JScrollPane();
		this.directoryList1 = new DirectoryList();
		this.directoryList1.addListSelectionListener(listSelectionListener);
		scrollPane.setViewportView(this.directoryList1);
		this.add(scrollPane);

		scrollPane = new JScrollPane();
		this.directoryList2 = new DirectoryList();
		this.directoryList2.addListSelectionListener(listSelectionListener);
		scrollPane.setViewportView(this.directoryList2);
		this.add(scrollPane);

		scrollPane = new JScrollPane();
		this.directoryList3 = new DirectoryList();
		this.directoryList3.addListSelectionListener(listSelectionListener);
		scrollPane.setViewportView(this.directoryList3);
		this.add(scrollPane);
		
	}
	public void initialize(String id) {
		this.refresh(null); //데이터 초기화하는 부분
		
		this.directoryList1.initialize(id);
		this.directoryList2.initialize(id);
		this.directoryList3.initialize(id);
		
	}
	
	public String refresh(Object source) {
		String fileName = null;
		if(source == null) {
			this.directoryList1.refresh(EDataFileName.root.getString());
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if(source.equals(this.directoryList1)) {
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if(source.equals(this.directoryList2)) {
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if(source.equals(this.directoryList3)) {
			fileName = this.directoryList3.getSelectedFile();
		}
		return fileName;
	}
	
	private class DirectoryList extends JList<String> {
		private static final long serialVersionUID = 1L;

		private Vector<String> listData;
		private CDirectory cDirectory;
		private Vector<VCDirectory> vCDirectories;

		public DirectoryList() {
			this.setSelectionBackground(Color.ORANGE);
			this.listData = new Vector<String>();
			this.setListData(this.listData);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			this.cDirectory = new CDirectory();
		}
		
		public void initialize(String id) {
			// TODO Auto-generated method stub
			
		}

		public String getSelectedFile() {
			String fileName = this.vCDirectories.get(this.getSelectedIndex()).getFileName();
			return fileName;
		}

		public void refresh(String fileName) {
			if(fileName == null)
			   return;
			
			this.vCDirectories = this.cDirectory.getData(fileName);
			this.listData.clear();
			for (VCDirectory vCDirectory : this.vCDirectories) {
				this.listData.add(vCDirectory.getText());
			}
			this.setSelectedIndex(0);
			this.updateUI();
		}
	}
}
