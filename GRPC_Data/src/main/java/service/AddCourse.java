package service;

import com.data.grpc.DataService;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;
import io.grpc.stub.StreamObserver;

public class AddCourse extends DataInfoIsSuccess{
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		DataService.IsSuccess.Builder response = DataService.IsSuccess.newBuilder();
		response.setIsSuccess(this.service.getCoursesList().addCourse(request.getStringDataInfo()));
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
