package com.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);  // 로깅
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testURI() throws Exception {
		// ���������� �����ϴ� �߻�Ŭ���� (������������ ���) 
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		        
		logger.info(uriComponents.toString());
		// /board/read?bno=12&perPageNum=20
	}
	
	
	
	
	
	public void testUpdate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		boardVO.setTitle("ù��° ����");
		boardVO.setContent("ù��° ����");
		dao.update(boardVO);
	}
	
	
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
	
	
	public void testlistAll() throws Exception {
		dao.listAll();
	}
	
	
	
	public void testListPage() throws Exception {
		int page = 0; // 1������(0,10) 2������(10,10) 3������(20,10)
		
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	
	
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
	ex) 10���� �����͸� ����ϴ� ��� 
    1page  limit 0, 10
    2page  limit 10,10
    3page  limit 20,10
    
	20���� �����͸� ����ϴ� ��� 
    1page limit 0, 20 
    2page limit 20,20 
    3page limit 40,20 
	*/
	
	
	
	
	
	
	
	
	
	

}
