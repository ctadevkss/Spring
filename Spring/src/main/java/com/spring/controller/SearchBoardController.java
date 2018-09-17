package com.spring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.PageMaker;
import com.spring.domain.SearchCriteria;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("criteria") SearchCriteria criteria,
			             Model model) throws Exception {
		
		logger.info(criteria.toString());
		model.addAttribute("list", service.listCriteria(criteria));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		
		pageMaker.setTotalCount(service.listCountCriteria(criteria)); // 전체데이터 갯수

		model.addAttribute("pageMaker", pageMaker);
		
	}	
}
