package view;

import java.awt.Color;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.EBasketPanel;
import valueObject.VCLecture;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = EBasketPanel.serialVersionUID.getInt();

	private CLecture cLecture;
	private Vector<VCLecture> vCLectures;
	private BasketList basketList;
	
	public BasketPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.vCLectures = new Vector<VCLecture>();
		this.basketList = new BasketList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.basketList);
		this.add(scrollPane);
	}
	
	public void initialize(String fileName) {		
	}
	public void finish(String fileName) throws IOException {
			this.cLecture = new CLecture();
			this.cLecture.setData(fileName, this.vCLectures);
	}

	public void addRows(Vector<VCLecture> vCRemovedLectures) {
		this.basketList.addRows(vCRemovedLectures);
	}
	
	public void removeSelectedLectures() {
		this.basketList.removeSelectedLectures();
	}
	
	public Vector<VCLecture> getSelectedLectures() {
		return this.basketList.getSelectedLectures();
	}
	
	private class BasketList extends JTable {
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		
		public BasketList() {
			this.setSelectionBackground(Color.ORANGE);
			Vector<String> header = new Vector<String>();
			for(int i=1; i<EBasketPanel.values().length; i++) {
				header.add(EBasketPanel.values()[i].getString());
			}
			this.tableModel = new DefaultTableModel(header, 0) {
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.setModel(this.tableModel);
		}

		public void addRows(Vector<VCLecture> vCRemovedLectures) {
				Vector<String> rowData;
				for(VCLecture vCLecture: vCRemovedLectures) {
					rowData = new Vector<String>();
					rowData.add(vCLecture.getName());
					rowData.add(vCLecture.getProfessorName());
					rowData.add(vCLecture.getTime());
					this.tableModel.addRow(rowData);
					vCLectures.add(vCLecture);
				}
				this.clearSelection();
				this.getSelectionModel().addSelectionInterval(0, 0);
		}
		
		public Vector<VCLecture> getSelectedLectures() {
			Vector<VCLecture> vCRemovedLectures = new Vector<VCLecture>();
			for(int i = this.tableModel.getRowCount()-1; i>=0; i--) {
				if(this.isRowSelected(i)) {
					this.tableModel.removeRow(i);
					vCRemovedLectures.add(vCLectures.get(i));
					vCLectures.remove(i);
				}
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
			return vCRemovedLectures;
		}
		
		public void removeSelectedLectures() {
			for(int i = this.tableModel.getRowCount()-1; i>=0; i--) {
				if(this.isRowSelected(i)) {
					this.tableModel.removeRow(i);
					vCLectures.remove(i);
				}
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
}
