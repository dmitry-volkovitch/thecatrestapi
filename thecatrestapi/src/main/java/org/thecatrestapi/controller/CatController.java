package org.thecatrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thecatrestapi.api.service.ICatDownloadService;
import org.thecatrestapi.dto.CatMainInfo;

@RestController
public class CatController {

	@Autowired
	private ICatDownloadService catDownloadService;

	@PostMapping("cat")
	public Object downloadCat(@RequestBody CatMainInfo catInfo) {
		String[] ss = catDownloadService.downloadCats(catInfo);
		return ss;
	}
}
