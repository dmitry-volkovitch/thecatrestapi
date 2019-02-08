package org.thecatrestapi.api.service;

import org.thecatrestapi.dto.CatMainInfo;

/**
 * The service interface for downloading cat's images.
 * 
 * @author Dima Volkovich
 *
 */
public interface ICatDownloadService {

	/**
	 * Download cats by search params.
	 * 
	 * @param catInfo - param that contains the main search info;
	 * @return String[] - array of file paths to cat's images on local PC.
	 */
	String[] downloadCats(CatMainInfo catInfo);

}
