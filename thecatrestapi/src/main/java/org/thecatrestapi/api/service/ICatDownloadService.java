package org.thecatrestapi.api.service;

import org.thecatrestapi.dto.CatMainInfo;

public interface ICatDownloadService {

	String[] downloadCats(CatMainInfo catInfo);

}
