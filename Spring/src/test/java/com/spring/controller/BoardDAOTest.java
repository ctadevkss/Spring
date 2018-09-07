package com.spring.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.domain.BoardVO;
import com.spring.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);  // 로깅
	
	@Inject
	private BoardDAO dao;
		
	
	public void testUpdate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		boardVO.setTitle("ù��° ����");
		boardVO.setContent("ù��° ����");
		dao.update(boardVO);
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	
	
	public void testCreate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("����° ������");
		boardVO.setContent("����° ����");
		boardVO.setWriter("testID");
		dao.create(boardVO);
	}
	
	
	public void testDelete() throws Exception {
		dao.delete(3);
	}
	
	@Test
	public void testlistAll() throws Exception {
		dao.listAll();
	}

}
