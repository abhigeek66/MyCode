package com.example.demo.dto;

public class BookDto {

	private String label;
	private String authorFamilyName;
	private String authorName;
	private Integer pageCount;

	public BookDto(String label, String authorFamilyName, String authorName, Integer pageCount) {
		this.label = label;
		this.authorFamilyName = authorFamilyName;
		this.authorName = authorName;
		this.pageCount = pageCount;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAuthorFamilyName() {
		return authorFamilyName;
	}

	public void setAuthorFamilyName(String authorFamilyName) {
		this.authorFamilyName = authorFamilyName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
}
