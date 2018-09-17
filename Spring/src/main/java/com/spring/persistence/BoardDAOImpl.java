package com.spring.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private String namespace = "com.spring.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace + ".create", vo);		
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);	
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.update(namespace + ".delete", bno);	
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception {	
		return session.selectList(namespace + ".listCriteria", criteria);
	}

	@Override
	public int countPaging(Criteria criteria) throws Exception {
		return session.selectOne(namespace + ".countPaging", criteria);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria criteria) throws Exception {
			return session.selectList(namespace + ".listSearch", criteria);
	}

	@Override
	public int listSearchCount(SearchCriteria criteria) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", criteria);
	}
		
}




