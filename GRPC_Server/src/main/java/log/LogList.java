package log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LogList {
	ArrayList<Log> vLog;
	public LogList(String date) {
		this.vLog = new ArrayList<Log>();
		this.initalize(new File("Log/" + date + ".txt"));
	}
	public void addLog(String date, String log) {
		this.vLog.add(new Log(log));
		this.writeFile(date);
	}
	private void writeFile(String date) {
		try {
			File file = new File("Log/" + date + ".txt");
			FileWriter fw = new FileWriter(file);
			for(Log log : this.vLog) {
				String line = "";
				line += log.getToken() + " " + log.getId() + " " + log.getCommandType() + " " + log.getTimeStamp();
				line += "\n";
				fw.write(line);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void initalize(File file) {
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String line = sc.nextLine();
				if(!line.equals("")) {
					this.vLog.add(new Log(line));
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			return;
		}
	}
}
