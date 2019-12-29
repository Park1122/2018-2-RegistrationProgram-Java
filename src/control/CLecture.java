package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import model.MLecture;
import valueObject.VCLecture;
import valueObject.VMLecture;

public class CLecture {
	
	private MLecture mLecture;
	
	
	public CLecture() {
		this.mLecture = new MLecture();
	}

	public Vector<VCLecture> getData(String fileName) throws FileNotFoundException {
		Vector<VMLecture> vMLectures = this.mLecture.getData(fileName);
		Vector<VCLecture> vCLectures = new Vector<VCLecture>();
		
		for(VMLecture vMLecture: vMLectures) {
			VCLecture vCLecture = new VCLecture();
			vCLecture.setId(vMLecture.getId());
			vCLecture.setName(vMLecture.getName());
			vCLecture.setProfessorName(vMLecture.getProfessorName());
			vCLecture.setCredit(vMLecture.getCredit());
			vCLecture.setTime(vMLecture.getTime());
			vCLectures.add(vCLecture);
		}
		return vCLectures;
	}

	public void setData(String fileName, Vector<VCLecture> vCLectures) throws IOException {
		Vector<VMLecture> vMLectures = new Vector<VMLecture>();
		
		for(VCLecture vCLecture: vCLectures) {
			VMLecture vmLecture = new VMLecture();
			vmLecture.setId(vCLecture.getId());
			vmLecture.setName(vCLecture.getName());
			vmLecture.setProfessorName(vCLecture.getProfessorName());
			vmLecture.setCredit(vCLecture.getCredit());
			vmLecture.setTime(vCLecture.getTime());
			vMLectures.add(vmLecture);
		}
		this.mLecture.setData(fileName, vMLectures);
	}

}
