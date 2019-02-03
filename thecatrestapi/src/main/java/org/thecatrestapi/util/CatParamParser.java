package org.thecatrestapi.util;

import org.springframework.stereotype.Component;
import org.thecatrestapi.api.util.ICatParamParser;
import org.thecatrestapi.dto.CatMainInfo;

@Component
public class CatParamParser implements ICatParamParser {
	private static final String COMMA = ",";
	private static final String AMPERSAND = "&";
	private static final String BREED_IDS = "breed_ids=";
	private static final String CATEGORY_IDS = "category_ids=";
	private static final String MIME_TYPES = "mime_types=";
	private static final String LIMIT = "limit=";

	@Override
	public String parseCatToParamString(CatMainInfo catInfo) {
		StringBuilder builder = new StringBuilder();
		if (catInfo.getBreedId() != null) {
			builder.append(BREED_IDS);
			builder.append(catInfo.getBreedId());
			builder.append(AMPERSAND);
		}
		if (catInfo.getCategoryIds() != null) {
			builder.append(CATEGORY_IDS);
			for (int i = 0; true; i++) {
				builder.append(catInfo.getCategoryIds()[i]);
				if (i == catInfo.getCategoryIds().length - 1) {
					break;
				}
				builder.append(COMMA);
			}
			builder.append(AMPERSAND);
		}
		if (catInfo.getFileTypes() != null) {
			builder.append(MIME_TYPES);
			for (int i = 0; true; i++) {
				builder.append(catInfo.getFileTypes()[i]);
				if (i == catInfo.getFileTypes().length - 1) {
					break;
				}
				builder.append(COMMA);
			}

			builder.append(AMPERSAND);
		}
		if (catInfo.getCount() != null) {
			builder.append(LIMIT);
			builder.append(catInfo.getCount());
		}
		return builder.toString();
	}

}
