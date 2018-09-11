package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show listAll ~~~~~~~~~~~~~~~~~");
		model.addAttribute("list", service.listAll());
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO boardVO, Model model) throws Exception {
		logger.info("register GET~~~~~~~~");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO boardVO, RedirectAttributes redirectAtt) throws Exception {
		logger.info("register POST~~~~~~~~~~");
		
		service.create(boardVO); // 등록
		redirectAtt.addFlashAttribute("result", "success"); // ${result}
		
		//model.addAttribute("result", "success");
		
		return "redirect:/board/listAll";
		//return "/board/success"; // success.jsp 페이지 호출
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		//int bno = Integer.parseInt(request.getParameter("bno"));		
		model.addAttribute("boardVO", service.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, 
			              RedirectAttributes redirectAtt) throws Exception {
		
		service.delete(bno);
		redirectAtt.addFlashAttribute("msg-remove", "success"); // ${result}
		return "redirect:/board/listAll";
	}
}








