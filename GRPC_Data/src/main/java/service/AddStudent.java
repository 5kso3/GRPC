package service;

import com.data.grpc.DataService;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;
import io.grpc.stub.StreamObserver;

public class AddStudent extends DataInfoIsSuccess{
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		DataService.IsSuccess.Builder response = DataService.IsSuccess.newBuilder();
		response.setIsSuccess(this.service.getStudentList().addStudent(request.getStringDataInfo()));
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
