package client;

import java.util.Scanner;
import com.data.grpc.DataService;
import com.data.grpc.dataGrpc;
import com.data.grpc.DataService.Course;
import com.data.grpc.DataService.Student;
import com.data.grpc.dataGrpc.dataBlockingStub;
import client.GConstants.Enrolment;
import client.GConstants.EnrolmentResualt;
import client.GConstants.eDataInfoIsSuccess;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Service {
	private String token;
	public void printLoginMenu() {
		System.out.println(GConstants.Login.titleLogin);
		System.out.println(GConstants.Login.titleSignup);
	}
	public void signUp(dataBlockingStub stub, dataBlockingStub loginStub, Scanner sc) {
		System.out.print(GConstants.SignUp.titleStudentId);
		String studentId = sc.next();
		System.out.print(GConstants.SignUp.titlePassword);
		String password = sc.next();
		DataService.dataInfo.Builder request = DataService.dataInfo.newBuilder();
		request.setStringDataInfo(eDataInfoIsSuccess.isRegisteredStudent.getCode() + " " + studentId);
		DataService.IsSuccess response = stub.isRegisteredStudent(request.build());
		if(response.getIsSuccess()) {
			DataService.userInfo.Builder signUpRequest = DataService.userInfo.newBuilder();
			signUpRequest.setId(studentId).setPassword(password);
			DataService.IsSuccess singUpResponse = loginStub.signUp(signUpRequest.build());
			if(singUpResponse.getIsSuccess()) {System.out.println(GConstants.SignUp.signUpSuccess);}
			else {System.out.println(GConstants.SignUp.errorNoExistStudnet);}
		} else {
			System.out.println(GConstants.SignUp.signUpFail);
		}
	}
	public boolean login(dataBlockingStub loginStub, Scanner sc) {
		System.out.print(GConstants.Login.titleId);
		String id = sc.next();
		System.out.print(GConstants.Login.titlePassowrd);
		String password = sc.next();
		DataService.userInfo.Builder request = DataService.userInfo.newBuilder();
		request.setId(id).setPassword(password);
		DataService.Token response = loginStub.login(request.build());
		token = response.getToken();
		if(response.getLogin()) {
			System.out.println(GConstants.Login.titleSuccess);
		} else {
			System.out.println(GConstants.Login.titleFail);
		}
		return response.getLogin();
	}
	public void printMenu() {
		for(GConstants.MenuPrint menu : GConstants.MenuPrint.values()) {
			System.out.println(menu.getPrintString());
		}
	}
	public dataBlockingStub contectLoginChannel() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(GConstants.ServerInfo.serverAddress, GConstants.ServerInfo.loginPort).usePlaintext().build();
		dataGrpc.dataBlockingStub stub = dataGrpc.newBlockingStub(channel);
		return stub;
	}
	public dataBlockingStub contectChannel() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(GConstants.ServerInfo.serverAddress, GConstants.ServerInfo.serverPort).usePlaintext().build();
		dataGrpc.dataBlockingStub stub = dataGrpc.newBlockingStub(channel);
		return stub;
	}
	public String getAllStudentDataToString(dataGrpc.dataBlockingStub stub) {
		DataService.Empty request = DataService.Empty.newBuilder().setToken(token).build();
		DataService.StudentResponse response = stub.getAllStudentData(request);
		String string = "";
		for (Student student : response.getStudentList()) {
			string += student.getStudentId() + " " + student.getName() + " " + student.getDepartment();
			for(String temp : student.getCompletedCoursesList()) {
				string = string + " " + temp;
			}
			string = string + "\n";
		}
		return string;
	}
	public String addStudent(Scanner sc, dataGrpc.dataBlockingStub stub) {
		String dataInfo = "";
		System.out.print(GConstants.AddDeleteStudent.studentId);
		dataInfo += sc.next() + " ";
		System.out.print(GConstants.AddDeleteStudent.studentName);
		sc.nextLine();
		dataInfo += sc.nextLine() + " ";
		System.out.print(GConstants.AddDeleteStudent.studentDeqartment);
		dataInfo += sc.next() + " ";
		System.out.print(GConstants.AddDeleteStudent.completedCourses);
		sc.nextLine();
		dataInfo += sc.nextLine();
		DataService.dataInfo request = DataService.dataInfo.newBuilder().setStringDataInfo(eDataInfoIsSuccess.addStudent.getCode() + " " + dataInfo).setToken(token).build();
		DataService.IsSuccess response = stub.dataInfoIsSuccess(request);
		if(response.getIsSuccess()) {
			return GConstants.SuccessMessage.addSuccess;
		} else {
			return GConstants.SuccessMessage.addFail;
		}
	}
	public String deleteStudent(Scanner sc, dataGrpc.dataBlockingStub stub) {
		System.out.print(GConstants.AddDeleteStudent.deleteStudentId);
		String dataInfo = sc.next();
		DataService.dataInfo request = DataService.dataInfo.newBuilder().setStringDataInfo(eDataInfoIsSuccess.deleteStudent+ " " + dataInfo).setToken(token).build();
		DataService.IsSuccess response = stub.dataInfoIsSuccess(request);
		if(response.getIsSuccess()) {
			return GConstants.SuccessMessage.deleteSuccess;
		} else {
			return GConstants.SuccessMessage.deleteFail;
		}
	}
	public String getAllCourseDataToString(dataGrpc.dataBlockingStub stub) {
		DataService.Empty request = DataService.Empty.newBuilder().setToken(token).build();
		DataService.CourseResponse response = stub.getAllCourseData(request);
		String string = "";
		for(Course course : response.getCourseList()) {
			string += course.getCourseId() + " " + course.getProfessor() + " " + course.getName();
			for(String temp : course.getPrerequisitesList()) {
				string += " " + temp;
			}
			string += "\n";
		}
		return string;
	}
	public String addCourse(Scanner sc, dataGrpc.dataBlockingStub stub) {
		String dataInfo = "";
		System.out.print(GConstants.AddDeleteCourse.courseId);
		dataInfo += sc.next() + " ";
		System.out.print(GConstants.AddDeleteCourse.professor);
		dataInfo += sc.next() + " ";
		System.out.print(GConstants.AddDeleteCourse.name);
		sc.nextLine();
		dataInfo += sc.nextLine() + " ";
		System.out.print(GConstants.AddDeleteCourse.prerequisites);
		dataInfo += sc.nextLine();
		DataService.dataInfo request = DataService.dataInfo.newBuilder().setStringDataInfo(eDataInfoIsSuccess.addCourse + " " + dataInfo).setToken(token).build();
		DataService.IsSuccess response = stub.dataInfoIsSuccess(request);
		if(response.getIsSuccess()) {
			return GConstants.SuccessMessage.addSuccess;
		} else {
			return GConstants.SuccessMessage.addFail;
		}
	}
	public String deleteCourse(Scanner sc, dataGrpc.dataBlockingStub stub) {
		System.out.print(GConstants.AddDeleteCourse.deleteCourseId);
		String dataInfo = sc.next();
		DataService.dataInfo request = DataService.dataInfo.newBuilder().setStringDataInfo(eDataInfoIsSuccess.deleteCourse + " " +dataInfo).setToken(token).build();
		DataService.IsSuccess response = stub.dataInfoIsSuccess(request);
		if(response.getIsSuccess()) {
			return GConstants.SuccessMessage.deleteSuccess;
		} else {
			return GConstants.SuccessMessage.deleteFail;
		}
	}
	public String enrolment(Scanner sc, dataGrpc.dataBlockingStub stub) {
		String dataInfo = "";
		for(Enrolment enrolment : Enrolment.values()) {
			System.out.print(enrolment.getPrintString());
			dataInfo += sc.next() + " ";
		}
		DataService.dataInfo request = DataService.dataInfo.newBuilder().setStringDataInfo(dataInfo).setToken(token).build();
		DataService.dataInfo response = stub.enrollment(request);
		for(EnrolmentResualt result : EnrolmentResualt.values()) {
			if(response.getStringDataInfo().matches(result.getCode())) {
				return result.getMessage();
			}
		}
		System.out.println(response.getStringDataInfo());
		return "Unkown Error";
	}
	public void setToken(String token) {this.token = token;}
}
