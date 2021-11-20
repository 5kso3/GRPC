package service;

import com.data.grpc.dataGrpc;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.dataInfo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public abstract class DataInfoIsSuccess {
	protected dataGrpc.dataBlockingStub stub;
	public DataInfoIsSuccess() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		this.stub = dataGrpc.newBlockingStub(channel);
	}
	public abstract void dataInfoIsSuccess(dataInfo request, StreamObserver<IsSuccess> responseObserver);
}
