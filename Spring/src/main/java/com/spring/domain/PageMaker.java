package com.spring.domain;

public class PageMaker {
	
	private int totalCount; // 전체 데이터 갯수 - SQL로 추출 
	private int startPage;  // 시작 페이지  
	private int endPage;    // 종료 페이지
	private boolean prev;   // 이전 페이지 유무
	private boolean next;   // 다음 페이지 유무

	private int displayPageNum = 10;
	
	private Criteria criteria; // cri , criteria
		
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setCri(Criteria criteria) {
		this.criteria = criteria;
	}
	
	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
		calData();
	}
	
	private void calData() {
		endPage = 
		(int)(Math.ceil(criteria.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = 
		(int)(Math.ceil(totalCount / (double) criteria.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
	}
}
