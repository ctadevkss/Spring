package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> listAll() throws Exception;      // ��ü����Ʈ
	
	public void create(BoardVO boardVO) throws Exception; // ���
	
	public BoardVO read(Integer bno) throws Exception;    // ��ȸ
	
	public void update(BoardVO boardVO) throws Exception; // ���� 
	
	public void delete(Integer bno) throws Exception;     // ����
		
}
