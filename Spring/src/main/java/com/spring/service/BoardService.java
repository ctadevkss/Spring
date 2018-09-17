package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public interface BoardService {
	
	public void create(BoardVO boardVO) throws Exception; // ���
	
	public BoardVO read(Integer bno) throws Exception;    // ��ȸ
	
	public void update(BoardVO boardVO) throws Exception; // ���� 
	
	public void delete(Integer bno) throws Exception;     // ����
	
	public List<BoardVO> listAll() throws Exception;      // ��ü����Ʈ
	
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception; // ����¡ Ŭ����
	
	public int listCountCriteria(Criteria criteria) throws Exception; // ��ü������ ���� ��ȸ
	
	public List<BoardVO> listSearchCriteria(SearchCriteria criteria) throws Exception;
	
	public int listSearchCount(SearchCriteria criteria) throws Exception;
	
	
	
	
	
	
		
}
