package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);  // 로깅
	
	@RequestMapping("doC") // http://localhost:8080/controller/doC
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called...................msg :" + msg);
		
		return "result";  // result.jsp
	}
}
