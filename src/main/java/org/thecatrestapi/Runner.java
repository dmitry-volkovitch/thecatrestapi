package org.thecatrestapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.thecatrestapi.util.Downloader;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(FileInputStream stream = new FileInputStream("src/main/resources/search_url.properties")){
			Properties prop = new Properties();
			prop.load(stream);
			System.out.println(prop.getProperty("searchUrl"));;
			prop.
		}
	}

}
