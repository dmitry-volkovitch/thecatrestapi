package org.thecatrestapi.util;

import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.IUrlParser;

@Component
public class UrlParser implements IUrlParser {
	private static final String separator = "/";

	@Override
	public String getFileName(String url) {
		String[] str = url.split(separator);
		return str[4];
	}
}
