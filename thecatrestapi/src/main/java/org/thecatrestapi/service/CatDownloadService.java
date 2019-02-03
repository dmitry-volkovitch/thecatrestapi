package org.thecatrestapi.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thecatrestapi.api.service.ICatDownloadService;
import org.thecatrestapi.api.util.ICatParamParser;
import org.thecatrestapi.api.util.IDownloader;
import org.thecatrestapi.api.util.IUrlParser;
import org.thecatrestapi.dto.CatMainInfo;
import org.thecatrestapi.util.CatUrl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatDownloadService implements ICatDownloadService {
	private static final String THE_CAT_API_SEARCH_URL = "https://api.thecatapi.com/v1/images/search?";
	private static final String HEADER_NAME = "x-api-key";
	private static final String HEADER_VALUE = "31255f06-49d3-4889-a7d5-b607af395589";

	@Autowired
	private IDownloader downloader;
	@Autowired
	private IUrlParser urlParser;
	@Autowired
	private ICatParamParser catParamParser;

	@Override
	public String[] downloadCats(CatMainInfo catInfo) {
		try {
			String urlString = THE_CAT_API_SEARCH_URL + catParamParser.parseCatToParamString(catInfo);
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			URLConnection urlConnection = new URL(urlString).openConnection();
			urlConnection.addRequestProperty(HEADER_NAME, HEADER_VALUE);
			CatUrl[] catUrls = mapper.readValue(urlConnection.getInputStream(), CatUrl[].class);
			String[] fileNames = new String[catUrls.length];
			for (int i = 0; i < catUrls.length; i++) {
				String fileName = urlParser.getFileName(catUrls[i].getUrl());
				fileNames[i] = fileName;
				downloader.download(catUrls[i].getUrl(), fileName);
			}
			return fileNames;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
