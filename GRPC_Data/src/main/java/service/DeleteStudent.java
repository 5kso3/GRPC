package service;

import com.data.grpc.DataService;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;

import exeception.NullDataException;
import io.grpc.stub.StreamObserver;

public class DeleteStudent extends DataInfoIsSuccess{
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		try {
			DataService.IsSuccess.Builder response = DataService.IsSuccess.newBuilder();
			response.setIsSuccess(this.service.getStudentList().deleteStudent(request.getStringDataInfo()));
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}
}
