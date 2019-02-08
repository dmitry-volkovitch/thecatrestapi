package org.thecatrestapi.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.IDownloader;
import org.thecatrestapi.api.util.property.IHeaderProperties;

@Component
public class Downloader implements IDownloader {
	private static final String REQUEST_PROPERTY_HEADER = "User-Agent";

	@Autowired
	private IHeaderProperties headerProperties;

	@Override
	public String download(String url, String folderName, String fileName) throws FileNotFoundException, IOException {
		File file = new File(folderName);
		if (!file.exists()) {
			file.mkdirs();
		}
		URLConnection openConnection = new URL(url).openConnection();
		openConnection.addRequestProperty(REQUEST_PROPERTY_HEADER,
				headerProperties.getHeaderValue(REQUEST_PROPERTY_HEADER));
		file = new File(folderName + fileName);
		try (BufferedInputStream in = new BufferedInputStream(openConnection.getInputStream());
				FileOutputStream fileOutputStream = new FileOutputStream(folderName + fileName)) {
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}

		}
		return file.getAbsolutePath();
	}

}
