package com.spring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
import com.spring.service.BoardService;

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
		redirectAtt.addFlashAttribute("msg-remove", "success"); // ${msg-remove}
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO boardVO, 
			                 RedirectAttributes redirectAtt) throws Exception {
		
		logger.info("modifyPOST()~~~~~~~~~~~~");
		service.update(boardVO);
		redirectAtt.addFlashAttribute("msg-update", "success"); // ${msg-update}
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listCri(Criteria criteria, Model model) throws Exception {
		logger.info("listCri()~~~~~~~~~~~~");
		// select bno, title, content, writer, regdate, viewcnt from tbl_board where bno > 0 order by 
		// bno desc, regdate desc limit 20, 20
		// BoradVO	
		model.addAttribute("list", service.listCriteria(criteria));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Criteria criteria, Model model) throws Exception {
		logger.info(criteria.toString());
		
		model.addAttribute("list", service.listCriteria(criteria));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(131); // 전체데이터 갯수

		model.addAttribute("pageMaker", pageMaker);
	}
	
}








