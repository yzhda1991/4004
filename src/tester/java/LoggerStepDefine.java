package tester.java;

import logger.SystemLogger;
import cucumber.api.java.en.Given;

public class LoggerStepDefine {
	
	
	@Given("^record Logger \"([^\"]*)\"$")
	public void record_Logger(String arg1) throws Throwable {
	   SystemLogger.getInstance().WriteLogtoAll(arg1);
	}
	
	

}
