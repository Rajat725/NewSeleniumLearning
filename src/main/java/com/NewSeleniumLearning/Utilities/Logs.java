package com.NewSeleniumLearning.Utilities;
import org.apache.logging.log4j.*;

public class Logs {
	
	public static Logger log=LogManager.getLogger(Logs.class.getName());
	
	public static void startTestCase(String sTestCaseName) {

		log.info("************************************ Test STarted **************************************");

		log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		log.info("****************************************************************************************");

	}

	public static void endTestCase(String sTestCaseName) {

		log.info("==========================================================================================");
		log.info("=====================================" + sTestCaseName
				+ " TEST END=========================================");
		log.info("==========================================================================================");
	}

	// Need to create below methods, so that they can be called

	public static void info(String message) {

		log.info(message);

	}

	public static void warn(String message) {

		log.warn(message);

	}

	public static void error(String message) {

		log.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + message + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}

	public static void fatal(String message) {

		log.fatal(message);

	}

	public static void debug(String message) {

		log.debug(message);

	}

}
