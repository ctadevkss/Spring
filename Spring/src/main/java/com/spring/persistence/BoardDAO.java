package com.spring.persistence;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception; // 입력
	
	public void update(BoardVO vo) throws Exception; // 수정
	
	public BoardVO read(Integer bno) throws Exception; // 상세조회
	
	public void delete(Integer bno) throws Exception; // 삭제
		
	public List<BoardVO> listAll() throws Exception; // 전체조회(리스트)
	
	public List<BoardVO> listPage(int page) throws Exception; // 페이징 전체조회
	
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception; // 페이징처리 클래스
	
	public int countPaging(Criteria criteria) throws Exception; // 전체데이터 개수 조회
	
}
