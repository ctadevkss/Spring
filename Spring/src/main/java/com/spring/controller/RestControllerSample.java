package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.SampleVO;

@RestController
@RequestMapping("/sample")
public class RestControllerSample {
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	

	@RequestMapping("/sendVOMap")
	public Map<Integer,SampleVO> sendVOMap() {
		
		Map<Integer,SampleVO> map = new HashMap<>();
		
		for(int i=0; i<10; i++) {
			
			SampleVO vo = new SampleVO();
			vo.setFirstName("�浿");
			vo.setLastName("ȫ");
			vo.setMno(i);
		
			map.put(i, vo);
		}
		return map;
	}
	
		
	@RequestMapping("/sendVOList")
	public List<SampleVO> sendVOList() {
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		for(int i=0; i<10; i++) {
			
			SampleVO vo = new SampleVO();
			vo.setFirstName("�浿");
			vo.setLastName("ȫ");
			vo.setMno(i);
			
			list.add(vo);
		}
	
		return list;
	}
	
	
	@RequestMapping("/sendVOListErrorNot")
	public ResponseEntity<List<SampleVO>> sendVOListErrorNot() {
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		for(int i=0; i<10; i++) {
			
			SampleVO vo = new SampleVO();
			vo.setFirstName("�浿");
			vo.setLastName("ȫ");
			vo.setMno(i);
			
			list.add(vo);
		}
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		
		SampleVO vo = new SampleVO();
		vo.setFirstName("�浿");
		vo.setLastName("ȫ");
		vo.setMno(123);
		
		return vo;
	}
	
	
	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello RestAPI";
	}
}
