package readData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import exeception.NullDataException;

public class LoginList {
	protected ArrayList<Logins> vLogin;
	protected File file;
	public LoginList(String loginFileName) throws FileNotFoundException {
		this.file = new File(loginFileName);
		Scanner sc = new Scanner(file);
		this.vLogin = new ArrayList<Logins>();
		while(sc.hasNext()) {
			String curInfo = sc.nextLine();
			if(!curInfo.equals("")) {
				this.vLogin.add(new Logins(curInfo));
			}
		}
		sc.close();
	}
	public ArrayList<Logins> getAllLoginRecords() throws NullDataException {
		if(this.vLogin.size() == 0) throw new NullDataException("Login Data is Null");
		return this.vLogin;
	}
	public boolean addLogin(String loginInfo) {
		if(this.vLogin.add(new Logins(loginInfo))) {
			this.writeFile();
			return true;
		}
		return false;
	}
	private void writeFile() {
		try {
			FileWriter fw = new FileWriter(file);
			for(Logins login : this.vLogin) {
				String line = "";
				line += login.getId() + " " + login.getPassword() + "\n";
				fw.write(line);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
