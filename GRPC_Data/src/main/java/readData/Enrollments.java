package readData;

import java.io.Serializable;
import java.util.Scanner;

public class Enrollments implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String studentId;
	protected String courseId;
	public Enrollments(String inputString) {
		Scanner sc = new Scanner(inputString);
		this.studentId = sc.next();
		this.courseId = sc.next();
	}
	public boolean match(String studnetId, String courseId) {
		if(this.studentId.equals(studnetId) && this.courseId.equals(courseId)) return true;
		return false;
	}
	public String getStudnetId() {return this.studentId;}
	public String getCourseId() {return this.courseId;}
}
