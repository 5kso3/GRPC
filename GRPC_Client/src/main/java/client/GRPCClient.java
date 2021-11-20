package client;

import java.util.Scanner;
import com.data.grpc.DataService;
import com.data.grpc.DataService.Course;
import com.data.grpc.DataService.Student;
import com.data.grpc.dataGrpc;
import com.data.grpc.dataGrpc.dataBlockingStub;
import client.GConstants.Enrolment;
import client.GConstants.EnrolmentResualt;
import client.GConstants.eDataInfoIsSuccess;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
	public static void main(String[] args) {
		Service service = new Service();
		dataGrpc.dataBlockingStub loginStub = service.contectLoginChannel();
		dataGrpc.dataBlockingStub stub = service.contectChannel();
		Scanner sc = new Scanner(System.in);
		String input = "";
		boolean isLogin = false;
		while(!isLogin) {
			service.printLoginMenu();
			input = sc.next();
			switch (input) {
			case GConstants.Login.login:
				isLogin = service.login(loginStub, sc);
				break;
			case GConstants.Login.signUp:
				service.signUp(stub, loginStub, sc);
				break;
			default :
				System.out.println(GConstants.Login.wrongInputMessage);
				break;
			}
		}
		while(!input.equals(GConstants.Menu.stop)) {
			service.printMenu();
			input = sc.next();
			switch (input) {
			case GConstants.Menu.studnetList:
				System.out.println(service.getAllStudentDataToString(stub));
				break;
			case GConstants.Menu.addStudent:
				System.out.println(service.addStudent(sc, stub));
				break;
			case GConstants.Menu.deleteStudent:
				System.out.println(service.deleteStudent(sc, stub));
				break;
			case GConstants.Menu.courseList:
				System.out.println(service.getAllCourseDataToString(stub));
				break;
			case GConstants.Menu.addCourse:
				System.out.println(service.addCourse(sc, stub));
				break;
			case GConstants.Menu.deleteCourse:
				System.out.println(service.deleteCourse(sc, stub));
				break;
			case GConstants.Menu.enrolment:
				System.out.println(service.enrolment(sc, stub));
				break;
			case GConstants.Menu.stop:
				System.out.println(GConstants.Menu.stopMessage);
				break;
			default:
				System.out.println(GConstants.Menu.wrongInputMessage);
				break;
			}
		}
	}
}