package org.thecatrestapi.api.util;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The interface that download file;
 * 
 * @author Dima Volkovich
 *
 */
public interface IDownloader {
	
	/**
	 * Download file by url to the folder with given name;
	 * 
	 * @param url - the url for downloading;
	 * @param folderName - the name of folder where will download file;
	 * @param fileName - the name of download file;
	 * @return String - the file path to downloaded file;
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	String download(String url, String folderName, String fileName) throws FileNotFoundException, IOException;

}
