package org.thecatrestapi.dto;

import java.io.Serializable;

import org.thecatrestapi.domain.CatBreedId;
import org.thecatrestapi.domain.FileType;

public class CatMainInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private CatBreedId breedId;

	private Integer[] categoryIds;

	private FileType[] fileTypes;

	public CatBreedId getBreedId() {
		return breedId;
	}

	public void setBreedId(CatBreedId breedId) {
		this.breedId = breedId;
	}

	public FileType[] getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(FileType[] fileTypes) {
		this.fileTypes = fileTypes;
	}

	public Integer[] getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Integer[] categoryIds) {
		this.categoryIds = categoryIds;
	}
}
