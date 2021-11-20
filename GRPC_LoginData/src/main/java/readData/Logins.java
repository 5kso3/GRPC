package readData;

import java.io.Serializable;
import java.util.Scanner;

public class Logins implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String password;
	public Logins(String inputString) {
		Scanner sc = new Scanner(inputString);
		this.id = sc.next();
		this.password = sc.next();
	}
	public String getId() {return id;}
	public String getPassword() {return password;}
}
