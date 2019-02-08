package org.thecatrestapi.api.util.property;

import java.util.Map.Entry;
import java.util.Set;

/**
 * The interface that returns headers which must be used in request to www.thecatapi.com;
 * 
 * @author Dima Volkovich
 *
 */
public interface IHeaderProperties {
	
	/**
	 * Return value of header by name;
	 * 
	 * @param headerName
	 * @return String - value of header
	 */
	String getHeaderValue(String headerName);

	/**
	 * return all headers which must be define in application;
	 * 
	 * @return All headers.
	 */
	Set<Entry<Object, Object>> getAllHeaders();
	
}
