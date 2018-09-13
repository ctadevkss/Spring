package com.spring.persistence;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception; // �Է�
	
	public void update(BoardVO vo) throws Exception; // ����
	
	public BoardVO read(Integer bno) throws Exception; // ����ȸ
	
	public void delete(Integer bno) throws Exception; // ����
		
	public List<BoardVO> listAll() throws Exception; // ��ü��ȸ(����Ʈ)
	
	public List<BoardVO> listPage(int page) throws Exception; // ����¡ ��ü��ȸ
	
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception; // ����¡ó�� Ŭ����
	
	public int countPaging(Criteria criteria) throws Exception; // ��ü������ ���� ��ȸ
	
}
