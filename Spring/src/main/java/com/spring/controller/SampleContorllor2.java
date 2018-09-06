package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.ProductVO;

@Controller
public class SampleContorllor2 {

	private static final Logger logger = LoggerFactory.getLogger(SampleContorllor2.class);  // 로깅
	
	@RequestMapping("/doD")
	public String doD(Model model) {
		
		ProductVO productVO = new ProductVO("드론", 170000);
		logger.info("/doD ~~~~~~~~~~~~~~~~~~~~~~~~~");
		logger.info("product.toString()" + productVO);
		model.addAttribute(productVO);
		return "productDetail";
		
	}
}
