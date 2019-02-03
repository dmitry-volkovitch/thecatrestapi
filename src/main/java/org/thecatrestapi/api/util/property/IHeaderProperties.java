package org.thecatrestapi.api.util.property;

import java.util.Map.Entry;
import java.util.Set;

public interface IHeaderProperties {
	
	String getHeaderValue(String headerName);

	Set<Entry<Object, Object>> getAllHeaders();
	
}
