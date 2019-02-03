package org.thecatrestapi.api.util.property;

import org.thecatrestapi.domain.Order;

public interface ISearchProperties {

	String getSearchUrl();
	
	Integer getLimit();
	
	Integer getPage();
	
	Order getOrder();
	
}
