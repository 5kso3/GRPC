package service;

import com.data.grpc.DataService;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;

import io.grpc.stub.StreamObserver;

public class DeleteStudent extends DataInfoIsSuccess{
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		DataService.IsSuccess response = stub.dataInfoIsSuccess(request);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
