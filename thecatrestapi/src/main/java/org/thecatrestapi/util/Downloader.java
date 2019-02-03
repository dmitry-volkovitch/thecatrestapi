package org.thecatrestapi.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.IDownloader;

@Component
public class Downloader implements IDownloader {
	private static final String RESOURCES_PATH = "src/main/resources/images/";
	private static final String REQUEST_PROPERTY_HEADER = "User-Agent";
	private static final String REQUEST_PROPERTY_BODY = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";

	@Override
	public String download(String url, String fileName) throws FileNotFoundException, IOException {
		File file = new File(RESOURCES_PATH);
		if(!file.exists()) {
			file.mkdirs();
		}
		URLConnection openConnection = new URL(url).openConnection();
		openConnection.addRequestProperty(REQUEST_PROPERTY_HEADER, REQUEST_PROPERTY_BODY);
		try (BufferedInputStream in = new BufferedInputStream(openConnection.getInputStream());
				FileOutputStream fileOutputStream = new FileOutputStream(RESOURCES_PATH + fileName)) {
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
		}
		return file.getAbsolutePath();
	}

}
