package server;

import service.AddCourse;
import service.AddEnrollment;
import service.AddStudent;
import service.DataInfoIsSuccess;
import service.DeleteCourse;
import service.DeleteStudent;

public class GConstants {
	public final static String nullData = "-1";
	public enum dataListLocation {
		studentList("data/Students.txt"),
		courseList("data/Courses.txt"),
		enrollmentList("data/Enrollment.txt");
		private String location;
		dataListLocation(String location) {
			this.location = location;
		}
		public String getLocation() {return this.location;}
	}
	public enum eDataInfoIsSuccess {
		addStudent("addStudent", new AddStudent()),
		deleteStudent("deleteStudent", new DeleteStudent()),
		addEnrollment("addEnrollment", new AddEnrollment()),
		addCourse("addCourse", new AddCourse()),
		deleteCourse("deleteCourse", new DeleteCourse());
		private String code;
		private DataInfoIsSuccess service;
		eDataInfoIsSuccess(String code, DataInfoIsSuccess service) {
			this.code = code;
			this.service = service;
		}
		public String getCode() {return this.code;}
		public DataInfoIsSuccess getService() {return this.service;}
	}
}
