package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

public class LecturePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private CLecture cLecture;
	private Vector<VCLecture> vCLectures; // model
	
	private LectureList lectureList;
	
	public LecturePanel() {
		this.setLayout(new BorderLayout());
		this.lectureList = new LectureList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lectureList);
		this.add(scrollPane);
	}
	public void initialize(String id) {
	}
	
	public void refresh(String fileName) throws FileNotFoundException {
		this.cLecture = new CLecture();
		this.vCLectures = cLecture.getData(fileName);
		
		this.lectureList.addRows(this.vCLectures);
		
	}
	
	public Vector<VCLecture> getselectedLectures() {
		return this.lectureList.getselectedLectures();
	}
	
	private class LectureList extends JTable {
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		
		public LectureList() {
			this.setSelectionBackground(Color.ORANGE);
			DefaultTableCellRenderer cellCenter = new DefaultTableCellRenderer();
			cellCenter.setHorizontalAlignment(SwingConstants.CENTER);
			
			this.getTableHeader().setReorderingAllowed(false);
			this.getTableHeader().setResizingAllowed(false);
			Vector<String> header = new Vector<String>();
			for(int i=1; i<ELecturePanel.values().length; i++) {
				header.add(ELecturePanel.values()[i].getString());
			}
			this.tableModel = new DefaultTableModel(header, 0) {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.setModel(tableModel);
			this.getColumn(ELecturePanel.id.getString()).setCellRenderer(cellCenter);
			this.getColumn(ELecturePanel.credit.getString()).setCellRenderer(cellCenter);
		}

		public void addRows(Vector<VCLecture> vCLectures) {	
				this.tableModel.setRowCount(0);
				Vector<String> rowData;
				for(VCLecture vCLecture: vCLectures) {
					rowData = new Vector<String>();
					rowData.add(vCLecture.getId());
					rowData.add(vCLecture.getName());
					rowData.add(vCLecture.getProfessorName());
					rowData.add(vCLecture.getCredit());
					rowData.add(vCLecture.getTime());
					this.tableModel.addRow(rowData);
				}
				this.getSelectionModel().addSelectionInterval(0, 0);
		}
		
		public Vector<VCLecture> getselectedLectures() {
			Vector<VCLecture> selectedVCLectures = new Vector<VCLecture>();
			for(int i=0; i<this.getRowCount(); i++) {
				if(this.isRowSelected(i)) {
					selectedVCLectures.add(vCLectures.get(i));
				}
			}
			return selectedVCLectures;
		}
	}
}
