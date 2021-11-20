package log;

import java.util.Scanner;

public class Log {
	private String token;
	private String id;
	private String commandType;
	private String timeStamp;
	public Log(String log) {
		Scanner sc = new Scanner(log);
		this.token = sc.next();
		this.id = sc.next();
		this.commandType = sc.next();
		String date = sc.next();
		String time = sc.next();
		this.timeStamp = date + " " + time;
	}
	public String getToken() {return token;}
	public String getId() {return id;}
	public String getCommandType() {return commandType;}
	public String getTimeStamp() {return timeStamp;}
}
