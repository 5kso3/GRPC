package readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import exeception.NullDataException;
import exeception.SaveFailException;

public class StudentList {
	protected ArrayList<Students> vStudent;
	protected File file;
	public StudentList(String StudentFileName) throws FileNotFoundException, IOException {
		BufferedReader objStudentFile = new BufferedReader(new FileReader(StudentFileName));
		this.file = new File(StudentFileName);
		this.vStudent = new ArrayList<Students>();
		while (objStudentFile.ready()) {
			String stuInfo = objStudentFile.readLine();
			if (!stuInfo.equals("")) {
				this.vStudent.add(new Students(stuInfo));
			}
		}
		objStudentFile.close();
	}
	public ArrayList<Students> getAllStudentRecords() throws NullDataException {
		if(this.vStudent.size() == 0) throw new NullDataException("Error : Student Data is Null");
		return this.vStudent;
	}
	public boolean addStudent(String studnetInfo) {
		if (this.vStudent.add(new Students(studnetInfo))) {
			this.writeFile();
			return true;
		}
		return false;
	}
	public boolean deleteStudent(String studnetInfo) throws NullDataException {
		if(this.vStudent.size() == 0) throw new NullDataException("Error : Student Data is Null");
		for(int i = 0; i < this.vStudent.size(); i++) {
			Students student = this.vStudent.get(i);
			if(student.match(studnetInfo)) {
				this.vStudent.remove(i);
				this.writeFile();
				return true;
			}
		}
		return false;
	}
	public Students getRegisteredStudent(String sSID){
		for (int i = 0; i < this.vStudent.size(); i++) {
			Students objStudent = (Students) this.vStudent.get(i);
			if (objStudent.match(sSID)) {
				return objStudent;
			}
		}
		return null;
	}
	private void writeFile() {
		try {
			FileWriter fw = new FileWriter(file);
			for(Students student : this.vStudent) {
				String line = "";
				line += student.getStudentId() + " " + student.getName() + " " + student.getDepartment(); 
				for(String completedCourses : student.getCompletedCoursesList()) {
					line += " " + completedCourses;
				}
				line += "\n";
				if(line.equals(null)) {throw new SaveFailException("Error : Save Fail");};
				fw.write(line);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SaveFailException e) {
			e.printStackTrace();
		}
	}
}
