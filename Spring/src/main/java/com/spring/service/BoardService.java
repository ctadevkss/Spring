package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardService {
	
	public void create(BoardVO boardVO) throws Exception; // 등록
	
	public BoardVO read(Integer bno) throws Exception;    // 조회
	
	public void update(BoardVO boardVO) throws Exception; // 수정 
	
	public void delete(Integer bno) throws Exception;     // 삭제
	
	public List<BoardVO> listAll() throws Exception;      // 전체리스트
	
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception; // 페이징 클래스
	
	public int listCountCriteria(Criteria criteria) throws Exception; // 전체데이터 개수 조회
		
}
