package com.spring.domain;

public class SearchCriteria extends Criteria{

	private String searchType;
	private String keyword;
	
	public SearchCriteria() {
		System.out.println("SearchCriteria()~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
		
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +
				"SearchCriteria" + "[searchType=" + searchType + 
				", keyword=" + keyword + "]";
	}
	
}
