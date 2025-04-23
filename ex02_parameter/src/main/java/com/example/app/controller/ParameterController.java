package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Dto.PersonDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/param")
public class ParameterController {
	
	@RequestMapping(value="/p01", method=RequestMethod.GET)
	public void p01(@RequestParam(value="name", required=false) String name) {
		log.info("GET /param/p01..." + name);
	}
	
	@GetMapping("/p02")
	public void p02(@RequestParam(value="name", required=true) String name) {
		log.info("GET /param/p02..." + name);
	}
	
	@PostMapping(value="/p03")
	public void p03(@RequestParam(value="name", required=true) String name) {
		log.info("POST /param/p03..." + name);
	}
	
	//RequestParam : 동기요청 파라미터 처리 / form 기반 전달되느 파라미터 받기
	//RequestBody : 비동기 요청 파라미터 처리 / form / json 등 파라미터 받기
	@PostMapping(value="/p04")
	public void p04(@RequestBody String name) {
		log.info("POST /param/p04..." + name);
	}
	
	@RequestMapping(value="/p05", method=RequestMethod.GET)
	public void p05(@RequestParam(value="name", defaultValue="홍길동") String name) {
		log.info("GET /param/p05..." + name);
	}
	
	@RequestMapping(value="/p06", method=RequestMethod.GET)
	public void p06(
			@RequestParam(value="name")	String name,
			@RequestParam(value="age") int age,
			@RequestParam(value="addr") String addr
			) {
		log.info("GET /param/p06..." + name + " " + age + " " + addr);
	}
	
	@RequestMapping(value="/p07",method=RequestMethod.GET)
	public void p07(@ModelAttribute PersonDto dto) {
		log.info("GET /param/p07..." + dto);
	}
	
	@RequestMapping(value="/p08/{username}/{age}/{addr}", method=RequestMethod.GET)
	public void p08(
			@PathVariable("username") String username,
			@PathVariable int age,
			@PathVariable String addr
			) {
		log.info("GET /param/p08..." + username + " " + age + " " + addr);
	}
	
	@RequestMapping(value="/p09/{username}/{age}/{addr}", method=RequestMethod.GET)
	public void p09(@ModelAttribute PersonDto dto) {
		log.info("GET /param/p09..." + dto);
	}
	
	@GetMapping("/page01")
	public void page01(PersonDto dto) {
		log.info("GET /param/page01..." + dto);
		// 반환자료형이 void 일 때 / WEB-INF/views/param/page01.jsp와 매핑
	}
	
}
