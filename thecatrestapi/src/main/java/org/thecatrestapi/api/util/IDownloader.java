package org.thecatrestapi.api.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IDownloader {
	
	String download(String url, String folderName, String fileName) throws FileNotFoundException, IOException;

}
