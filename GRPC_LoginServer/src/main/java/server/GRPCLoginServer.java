package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCLoginServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(8000).addService(new Service()).build();
		server.start();
		System.out.println("Server started on " + server.getPort());
		server.awaitTermination();
	}
}
