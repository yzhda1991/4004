package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;

public class SystemLogger {
	
	File successLog;
	File errorLog;
	private static SystemLogger instance;
	
	public final static String _WORKING_DIR ="/Users/Yang/Desktop/4004_a3_workspace/com.4004.assignment3/src/logger";
	private static final String SUCCESS_LOG_FILE= _WORKING_DIR+"/successLog.txt";
	private static final String ERRO_LOG_FILE = _WORKING_DIR+"/errorLog.txt";
	
	private SystemLogger(){
		successLog = new File(SUCCESS_LOG_FILE);
		errorLog = new File(ERRO_LOG_FILE);
	}
	public static synchronized SystemLogger getInstance(){
		if(instance ==null){
			synchronized(SystemLogger.class){
				if(instance ==null){
					instance = new SystemLogger();
				}
			}
		}
		return instance;
	}

	public void WriteLog(Integer userid, int action, String description) {
		Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
		String logger = "{ " + action + ", " + userid + ", " + now + ", "
				+ description + " }";

		try {
			if (logger.toLowerCase().contains("Fail".toLowerCase())) {
				errorLogHelper(logger);

			} else if (logger.toLowerCase().contains("success".toLowerCase())) {
				SuccessLogHelper(logger);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void WriteLogtoAll(String description) {
		Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		String logger = " "+ now +" "+"**********" + description + " \n";

		try {   errorLogHelper(logger);

				SuccessLogHelper(logger);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	private boolean errorLogHelper(String line) throws IOException{
		if(errorLog==null||!errorLog.exists()) errorLog.createNewFile();
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(errorLog, true)))) {
		    out.println(line);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return true;
	}
	
	private boolean SuccessLogHelper(String line) throws IOException{
		if(successLog==null||!successLog.exists())successLog.createNewFile();
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(successLog, true)))) {
		    out.println(line);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return true;
	}
	public static void main(String args[]){
		SystemLogger.getInstance().WriteLogtoAll("startst");
	}
		
	
	
	

}
