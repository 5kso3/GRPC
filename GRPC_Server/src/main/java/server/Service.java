package server;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import com.data.grpc.DataService;
import com.data.grpc.dataGrpc;
import com.data.grpc.DataService.StudentResponse;
import com.data.grpc.DataService.dataInfo;
import com.data.grpc.DataService.dataInfo.Builder;
import com.data.grpc.DataService.Course;
import com.data.grpc.DataService.CourseResponse;
import com.data.grpc.DataService.Empty;
import com.data.grpc.DataService.Enrollment;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.Student;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import log.LogList;
import server.GConstants.ServerInfo;
import server.GConstants.eDataInfoIsSuccess;
import exeception.SecurityException;

public class Service extends com.data.grpc.dataGrpc.dataImplBase{
	private dataGrpc.dataBlockingStub stub;
	private LogList logList;
	public Service() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(GConstants.ServerInfo.serverAddress, GConstants.ServerInfo.port).usePlaintext().build();
		this.stub = dataGrpc.newBlockingStub(channel);
		this.logList = new LogList(LocalDate.now().toString());
	}
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		try {
			Scanner scn = new Scanner(request.getToken());
			String token = scn.next();
			if (!token.matches(GConstants.successToken)) {throw new SecurityException(GConstants.SercurityExceptionMessage);}
			Scanner sc = new Scanner(request.getStringDataInfo());
			String code = sc.next();
			for(eDataInfoIsSuccess service : eDataInfoIsSuccess.values()) {
				if(code.matches(service.getCode())) {
					this.logList.addLog(LocalDate.now().toString(), request.getToken() + " " + service.getCode() + " " + LocalDate.now().toString() + " " + LocalTime.now().toString());
					service.getService().dataInfoIsSuccess(request, responseObserver);
				}
			}
		} catch(SecurityException e) {e.printStackTrace();}
	}
	@Override
	public void getAllStudentData(Empty request, StreamObserver<StudentResponse> responseObserver) {
		try {
			Scanner scn = new Scanner(request.getToken());
			String token = scn.next();
			if (!token.matches(GConstants.successToken)) {throw new SecurityException(GConstants.SercurityExceptionMessage);}
			else{this.logList.addLog(LocalDate.now().toString(), request.getToken() + " " + GConstants.getAllStudentData + " " + LocalDate.now().toString() + " " + LocalTime.now().toString());}
			DataService.StudentResponse response = stub.getAllStudentData(request);
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} catch(SecurityException e) {e.printStackTrace();}
	}
	@Override
	public void getAllCourseData(Empty request, StreamObserver<CourseResponse> responseObserver) {
		try {
			Scanner scn = new Scanner(request.getToken());
			String token = scn.next();
			if (!token.matches(GConstants.successToken)) {throw new SecurityException(GConstants.SercurityExceptionMessage);}
			else{this.logList.addLog(LocalDate.now().toString(), request.getToken() + " " + GConstants.getAllCourseData + " " + LocalDate.now().toString() + " " + LocalTime.now().toString());}
			DataService.CourseResponse response = stub.getAllCourseData(request);
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} catch(SecurityException e) {e.printStackTrace();}
	}
	@Override
	public void enrollment(dataInfo request, StreamObserver<dataInfo> responseObserver) {
		try {
			Scanner scn = new Scanner(request.getToken());
			String token = scn.next();
			if (!token.matches(GConstants.successToken)) {throw new SecurityException(GConstants.SercurityExceptionMessage);}
			else{this.logList.addLog(LocalDate.now().toString(), request.getToken() + " " + GConstants.enrollment + " " + LocalDate.now().toString() + " " + LocalTime.now().toString());}
			DataService.dataInfo.Builder response = DataService.dataInfo.newBuilder();
			Scanner sc = new Scanner(request.getStringDataInfo());
			String studnetId = sc.next();
			DataService.dataInfo studentRequest = DataService.dataInfo.newBuilder().setStringDataInfo(studnetId).build();
			DataService.Student studentResponse = stub.getStudent(studentRequest);
			if(studentResponse.getStudentId().matches(GConstants.nullData)) {this.setEnrolmentErrorMassage(GConstants.errorStudnetId, response, responseObserver); return;	}
			String courseId = sc.next();
			DataService.dataInfo courseRequest = DataService.dataInfo.newBuilder().setStringDataInfo(courseId).build();
			DataService.Course courseResponse = stub.getCourse(courseRequest);
			if(courseResponse.getCourseId().matches(GConstants.nullData)) {this.setEnrolmentErrorMassage(GConstants.errorCourseId, response, responseObserver); return;}
			for(String completedCourse : studentResponse.getCompletedCoursesList()) {
			if(completedCourse.matches(courseResponse.getCourseId())) {	this.setEnrolmentErrorMassage(GConstants.errorCompltedCourse, response, responseObserver); return;}}
			if(this.checkPrerequisites(studentResponse, courseResponse)) {
			DataService.Empty emptyRequest = DataService.Empty.newBuilder().build();
			DataService.EnrollmentResponse getAllEnrollmentResponse = stub.getAllEnrollmentData(emptyRequest);
			for(Enrollment enrollment : getAllEnrollmentResponse.getEnrollmentList()) {
				if(studnetId.matches(enrollment.getStudentId()) && courseId.matches(enrollment.getCourseId())) {this.setEnrolmentErrorMassage(GConstants.errorAlreadyEnrollment, response, responseObserver); return;}
			}
			DataService.dataInfo temp = DataService.dataInfo.newBuilder().setStringDataInfo(GConstants.addEnrollment + " " + request.getStringDataInfo()).build();
			DataService.IsSuccess enrollmentResponse = stub.dataInfoIsSuccess(temp);
			if(enrollmentResponse.getIsSuccess()) {this.setEnrolmentErrorMassage(GConstants.success, response, responseObserver); return;}
			else {this.setEnrolmentErrorMassage(GConstants.errorSave, response, responseObserver); return;}
		} 
		else {this.setEnrolmentErrorMassage(GConstants.errorPrerequisites, response, responseObserver); return;}
		} catch(SecurityException e) {e.printStackTrace();}
	}
	@Override
	public void getStudent(dataInfo request, StreamObserver<Student> responseObserver) {
		DataService.Student response = stub.getStudent(request);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	@Override
	public void getCourse(dataInfo request, StreamObserver<Course> responseObserver) {
		DataService.Course response = stub.getCourse(request);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	private void setEnrolmentErrorMassage(String errorId, Builder response, StreamObserver<dataInfo> responseObserver) {
		response.setStringDataInfo(errorId);
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	private boolean checkPrerequisites(Student studentResponse, Course courseResponse) {
		boolean isDonePrerequisites = true;
		for(String prerequisite : courseResponse.getPrerequisitesList()) {
			if(isDonePrerequisites) {
				isDonePrerequisites = false;
				for(String completed : studentResponse.getCompletedCoursesList()) {
					if(prerequisite.matches(completed)) {isDonePrerequisites = true;}
				}
			}
		}
		return isDonePrerequisites;
	}
	@Override
	public void isRegisteredStudent(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		DataService.dataInfo studentRequest = DataService.dataInfo.newBuilder()
				.setStringDataInfo(request.getStringDataInfo()).build();
		DataService.Student studentResponse = stub.getStudent(studentRequest);
		DataService.IsSuccess.Builder response = DataService.IsSuccess.newBuilder();
		if (studentResponse.getStudentId().matches("-1")) {
			response.setIsSuccess(false);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} else {
			response.setIsSuccess(true);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}
	}
}