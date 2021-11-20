package service;

import java.util.Scanner;

import com.data.grpc.DataService;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.Student;
import com.data.grpc.DataService.dataInfo;
import io.grpc.stub.StreamObserver;

public class AddStudent extends DataInfoIsSuccess{
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		DataService.Empty emptyResponse = DataService.Empty.newBuilder().build();
		DataService.StudentResponse studentResponse = stub.getAllStudentData(emptyResponse);
		Scanner sc = new Scanner(request.getStringDataInfo());
		sc.next();
		String studnetId = sc.next();
		for(Student student : studentResponse.getStudentList()) {
			if(studnetId.matches(student.getStudentId())) {
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
