package org.thecatrestapi.dto;

import java.io.Serializable;
import org.thecatrestapi.domain.CatBreedId;
import org.thecatrestapi.domain.FileType;


public class CatMainInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private CatBreedId breedId;

	private String[] categoryIds;

	private FileType[] fileTypes;

	private Integer count;

	public CatBreedId getBreedId() {
		return breedId;
	}

	public void setBreedId(CatBreedId breedId) {
		this.breedId = breedId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String[] getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String[] categoryIds) {
		this.categoryIds = categoryIds;
	}

	public FileType[] getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(FileType[] fileTypes) {
		this.fileTypes = fileTypes;
	}
}
