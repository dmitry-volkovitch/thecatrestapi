package org.thecatrestapi.api.util;

import org.thecatrestapi.dto.CatMainInfo;

public interface ICatParamParser {

	String parseCatToParamString(CatMainInfo catInfo);
	
}
