package org.thecatrestapi;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	private static final Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		LOGGER.info("TEST LOGGER INFO");
		LOGGER.debug("sdffd");
		LOGGER.error("MESSAGE", new Exception("test exception"));
	}

}
