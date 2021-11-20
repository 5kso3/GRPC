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
  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.userInfo,
      com.data.grpc.DataService.Token> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.data.grpc.DataService.userInfo.class,
      responseType = com.data.grpc.DataService.Token.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.userInfo,
      com.data.grpc.DataService.Token> getLoginMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.userInfo, com.data.grpc.DataService.Token> getLoginMethod;
    if ((getLoginMethod = dataGrpc.getLoginMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getLoginMethod = dataGrpc.getLoginMethod) == null) {
          dataGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.userInfo, com.data.grpc.DataService.Token>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.userInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.Token.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.userInfo,
      com.data.grpc.DataService.IsSuccess> getSignUpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "signUp",
      requestType = com.data.grpc.DataService.userInfo.class,
      responseType = com.data.grpc.DataService.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.userInfo,
      com.data.grpc.DataService.IsSuccess> getSignUpMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.userInfo, com.data.grpc.DataService.IsSuccess> getSignUpMethod;
    if ((getSignUpMethod = dataGrpc.getSignUpMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getSignUpMethod = dataGrpc.getSignUpMethod) == null) {
          dataGrpc.getSignUpMethod = getSignUpMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.userInfo, com.data.grpc.DataService.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "signUp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.userInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.IsSuccess.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("signUp"))
                  .build();
          }
        }
     }
     return getSignUpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo,
      com.data.grpc.DataService.IsSuccess> getDataInfoIsSuccessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dataInfoIsSuccess",
      requestType = com.data.grpc.DataService.dataInfo.class,
      responseType = com.data.grpc.DataService.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo,
      com.data.grpc.DataService.IsSuccess> getDataInfoIsSuccessMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo, com.data.grpc.DataService.IsSuccess> getDataInfoIsSuccessMethod;
    if ((getDataInfoIsSuccessMethod = dataGrpc.getDataInfoIsSuccessMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getDataInfoIsSuccessMethod = dataGrpc.getDataInfoIsSuccessMethod) == null) {
          dataGrpc.getDataInfoIsSuccessMethod = getDataInfoIsSuccessMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.dataInfo, com.data.grpc.DataService.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "dataInfoIsSuccess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.dataInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.IsSuccess.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("dataInfoIsSuccess"))
                  .build();
          }
        }
     }
     return getDataInfoIsSuccessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty,
      com.data.grpc.DataService.StudentResponse> getGetAllStudentDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllStudentData",
      requestType = com.data.grpc.DataService.Empty.class,
      responseType = com.data.grpc.DataService.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty,
      com.data.grpc.DataService.StudentResponse> getGetAllStudentDataMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty, com.data.grpc.DataService.StudentResponse> getGetAllStudentDataMethod;
    if ((getGetAllStudentDataMethod = dataGrpc.getGetAllStudentDataMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getGetAllStudentDataMethod = dataGrpc.getGetAllStudentDataMethod) == null) {
          dataGrpc.getGetAllStudentDataMethod = getGetAllStudentDataMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.Empty, com.data.grpc.DataService.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "getAllStudentData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("getAllStudentData"))
                  .build();
          }
        }
     }
     return getGetAllStudentDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty,
      com.data.grpc.DataService.CourseResponse> getGetAllCourseDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCourseData",
      requestType = com.data.grpc.DataService.Empty.class,
      responseType = com.data.grpc.DataService.CourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty,
      com.data.grpc.DataService.CourseResponse> getGetAllCourseDataMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.Empty, com.data.grpc.DataService.CourseResponse> getGetAllCourseDataMethod;
    if ((getGetAllCourseDataMethod = dataGrpc.getGetAllCourseDataMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getGetAllCourseDataMethod = dataGrpc.getGetAllCourseDataMethod) == null) {
          dataGrpc.getGetAllCourseDataMethod = getGetAllCourseDataMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.Empty, com.data.grpc.DataService.CourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "getAllCourseData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.CourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("getAllCourseData"))
                  .build();
          }
        }
     }
     return getGetAllCourseDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo,
      com.data.grpc.DataService.dataInfo> getEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "enrollment",
      requestType = com.data.grpc.DataService.dataInfo.class,
      responseType = com.data.grpc.DataService.dataInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo,
      com.data.grpc.DataService.dataInfo> getEnrollmentMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo, com.data.grpc.DataService.dataInfo> getEnrollmentMethod;
    if ((getEnrollmentMethod = dataGrpc.getEnrollmentMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getEnrollmentMethod = dataGrpc.getEnrollmentMethod) == null) {
          dataGrpc.getEnrollmentMethod = getEnrollmentMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.dataInfo, com.data.grpc.DataService.dataInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "enrollment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.dataInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.dataInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("enrollment"))
                  .build();
          }
        }
     }
     return getEnrollmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo,
      com.data.grpc.DataService.IsSuccess> getIsRegisteredStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isRegisteredStudent",
      requestType = com.data.grpc.DataService.dataInfo.class,
      responseType = com.data.grpc.DataService.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo,
      com.data.grpc.DataService.IsSuccess> getIsRegisteredStudentMethod() {
    io.grpc.MethodDescriptor<com.data.grpc.DataService.dataInfo, com.data.grpc.DataService.IsSuccess> getIsRegisteredStudentMethod;
    if ((getIsRegisteredStudentMethod = dataGrpc.getIsRegisteredStudentMethod) == null) {
      synchronized (dataGrpc.class) {
        if ((getIsRegisteredStudentMethod = dataGrpc.getIsRegisteredStudentMethod) == null) {
          dataGrpc.getIsRegisteredStudentMethod = getIsRegisteredStudentMethod = 
              io.grpc.MethodDescriptor.<com.data.grpc.DataService.dataInfo, com.data.grpc.DataService.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "data", "isRegisteredStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.dataInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.data.grpc.DataService.IsSuccess.getDefaultInstance()))
                  .setSchemaDescriptor(new dataMethodDescriptorSupplier("isRegisteredStudent"))
                  .build();
          }
        }
     }
     return getIsRegisteredStudentMethod;
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
    public void login(com.data.grpc.DataService.userInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.Token> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void signUp(com.data.grpc.DataService.userInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getSignUpMethod(), responseObserver);
    }

    /**
     */
    public void dataInfoIsSuccess(com.data.grpc.DataService.dataInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getDataInfoIsSuccessMethod(), responseObserver);
    }

    /**
     */
    public void getAllStudentData(com.data.grpc.DataService.Empty request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllStudentDataMethod(), responseObserver);
    }

    /**
     */
    public void getAllCourseData(com.data.grpc.DataService.Empty request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.CourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCourseDataMethod(), responseObserver);
    }

    /**
     */
    public void enrollment(com.data.grpc.DataService.dataInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.dataInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getEnrollmentMethod(), responseObserver);
    }

    /**
     */
    public void isRegisteredStudent(com.data.grpc.DataService.dataInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getIsRegisteredStudentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.userInfo,
                com.data.grpc.DataService.Token>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getSignUpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.userInfo,
                com.data.grpc.DataService.IsSuccess>(
                  this, METHODID_SIGN_UP)))
          .addMethod(
            getDataInfoIsSuccessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.dataInfo,
                com.data.grpc.DataService.IsSuccess>(
                  this, METHODID_DATA_INFO_IS_SUCCESS)))
          .addMethod(
            getGetAllStudentDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.Empty,
                com.data.grpc.DataService.StudentResponse>(
                  this, METHODID_GET_ALL_STUDENT_DATA)))
          .addMethod(
            getGetAllCourseDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.Empty,
                com.data.grpc.DataService.CourseResponse>(
                  this, METHODID_GET_ALL_COURSE_DATA)))
          .addMethod(
            getEnrollmentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.dataInfo,
                com.data.grpc.DataService.dataInfo>(
                  this, METHODID_ENROLLMENT)))
          .addMethod(
            getIsRegisteredStudentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.data.grpc.DataService.dataInfo,
                com.data.grpc.DataService.IsSuccess>(
                  this, METHODID_IS_REGISTERED_STUDENT)))
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
    public void login(com.data.grpc.DataService.userInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.Token> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signUp(com.data.grpc.DataService.userInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void dataInfoIsSuccess(com.data.grpc.DataService.dataInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDataInfoIsSuccessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllStudentData(com.data.grpc.DataService.Empty request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.StudentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllStudentDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCourseData(com.data.grpc.DataService.Empty request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.CourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCourseDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void enrollment(com.data.grpc.DataService.dataInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.dataInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnrollmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isRegisteredStudent(com.data.grpc.DataService.dataInfo request,
        io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsRegisteredStudentMethod(), getCallOptions()), request, responseObserver);
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
    public com.data.grpc.DataService.Token login(com.data.grpc.DataService.userInfo request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.data.grpc.DataService.IsSuccess signUp(com.data.grpc.DataService.userInfo request) {
      return blockingUnaryCall(
          getChannel(), getSignUpMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.data.grpc.DataService.IsSuccess dataInfoIsSuccess(com.data.grpc.DataService.dataInfo request) {
      return blockingUnaryCall(
          getChannel(), getDataInfoIsSuccessMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.data.grpc.DataService.StudentResponse getAllStudentData(com.data.grpc.DataService.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllStudentDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.data.grpc.DataService.CourseResponse getAllCourseData(com.data.grpc.DataService.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCourseDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.data.grpc.DataService.dataInfo enrollment(com.data.grpc.DataService.dataInfo request) {
      return blockingUnaryCall(
          getChannel(), getEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.data.grpc.DataService.IsSuccess isRegisteredStudent(com.data.grpc.DataService.dataInfo request) {
      return blockingUnaryCall(
          getChannel(), getIsRegisteredStudentMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.Token> login(
        com.data.grpc.DataService.userInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.IsSuccess> signUp(
        com.data.grpc.DataService.userInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.IsSuccess> dataInfoIsSuccess(
        com.data.grpc.DataService.dataInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getDataInfoIsSuccessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.StudentResponse> getAllStudentData(
        com.data.grpc.DataService.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllStudentDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.CourseResponse> getAllCourseData(
        com.data.grpc.DataService.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCourseDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.dataInfo> enrollment(
        com.data.grpc.DataService.dataInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getEnrollmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.data.grpc.DataService.IsSuccess> isRegisteredStudent(
        com.data.grpc.DataService.dataInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getIsRegisteredStudentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_SIGN_UP = 1;
  private static final int METHODID_DATA_INFO_IS_SUCCESS = 2;
  private static final int METHODID_GET_ALL_STUDENT_DATA = 3;
  private static final int METHODID_GET_ALL_COURSE_DATA = 4;
  private static final int METHODID_ENROLLMENT = 5;
  private static final int METHODID_IS_REGISTERED_STUDENT = 6;

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
        case METHODID_LOGIN:
          serviceImpl.login((com.data.grpc.DataService.userInfo) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.Token>) responseObserver);
          break;
        case METHODID_SIGN_UP:
          serviceImpl.signUp((com.data.grpc.DataService.userInfo) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess>) responseObserver);
          break;
        case METHODID_DATA_INFO_IS_SUCCESS:
          serviceImpl.dataInfoIsSuccess((com.data.grpc.DataService.dataInfo) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.IsSuccess>) responseObserver);
          break;
        case METHODID_GET_ALL_STUDENT_DATA:
          serviceImpl.getAllStudentData((com.data.grpc.DataService.Empty) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.StudentResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSE_DATA:
          serviceImpl.getAllCourseData((com.data.grpc.DataService.Empty) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.CourseResponse>) responseObserver);
          break;
        case METHODID_ENROLLMENT:
          serviceImpl.enrollment((com.data.grpc.DataService.dataInfo) request,
              (io.grpc.stub.StreamObserver<com.data.grpc.DataService.dataInfo>) responseObserver);
          break;
        case METHODID_IS_REGISTERED_STUDENT:
          serviceImpl.isRegisteredStudent((com.data.grpc.DataService.dataInfo) request,
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
              .addMethod(getLoginMethod())
              .addMethod(getSignUpMethod())
              .addMethod(getDataInfoIsSuccessMethod())
              .addMethod(getGetAllStudentDataMethod())
              .addMethod(getGetAllCourseDataMethod())
              .addMethod(getEnrollmentMethod())
              .addMethod(getIsRegisteredStudentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
