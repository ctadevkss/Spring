package com.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);  // 濡쒓퉭
	
	@Inject
	private BoardDAO dao;
		
	public void testUpdate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		boardVO.setTitle("첫번째 제목");
		boardVO.setContent("첫번째 내용");
		dao.update(boardVO);
	}
	
	
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	
	
	public void testCreate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("세번째 글제목");
		boardVO.setContent("세번째 내용");
		boardVO.setWriter("testID");
		dao.create(boardVO);
	}
	
	
	public void testDelete() throws Exception {
		dao.delete(3);
	}
	
	
	public void testlistAll() throws Exception {
		dao.listAll();
	}
	
	
	
	public void testListPage() throws Exception {
		int page = 0; // 1페이지(0,10) 2페이지(10,10) 3페이지(20,10)
		
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	
	@Test
	public void testListCriteria() throws Exception {
		
		Criteria criteria = new Criteria();
		criteria.setPage(2);
		
		/*
		 * public int getPageStart() {
				return (this.page - 1) * perPageNum; //  (2-1) * 20 = 20
			}
		 *
		 *  limit #{pageStart}, #{perPageNum}  // 20, 20
		 * 
		 */
			
		criteria.setPerPageNum(20);
		// 2page limit 20,20
		// select bno, title, content, writer, regdate, viewcnt from tbl_board where bno > 0 order by 
		// bno desc, regdate desc limit 20, 20 
		
		List<BoardVO> list = dao.listCriteria(criteria);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
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
	*/
	
	
	
	
	
	
	
	
	
	

}
