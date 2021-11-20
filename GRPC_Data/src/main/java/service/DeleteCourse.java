package service;

import com.data.grpc.DataService;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;

import exeception.NullDataException;
import io.grpc.stub.StreamObserver;

public class DeleteCourse extends DataInfoIsSuccess{
	@Override
	public void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver) {
		try {
			DataService.IsSuccess.Builder response = DataService.IsSuccess.newBuilder();
			response.setIsSuccess(this.service.getCoursesList().deleteCourse(request.getStringDataInfo()));
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}
}
