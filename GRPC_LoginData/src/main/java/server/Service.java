package server;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.data.grpc.DataService;
import com.data.grpc.DataService.Empty;
import com.data.grpc.DataService.IsSuccess;
import com.data.grpc.DataService.Login;
import com.data.grpc.DataService.LoginResponse;
import exeception.NullDataException;
import io.grpc.stub.StreamObserver;
import readData.LoginList;
import readData.Logins;

public class Service extends com.data.grpc.dataGrpc.dataImplBase{
	private LoginList loginList;
	public Service() {
		try {
			this.loginList = new LoginList("data/Login.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void getAllLogin(Empty request, StreamObserver<LoginResponse> responseObserver) {
		try {
			DataService.LoginResponse.Builder response = DataService.LoginResponse.newBuilder();
			ArrayList<Logins> dataList;
			dataList = this.loginList.getAllLoginRecords();
			ArrayList<Login> loginList = new ArrayList<Login>();
			for(Logins login : dataList) {
				loginList.add(Login.newBuilder().setId(login.getId()).setPassword(login.getPassword()).build());
			}
			response.addAllLogin(loginList);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addLogin(Login request, StreamObserver<IsSuccess> responseObserver) {
		DataService.IsSuccess.Builder response = DataService.IsSuccess.newBuilder();
		response.setIsSuccess(this.loginList.addLogin(request.getId() + " " +request.getPassword()));
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
