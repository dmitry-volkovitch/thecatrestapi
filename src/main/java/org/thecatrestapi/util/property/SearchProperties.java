package org.thecatrestapi.util.property;

import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.property.ISearchProperties;
import org.thecatrestapi.domain.Order;

@Component
public class SearchProperties implements ISearchProperties {
	private static final String PATH_TO_PROPERTIES = "src/main/resources/search_url.properties";

	private static final String SEARCH_URL = "searchUrl";
	private static final String LIMIT = "limit";
	private static final String PAGE = "page";
	private static final String ORDER = "order";

	private static final Properties DEFAULT_PROPERTIES;

	private Properties properties;

	static {
		DEFAULT_PROPERTIES = new Properties();
		DEFAULT_PROPERTIES.setProperty(SEARCH_URL, "https://api.thecatapi.com/v1/images/search");
	}

	public SearchProperties() {
		try {
			properties = PropertiesLoader.load(PATH_TO_PROPERTIES);
		} catch (IOException e) {
			//
			e.printStackTrace();
			properties = new Properties(DEFAULT_PROPERTIES);
		}
	}

	public SearchProperties(String pathToProperties) {
		try {
			properties = PropertiesLoader.load(pathToProperties);
		} catch (IOException e) {
			//
			e.printStackTrace();
			properties = new Properties(DEFAULT_PROPERTIES);
		}
	}

	@Override
	public String getSearchUrl() {
		return properties.getProperty(SEARCH_URL);
	}

	@Override
	public Integer getLimit() {
		String prop = properties.getProperty(LIMIT);
		return prop == null ? null : Integer.parseInt(prop);
	}

	@Override
	public Integer getPage() {
		String prop = properties.getProperty(PAGE);
		return prop == null ? null : Integer.parseInt(prop);
	}

	@Override
	public Order getOrder() {
		String prop = properties.getProperty(ORDER);
		return prop == null ? null : Order.valueOf(prop);
	}
}
