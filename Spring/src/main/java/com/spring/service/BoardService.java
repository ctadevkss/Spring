package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> listAll() throws Exception;      // 전체리스트
	
	public void create(BoardVO boardVO) throws Exception; // 등록
	
	public BoardVO read(Integer bno) throws Exception;    // 조회
	
	public void update(BoardVO boardVO) throws Exception; // 수정 
	
	public void delete(Integer bno) throws Exception;     // 삭제
		
}
