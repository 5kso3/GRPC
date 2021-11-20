package service;

import java.util.Scanner;

import com.data.grpc.DataService;
import com.data.grpc.DataService.Course;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;
import io.grpc.stub.StreamObserver;

public class AddCourse extends DataInfoIsSuccess{
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		DataService.Empty emptyResponse = DataService.Empty.newBuilder().build();
		DataService.CourseResponse courseResponse = stub.getAllCourseData(emptyResponse);
		Scanner sc = new Scanner(request.getStringDataInfo());
		String courseId = sc.next();
		for (Course course : courseResponse.getCourseList()) {
			if (courseId.matches(course.getCourseId())) {
				responseObserver.onNext(IsSuccess.newBuilder().setIsSuccess(false).build());
				responseObserver.onCompleted();
				return;
			}
		}
		DataService.IsSuccess response = stub.dataInfoIsSuccess(request);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
