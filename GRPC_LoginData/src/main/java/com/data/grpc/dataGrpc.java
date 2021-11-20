package com.data.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: DataService.proto")
public final class dataGrpc {

  private dataGrpc() {}

  public static final String SERVICE_NAME = "data";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty,
      com.data.grpc.DataService.LoginResponse> getGetAllLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllLogin",
      requestType = com.data.grpc.DataService.Empty.class,
      responseType = com.data.grpc.DataService.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty,
      com.data.grpc.DataService.LoginResponse> getGetAllLoginMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty, com.data.grpc.DataService.LoginResponse> getGetAllLoginMethod;
    if ((getGetAllLoginMethod = dataGrpc.getGetAllLoginMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getGetAllLoginMethod = dataGrpc.getGetAllLoginMethod) == null) {
          dataGrpc.getGetAllLoginMethod = getGetAllLoginMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.Empty, com.data.grpc.DataService.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "getAllLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("getAllLogin"))
                  .build();
          }
        }
     }
     return getGetAllLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.Login,
      com.data.grpc.DataService.IsSuccess> getAddLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addLogin",
      requestType = com.data.grpc.DataService.Login.class,
      responseType = com.data.grpc.DataService.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.Login,
      com.data.grpc.DataService.IsSuccess> getAddLoginMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.Login, com.data.grpc.DataService.IsSuccess> getAddLoginMethod;
    if ((getAddLoginMethod = dataGrpc.getAddLoginMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getAddLoginMethod = dataGrpc.getAddLoginMethod) == null) {
          dataGrpc.getAddLoginMethod = getAddLoginMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.Login, com.data.grpc.DataService.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "addLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.Login.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.IsSuccess.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("addLogin"))
                  .build();
          }
        }
     }
     return getAddLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static dataStub newStub(io.grpc.Channel channel) {
    return new dataStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static dataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new dataBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static dataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new dataFutureStub(channel);
  }

  /**
   */
  public static abstract class dataImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllLogin(com.data.grpc.DataService.Empty request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllLoginMethod(), responseObserver);
    }

    /**
     */
    public void addLogin(com.data.grpc.DataService.Login request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getAddLoginMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.Empty,
                com.data.grpc.DataService.LoginResponse>(
                  this, METHODID_GET_ALL_LOGIN)))
          .addMethod(
            getAddLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.Login,
                com.data.grpc.DataService.IsSuccess>(
                  this, METHODID_ADD_LOGIN)))
          .build();
    }
  }

  /**
   */
  public static final class dataStub extends io.grpc.stub.AbstractStub<dataStub> {
    private dataStub(io.grpc.Channel channel) {
      super(channel);
    }

    private dataStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected dataStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new dataStub(channel, callOptions);
    }

    /**
     */
    public void getAllLogin(com.data.grpc.DataService.Empty request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLogin(com.data.grpc.DataService.Login request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class dataBlockingStub extends io.grpc.stub.AbstractStub<dataBlockingStub> {
    private dataBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private dataBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected dataBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new dataBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.data.grpc.DataService.LoginResponse getAllLogin(com.data.grpc.DataService.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.data.grpc.DataService.IsSuccess addLogin(com.data.grpc.DataService.Login request) {
      return blockingUnaryCall(
          getChannel(), getAddLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class dataFutureStub extends io.grpc.stub.AbstractStub<dataFutureStub> {
    private dataFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private dataFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected dataFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new dataFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.LoginResponse> getAllLogin(
        com.data.grpc.DataService.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.IsSuccess> addLogin(
        com.data.grpc.DataService.Login request) {
      return futureUnaryCall(
          getChannel().newCall(getAddLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_LOGIN = 0;
  private static final int METHODID_ADD_LOGIN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final dataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(dataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_LOGIN:
          serviceImpl.getAllLogin((com.data.grpc.DataService.Empty) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.LoginResponse>) responseObserver);
          break;
        case METHODID_ADD_LOGIN:
          serviceImpl.addLogin((com.data.grpc.DataService.Login) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class dataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    dataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.data.grpc.DataService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("data");
    }
  }

  private static final class dataFileDescriptorSupplier
      extends dataBaseDescriptorSupplier {
    dataFileDescriptorSupplier() {}
  }

  private static final class dataMethodDescriptorSupplier
      extends dataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    dataMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (dataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new dataFileDescriptorSupplier())
              .addMethod(getGetAllLoginMethod())
              .addMethod(getAddLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
