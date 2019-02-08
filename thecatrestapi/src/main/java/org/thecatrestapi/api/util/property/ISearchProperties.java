package org.thecatrestapi.api.util.property;

import org.thecatrestapi.domain.Order;

/**
 * The interface that return default search params for query url;
 * 
 * @author Dima Volkovich
 *
 */
public interface ISearchProperties {

	/**
	 * Return base url where will search images (url where will add the others params);
	 * 
	 * @return String - url.
	 */
	String getSearchUrl();
	
	/**
	 * Return number of download images;
	 * 
	 * @return Integer - limit of images.
	 */
	Integer getLimit();
	
	/**
	 * Return number of page where will download images;
	 * 
	 * @return Integer - search page.
	 */
	Integer getPage();
	
	/**
	 * Return the order of images on the page;
	 * 
	 * @return Order - order of images;
	 */
	Order getOrder();
	
}
