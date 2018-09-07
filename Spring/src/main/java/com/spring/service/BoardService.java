package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> listAll() throws Exception;
}
