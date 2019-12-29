package view;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import valueObject.VCLecture;

public class SelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private DirectoryPanel directoryPanel;
	private LecturePanel lecturePanel;
	
	public SelectionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ListSelectionListener listSelectionHandler = new ListSelectionHandler();
		
		this.directoryPanel = new DirectoryPanel(listSelectionHandler);
		this.add(this.directoryPanel);
		
		this.lecturePanel = new LecturePanel();
		this.add(this.lecturePanel);
	}
	public void initialize(String id) {
		this.directoryPanel.initialize(id);
		this.lecturePanel.initialize(id);
		
	}
	public void finish(String id) {
	}
	
	public Vector<VCLecture> getselectedLectures() {
		return this.lecturePanel.getselectedLectures();
		
	}
	
	private class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String fileName = directoryPanel.refresh(e.getSource());
			try {
				lecturePanel.refresh(fileName);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		}
	}

	

	
}
