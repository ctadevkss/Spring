package com.spring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.PageMaker;
import com.spring.domain.SearchCriteria;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	// ���
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.info("register get~~~~~~~~~~~~~~~~");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO boardVO, 
			                   RedirectAttributes reAttr) throws Exception {
		
		logger.info("register post~~~~~~~~~~~~~~~");
		logger.info(boardVO.toString());
		
		service.create(boardVO);
		reAttr.addFlashAttribute("msg", "success");
		
		return "redirect:/sboard/list";
	}
	
	
	// �Խñ� ����Ʈ
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("criteria") SearchCriteria criteria,
			             Model model) throws Exception {
		
		logger.info(criteria.toString());
		//model.addAttribute("list", service.listCriteria(criteria));
		model.addAttribute("list", service.listSearchCriteria(criteria));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		
		//pageMaker.setTotalCount(service.listCountCriteria(criteria)); // ��ü������ ����
		pageMaker.setTotalCount(service.listSearchCount(criteria)); // �˻����ǿ� ����
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	// ����ȸ
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, 
			         @ModelAttribute("criteria") SearchCriteria criteria, 
			         Model model) throws Exception {
		
		model.addAttribute(service.read(bno));	
	}
	
	// ����
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, 
			             SearchCriteria criteria, 
			             RedirectAttributes reAttr) throws Exception {
		
		service.delete(bno);
		
		reAttr.addAttribute("page"      , criteria.getPage());
		reAttr.addAttribute("perPageNum", criteria.getPerPageNum());
		reAttr.addAttribute("searchType", criteria.getSearchType());
		reAttr.addAttribute("keyword"   , criteria.getKeyword());
		reAttr.addFlashAttribute("msg"  , "success");
				
		return "redirect:/sboard/list";
	}
	
	// ������
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyGET(int bno, 
			              @ModelAttribute("criteria") SearchCriteria criteria,
			              Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	// ����
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPOST(BoardVO boardVO, SearchCriteria criteria, 
			               RedirectAttributes reAttr) throws Exception {
		
		logger.info(criteria.toString());
		service.update(boardVO);
		
		reAttr.addAttribute("page"      , criteria.getPage());
		reAttr.addAttribute("perPageNum", criteria.getPerPageNum());
		reAttr.addAttribute("searchType", criteria.getSearchType());
		reAttr.addAttribute("keyword"   , criteria.getKeyword());
		reAttr.addFlashAttribute("msg"  , "success");
		
		logger.info("reAttr.toString(): " + reAttr.toString());
		
		return "redirect:/sboard/list";
		
	}
	
}
