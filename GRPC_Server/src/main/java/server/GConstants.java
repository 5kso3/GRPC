package server;

import service.AddCourse;
import service.AddStudent;
import service.DataInfoIsSuccess;
import service.DeleteCourse;
import service.DeleteStudent;

public class GConstants {
	public final static String success = "0";
	public final static String errorStudnetId = "1";
	public final static String errorCourseId = "2";
	public final static String errorCompltedCourse = "3";
	public final static String errorPrerequisites = "4";
	public final static String errorAlreadyEnrollment = "5";
	public final static String errorSave = "6";
	public final static String failToken = "false";
	public final static String successToken = "true";
	public final static String SercurityExceptionMessage = "Error : Your ID is invalid";
	public final static String nullData = "-1";
	public final static String addEnrollment = "addEnrollment";
	public final static String getAllStudentData = "getAllStudentData";
	public final static String getAllCourseData = "getAllCourseData";
	public final static String enrollment = "enrollment";
	public enum eDataInfoIsSuccess {
		addStudent("addStudent", new AddStudent()),
		deleteStudent("deleteStudent", new DeleteStudent()),
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
	public class ServerInfo {
		public final static String serverAddress = "localhost";
		public final static int port = 9090;
	}
}
