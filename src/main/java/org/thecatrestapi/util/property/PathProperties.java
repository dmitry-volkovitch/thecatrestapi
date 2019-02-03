package org.thecatrestapi.util.property;

import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.property.IPathProperties;

@Component
public class PathProperties implements IPathProperties {
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
			//
			e.printStackTrace();
			properties = new Properties(DEFAULT_PROPERTIES);
		}
	}
	
	public PathProperties(String pathToProperties) {
		try {
			properties = PropertiesLoader.load(pathToProperties);
		} catch (IOException e) {
			//
			e.printStackTrace();
			properties = new Properties(DEFAULT_PROPERTIES);
		}
	}

	@Override
	public String getPathToImages() {
		return properties.getProperty(PATH_TO_IMAGES);
	}

}
