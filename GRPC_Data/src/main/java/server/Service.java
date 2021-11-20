package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.data.grpc.DataService;
import com.data.grpc.DataService.StudentResponse;
import com.data.grpc.DataService.dataInfo;
import exeception.NullDataException;
import com.data.grpc.DataService.Course;
import com.data.grpc.DataService.CourseResponse;
import com.data.grpc.DataService.Empty;
import com.data.grpc.DataService.Enrollment;
import com.data.grpc.DataService.EnrollmentResponse;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.Student;
import io.grpc.stub.StreamObserver;
import readData.Courses;
import readData.CoursesList;
import readData.EnrollmentList;
import readData.Enrollments;
import readData.StudentList;
import readData.Students;

public class Service extends com.data.grpc.dataGrpc.dataImplBase{
	private StudentList studentList;
	private CoursesList coursesList;
	private EnrollmentList enrollmentList;
	public Service() {
		try {
			this.studentList = new StudentList(GConstants.dataListLocation.studentList.getLocation());
			this.coursesList = new CoursesList(GConstants.dataListLocation.courseList.getLocation());
			this.enrollmentList = new EnrollmentList(GConstants.dataListLocation.enrollmentList.getLocation());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		Scanner sc = new Scanner(request.getStringDataInfo());
		String code = sc.next();
		String string = "";
		while(sc.hasNext()) {string = sc.nextLine().substring(1);}
		DataService.dataInfo stringRequest = DataService.dataInfo.newBuilder().setStringDataInfo(string).build();
		for(GConstants.eDataInfoIsSuccess service : GConstants.eDataInfoIsSuccess.values()) {
			if(code.matches(service.getCode())) {
				service.getService().setList(this);
				service.getService().dataInfoIsSuccess(stringRequest, responseObserver);
			}
		}
	}
	@Override
	public void getAllStudentData(Empty request, StreamObserver<StudentResponse> responseObserver) {
		try {
			DataService.StudentResponse.Builder response = DataService.StudentResponse.newBuilder();
			ArrayList<Students> dataList = new ArrayList<Students>();
			dataList = this.studentList.getAllStudentRecords();
			ArrayList<Student> studentList = new ArrayList<Student>();
			for (Students student : dataList) {
				studentList.add(Student.newBuilder().setStudentId(student.getStudentId()).setName(student.getName())
						.setDepartment(student.getDepartment()).addAllCompletedCourses(student.getCompletedCoursesList())
						.build());
			}
			response.addAllStudent(studentList);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void getAllCourseData(Empty request, StreamObserver<CourseResponse> responseObserver) {
		try {
			DataService.CourseResponse.Builder response = DataService.CourseResponse.newBuilder();
			ArrayList<Courses> dataList = this.coursesList.getAllCourseRecords();
			ArrayList<Course> courseList = new ArrayList<Course>();
			for (Courses course : dataList) {
				courseList.add(Course.newBuilder().setCourseId(course.getCourseId()).setProfessor(course.getProfessor())
						.setName(course.getName()).addAllPrerequisites(course.getPrerequisitesList()).build());
			}
			response.addAllCourse(courseList);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void getStudent(dataInfo request, StreamObserver<Student> responseObserver) {
		DataService.Student.Builder response = DataService.Student.newBuilder();
		Students student = this.studentList.getRegisteredStudent(request.getStringDataInfo());
		if(student == null) {response.setStudentId(GConstants.nullData);} 
		else {
			response.setStudentId(student.getStudentId())
			.setName(student.getName())
			.setDepartment(student.getDepartment())
			.addAllCompletedCourses(student.getCompletedCoursesList());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	@Override
	public void getCourse(dataInfo request, StreamObserver<Course> responseObserver) {
		DataService.Course.Builder response = DataService.Course.newBuilder();
		Courses course = this.coursesList.getRegisteredCourse(request.getStringDataInfo());
		if(course == null) {response.setCourseId(GConstants.nullData);}
		else {
			response.setCourseId(course.getCourseId())
			.setProfessor(course.getProfessor())
			.setName(course.getName())
			.addAllPrerequisites(course.getPrerequisitesList());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	@Override
	public void getAllEnrollmentData(Empty request, StreamObserver<EnrollmentResponse> responseObserver) {
		try {
			DataService.EnrollmentResponse.Builder response = DataService.EnrollmentResponse.newBuilder();
			ArrayList<Enrollments> dataList = this.enrollmentList.getAllEnrollmentRecords();
			ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
			for(Enrollments enrollment : dataList) {
				enrollmentList.add(Enrollment.newBuilder().setStudentId(enrollment.getStudnetId()).setCourseId(enrollment.getCourseId()).build());
			}
			response.addAllEnrollment(enrollmentList);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}
	public StudentList getStudentList() {return this.studentList;}
	public CoursesList getCoursesList() {return this.coursesList;}
	public EnrollmentList getEnrollmentList() {return this.enrollmentList;}
}