package org.thecatrestapi.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thecatrestapi.api.service.ICatDownloadService;
import org.thecatrestapi.api.util.IDownloader;
import org.thecatrestapi.api.util.IUrlParser;
import org.thecatrestapi.api.util.property.IHeaderProperties;
import org.thecatrestapi.api.util.property.IPathProperties;
import org.thecatrestapi.api.util.property.ISearchProperties;
import org.thecatrestapi.domain.CatSearchQuery;
import org.thecatrestapi.dto.CatMainInfo;
import org.thecatrestapi.util.CatUrl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatDownloadService implements ICatDownloadService {
	private static final String HEADER_NAME = "x-api-key";

	@Autowired
	private IDownloader downloader;
	@Autowired
	private IUrlParser urlParser;
	@Autowired
	private ISearchProperties searchProperties;
	@Autowired
	private IPathProperties pathProperties;
	@Autowired
	private IHeaderProperties headerProperties;

	private ObjectMapper mapper;

	{
		mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public String[] downloadCats(CatMainInfo catInfo) {
		try {
			CatSearchQuery searchQuery = new CatSearchQuery(catInfo, searchProperties);
			URLConnection urlConnection = new URL(searchQuery.initQuery()).openConnection();
			urlConnection.addRequestProperty(HEADER_NAME, headerProperties.getHeaderValue(HEADER_NAME));

			CatUrl[] catUrls = mapper.readValue(urlConnection.getInputStream(), CatUrl[].class);
			String[] fileNames = new String[catUrls.length];
			for (int i = 0; i < catUrls.length; i++) {
				String fileName = urlParser.getFileName(catUrls[i].getUrl());
				fileNames[i] = downloader.download(catUrls[i].getUrl(), pathProperties.getPathToImages(), fileName);
			}
			return fileNames;
		} catch (MalformedURLException e) {
			//
			e.printStackTrace();
		} catch (IOException e) {
			//
			e.printStackTrace();
		}
		return null;
	}
}
