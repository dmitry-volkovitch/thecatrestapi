package org.thecatrestapi.util.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

	public static Properties load(String path) throws FileNotFoundException, IOException {
		try (FileInputStream inStream = new FileInputStream(path)) {
			Properties prop = new Properties();
			prop.load(inStream);
			return prop;
		}
	}

}
