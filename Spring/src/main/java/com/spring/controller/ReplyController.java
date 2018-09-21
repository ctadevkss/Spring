package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
import com.spring.domain.ReplyVO;
import com.spring.service.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 

@RestController
@RequestMapping("/replies")
public class ReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private ReplyService service;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) { // JSON포멧
		
		logger.info("ResponseEntity<String> register()~~~~~~");
		
		ResponseEntity<String> entity = null;
		try{
			service.addReply(vo); // 댓글등록
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 특정게시글의 전체댓글목록
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno) {
		
		logger.info("ResponseEntity<List<ReplyVO>> list()~~~~~~");
		
		ResponseEntity<List<ReplyVO>> entity = null;
		try{
			entity = new ResponseEntity<>(service.listReply(bno),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	// 댓글수정
	@RequestMapping(value = "/{rno}", 
			        method = { RequestMethod.PUT, RequestMethod.PATCH}) 
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno,
			                             @RequestBody ReplyVO vo ) {
		
		ResponseEntity<String> entity = null;
		try{
			vo.setRno(rno);
			service.modifyReply(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace(); // 서버 콘솔
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	    // 댓글삭제
		@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
		public ResponseEntity<String> remove(@PathVariable("rno") Integer rno) {
						
			ResponseEntity<String> entity = null;
			
			try{
				service.removeReply(rno);
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace(); // 서버 콘솔
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}			
			
			return entity;
		}
		
		
	    // 댓글페이징
		@RequestMapping(value = "/{bno}/{page}", method = RequestMethod.GET)
		public ResponseEntity<Map<String, Object>> 
		listPage(@PathVariable("bno") Integer bno, @PathVariable("page") Integer page){
			
			ResponseEntity<Map<String, Object>> entity = null;
			
			try{
				Criteria criteria = new Criteria();
				criteria.setPage(page);
				
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCriteria(criteria);
				
				Map<String, Object> map = new HashMap<String,Object>();
				List<ReplyVO> list = service.listReplyPage(bno, criteria);
				
				map.put("list", list); // 댓글데이터 
				
				int replyCount = service.count(bno);
				pageMaker.setTotalCount(replyCount);
				
				map.put("pageMaker", pageMaker);
				
				entity = new ResponseEntity<Map<String, Object>>(HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
			}
									
			return entity;
		}
	
	
	
	
	
	
	
}