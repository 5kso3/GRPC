package client;

public class GConstants {
	public class ServerInfo {
		public final static String serverAddress = "localhost";
		public final static int serverPort = 9000;
		public final static int loginPort = 8000;
	}
	public class Login {
		public final static String login = "1";
		public final static String signUp = "2";
		public final static String titleLogin = "1 - Login";
		public final static String titleSignup = "2 - Sign Up";
		public final static String titleId = "ID : ";
		public final static String titlePassowrd = "Password : ";
		public final static String titleSuccess = "Login Success";
		public final static String titleFail = "Login Fail(Wrong Input)";
		public final static String wrongInputMessage = "Wrong Input";
	}
	public class SignUp {
		public final static String titleStudentId = "ID(Student ID) : ";
		public final static String titlePassword = "Passwrod : ";
		public final static String errorNoExistStudnet = "Error : Not Exist Student";
		public final static String signUpSuccess = "Sign Up Success";
		public final static String signUpFail = "Not Exist Student ID";
	}
	public class Menu {
		public final static String studnetList = "1";
		public final static String addStudent = "2";
		public final static String deleteStudent = "3";
		public final static String courseList = "4";
		public final static String addCourse = "5";
		public final static String deleteCourse = "6";
		public final static String enrolment = "7";
		public final static String stop = "x";
		public final static String stopMessage = "Stop";
		public final static String wrongInputMessage = "Wrong Input";
	}
	public enum MenuPrint {
		titleMenu("********************MENU********************"),
		titleStudnetList("1 - Student List"),
		titleAddStudent("2 - Add Student"),
		titleDeleteStudent("3 - Delete Student"),
		titleCourseList("4 - Course List"),
		titleAddCourse("5 - Add Course"),
		titleDeleteCourse("6 - Delete Course"),
		titleEnrolment("7 - Enrolment"),
		titleStop("x - Stop");
		private String printString;
		MenuPrint(String string) {
			printString = string;
		}
		public String getPrintString() {return printString;}
	}
	public class AddDeleteStudent {
		public final static String studentId = "Student ID = ";
		public final static String studentName = "Student Name = ";
		public final static String studentDeqartment = "Department = ";
		public final static String completedCourses = "CompletedCourses = ";
		public final static String deleteStudentId = "Delete Student ID = ";
	}
	public class AddDeleteCourse {
		public final static String courseId = "Course ID = ";
		public final static String professor = "Professor = ";
		public final static String name = "Course Name = ";
		public final static String prerequisites = "Prerequisites = ";
		public final static String deleteCourseId = "Delete Course ID = ";
	}
	public enum Enrolment {
		studentId("Student ID = "),
		courseId("Course ID = ");
		private String printString;
		Enrolment(String string) {
			this.printString = string;
		}
		public String getPrintString() {return printString;}
	}
	public class SuccessMessage {
		public final static String addSuccess = "Is Success";
		public final static String addFail = "ID already Exist";
		public final static String deleteSuccess = "Is Success";
		public final static String deleteFail = "ID doesn't Exist";
	}
	public enum EnrolmentResualt {
		success("0", "Success"),
		errorStudnetId("1", "Error : Student ID does not exist"),
		errorCourseId("2","Error : Course ID does not exist"),
		errorCompltedCourse("3","Error : Alreay Completed Course"),
		errorPrerequisites("4", "Error : You have not completed the prerequisite course"),
		errorAlreadyEnrollment("5", "Error : Already Enrollment"),
		errorSave("6", "Error : Fail to Save");
		
		private String code;
		private String message;
		EnrolmentResualt(String code, String message) {
			this.code = code;
			this.message = message;
		}
		public String getCode() {return code;}
		public String getMessage() {return message;}
	}
	public enum eDataInfoIsSuccess {
		addStudent("addStudent"),
		deleteStudent("deleteStudent"),
		isRegisteredStudent("isRegisteredStudent"),
		addCourse("addCourse"),
		deleteCourse("deleteCourse");
		private String code;
		eDataInfoIsSuccess(String code) {
			this.code = code;
		}
		public String getCode() {return this.code;}
	}
}
