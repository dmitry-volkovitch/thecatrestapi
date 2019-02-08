package org.thecatrestapi.api.util;

/**
 * The interface that parse url;
 * 
 * @author dima Volkovich
 *
 */
public interface IUrlParser {

	/**
	 * Parse given url and return the name of file in the end of the url;
	 * 
	 * @param url for parsing;
	 * @return String - file name.
	 */
	String getFileName(String url);
	
}
