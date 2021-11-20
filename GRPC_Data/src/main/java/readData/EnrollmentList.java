package readData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exeception.NullDataException;

public class EnrollmentList {
	protected ArrayList<Enrollments> vEnrollment;
	protected File file;
	public EnrollmentList(String enrollmentFileName) throws FileNotFoundException {
		this.file = new File(enrollmentFileName);
		Scanner sc = new Scanner(file);
		this.vEnrollment = new ArrayList<Enrollments>();
		while(sc.hasNext()) {
			String curInfo = sc.nextLine();
			if(!curInfo.equals("")) {
				this.vEnrollment.add(new Enrollments(curInfo));
			}
		}
		sc.close();
	}
	public ArrayList<Enrollments> getAllEnrollmentRecords() throws NullDataException {
		if(this.vEnrollment.size() == 0) throw new NullDataException("Enrollment Data is Null");
		return this.vEnrollment;
	}
	public boolean addEnrollment(String enrollmentInfo) {
		if(this.vEnrollment.add(new Enrollments(enrollmentInfo))) {
			this.writeFile();
			return true;
		}
		return false;
	}
	public boolean deleteEnrollment(String stringDataInfo) throws NullDataException{
		if(this.vEnrollment.size() == 0) throw new NullDataException("Enrollment Data is Null");
		for(int i = 0; i < this.vEnrollment.size(); i++) {
			this.vEnrollment.remove(i);
			this.writeFile();
			return true;
		}
		return false;
	}
	private void writeFile() {
		try {
			FileWriter fw = new FileWriter(file);
			for(Enrollments enrollment : this.vEnrollment) {
				String line = "";
				line += enrollment.getStudnetId() + " " + enrollment.getCourseId() + "\n";
				fw.write(line);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
