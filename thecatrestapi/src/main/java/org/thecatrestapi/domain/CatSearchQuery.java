package org.thecatrestapi.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.thecatrestapi.api.util.property.ISearchProperties;
import org.thecatrestapi.dto.CatMainInfo;

public class CatSearchQuery {
	private static final String COMMA = ",";
	private static final String AMPERSAND = "&";
	private static final String QUESTION_MARK = "?";
	private static final String LIMIT = "limit=";
	private static final String PAGE = "page=";
	private static final String ORDER = "order=";
	private static final String BREED_IDS = "breed_ids=";
	private static final String CATEGORY_IDS = "category_ids=";
	private static final String MIME_TYPES = "mime_types=";

	private StringBuilder builder;

	private String searchUrl;

	private Integer limit;

	private Integer page;

	private CatBreedId breedIds;

	private List<Integer> categoryIds;

	private Set<FileType> mimeTypes;

	private Order order;

	public CatSearchQuery() {

	}

	public CatSearchQuery(CatMainInfo catInfo) {
		breedIds = catInfo.getBreedId();
		categoryIds = Arrays.asList(catInfo.getCategoryIds());
		mimeTypes = new HashSet<FileType>(Arrays.asList(catInfo.getFileTypes()));
	}

	public CatSearchQuery(CatMainInfo catInfo, ISearchProperties properties) {
		breedIds = catInfo.getBreedId();
		categoryIds = catInfo.getCategoryIds() != null ? Arrays.asList(catInfo.getCategoryIds()) : null;
		mimeTypes = catInfo.getFileTypes() != null ? new HashSet<FileType>(Arrays.asList(catInfo.getFileTypes()))
				: null;
		searchUrl = properties.getSearchUrl();
		limit = properties.getLimit();
		page = properties.getPage();
		order = properties.getOrder();
	}

	private String collectionToString(Collection<?> collection) {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (Object o : collection) {
			builder.append(o);
			i++;
			if (i == collection.size()) {
				break;
			}
			builder.append(COMMA);
		}
		return builder.toString();
	}

	public String initQuery() {
		builder = new StringBuilder(searchUrl);
		builder.append(QUESTION_MARK);
		if (limit != null) {
			builder.append(LIMIT);
			builder.append(limit);
			builder.append(AMPERSAND);
		}
		if (page != null) {
			builder.append(PAGE);
			builder.append(page);
			builder.append(AMPERSAND);
		}
		if (breedIds != null) {
			builder.append(BREED_IDS);
			builder.append(breedIds);
			builder.append(AMPERSAND);
		}
		if (categoryIds != null) {
			builder.append(CATEGORY_IDS);
			builder.append(collectionToString(categoryIds));
			builder.append(AMPERSAND);
		}
		if (mimeTypes != null) {
			builder.append(MIME_TYPES);
			builder.append(collectionToString(mimeTypes));
			builder.append(AMPERSAND);
		}
		if (order != null) {
			builder.append(ORDER);
			builder.append(order);
		}
		return builder.toString();
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public CatBreedId getBreedIds() {
		return breedIds;
	}

	public void setBreedIds(CatBreedId breedIds) {
		this.breedIds = breedIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public Set<FileType> getMimeTypes() {
		return mimeTypes;
	}

	public void setMimeTypes(Set<FileType> mimeTypes) {
		this.mimeTypes = mimeTypes;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getSearchUrl() {
		return searchUrl;
	}

	public void setSearchUrl(String baseUrl) {
		this.searchUrl = baseUrl;
	}

	@Override
	public String toString() {
		if (builder == null) {
			return null;
		}
		return builder.toString();
	}
}
