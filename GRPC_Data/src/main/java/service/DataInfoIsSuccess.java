package service;

import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;
import io.grpc.stub.StreamObserver;
import readData.CoursesList;
import readData.EnrollmentList;
import readData.StudentList;
import server.Service;

public abstract class DataInfoIsSuccess {
	protected Service service;
	public abstract void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver);
	public void setList(Service service) {
		this.service = service;
	}
}