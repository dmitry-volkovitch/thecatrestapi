package org.thecatrestapi.util.property;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.property.IPathProperties;

@Component
public class PathProperties implements IPathProperties {
	private static final Logger LOGGER = LogManager.getLogger(PathProperties.class);
	private static final String LOG_MESSAGE = "IOException. Default properties have been loaded!";

	private static final String PATH_TO_PROPERTIES = "src/main/resources/download.properties";
	private static final String PATH_TO_IMAGES = "downloadPath";
	private static final Properties DEFAULT_PROPERTIES;

	static {
		DEFAULT_PROPERTIES = new Properties();
		DEFAULT_PROPERTIES.setProperty(PATH_TO_IMAGES, "src/main/resources/images/");
	}

	private Properties properties;

	public PathProperties() {
		try {
			properties = PropertiesLoader.load(PATH_TO_PROPERTIES);
		} catch (IOException e) {
			properties = new Properties(DEFAULT_PROPERTIES);
			LOGGER.warn(LOG_MESSAGE, e);
		}
	}

	public PathProperties(String pathToProperties) {
		try {
			properties = PropertiesLoader.load(pathToProperties);
		} catch (IOException e) {
			properties = new Properties(DEFAULT_PROPERTIES);
			LOGGER.warn(LOG_MESSAGE, e);
		}
	}

	@Override
	public String getPathToImages() {
		return properties.getProperty(PATH_TO_IMAGES);
	}

}
