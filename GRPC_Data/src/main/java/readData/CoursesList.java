package readData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import exeception.NullDataException;

public class CoursesList {
	protected ArrayList<Courses> vCourse;
	protected File file;
	public CoursesList(String CourseFileName) throws FileNotFoundException, IOException {
		this.file = new File(CourseFileName);
		Scanner sc = new Scanner(file);
		this.vCourse = new ArrayList<Courses>();
		while(sc.hasNext()) {
			String curInfo = sc.nextLine();
			if (!curInfo.equals("")) {
				this.vCourse.add(new Courses(curInfo));
			}
		}
		sc.close();
	}
	public ArrayList<Courses> getAllCourseRecords() throws NullDataException {
		if(this.vCourse.size() == 0) throw new NullDataException("Course Data is Null");
		return this.vCourse;
	}
	public Courses getRegisteredCourse(String courseId){
		for(Courses course : this.vCourse) {
			if(course.getCourseId().matches(courseId)) {
				return course;
			}
		}
		return null;
	}
	public boolean addCourse(String courseInfo) {
		if(this.vCourse.add(new Courses(courseInfo))) {
			writeFile();
			return true;
		}
		return false;
	}
	public boolean deleteCourse(String stringDataInfo) throws NullDataException {
		if(this.vCourse.size() == 0) throw new NullDataException("Course Data is Null");
		for(int i = 0; i < this.vCourse.size(); i++) {
			if(this.vCourse.get(i).courseId.matches(stringDataInfo)) {
				this.vCourse.remove(i);
				writeFile();
				return true;
			}
		}
		return false;
	}
	private void writeFile() {
		try {
			FileWriter fw = new FileWriter(file);
			for(Courses course : this.vCourse) {
				String line = "";
				line += course.getCourseId() + " " + course.professor + " " + course.name;
				for(String prerequisit : course.getPrerequisitesList()) {
					line += " " +prerequisit;
				}
				line += "\n";
				fw.write(line);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
