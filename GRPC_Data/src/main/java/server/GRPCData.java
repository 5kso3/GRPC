package server;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCData {
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(9090).addService(new Service()).build();
		server.start();
		System.out.println("Server started on " + server.getPort());
		server.awaitTermination();
	}
}
