package server;

import com.data.grpc.DataService;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.Login;
import com.data.grpc.DataService.Token;
import com.data.grpc.DataService.userInfo;
import com.data.grpc.dataGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Service extends com.data.grpc.dataGrpc.dataImplBase{
	private dataGrpc.dataBlockingStub stub;
	public Service() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(GConstants.serverAddress, GConstants.port).usePlaintext().build();
		this.stub = dataGrpc.newBlockingStub(channel);
	}
	@Override
	public void login(userInfo request, StreamObserver<Token> responseObserver) {
		DataService.Token.Builder response = DataService.Token.newBuilder();
		DataService.Empty emptyRequest = DataService.Empty.newBuilder().build();
		DataService.LoginResponse loginResponse = stub.getAllLogin(emptyRequest);
		for(Login login : loginResponse.getLoginList()) {
			if(request.getId().matches(login.getId()) && request.getPassword().matches(login.getPassword())) {
				response.setToken(GConstants.successToken + " " + login.getId());
				response.setLogin(true);
				responseObserver.onNext(response.build());
				responseObserver.onCompleted();
				return;
			}
		}
		response.setToken(GConstants.failToken);
		response.setLogin(false);
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	@Override
	public void signUp(userInfo request, StreamObserver<IsSuccess> responseObserver) {
		DataService.Login loginRequest = DataService.Login.newBuilder().setId(request.getId()).setPassword(request.getPassword()).build();
		DataService.IsSuccess response = stub.addLogin(loginRequest);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
