package com.spring.domain;

public class Criteria {

	private int page;       // 현재 조회하는 페이지번호
	private int perPageNum; // 한 페이지당 출력되는 데이터의 개수
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		System.out.println("Criteria() ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}	
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
/*		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
	*/	
		this.perPageNum = perPageNum;
	}
	              
	public int getPageStart() {
		
		return (this.page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [현재 page=" + page + "," 
		     + "출력데이터갯수 perPgeeNum=" + perPageNum + "]"; 
	}
	/* 
	ex) 10개씩 데이터를 출력하는 경우 
    1page  limit 0, 10
    2page  limit 10,10
    3page  limit 20,10
    
    	20개씩 데이터를 출력하는 경우 
    1page limit 0, 20 
    2page limit 20,20 
    3page limit 40,20 
    
    시작데이터번호 = (페이지번호 - 1) * 페이지당 보여질 갯수
	*/
}
