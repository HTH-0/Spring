package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.dto.UserDto;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class UserController {
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("UserController's DataBinder ..." + webDataBinder);
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new DateTestEditor());
		
		webDataBinder.registerCustomEditor(String.class, "phone", new PhoneTestEditor());
	}
	
	@GetMapping("/join")
	public void join() {
		log.info("GET /join ...");
	}
	@PostMapping("/join")
	public void join_post(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
		log.info("POST /join..." + userDto);
		
		if(bindingResult.hasErrors()) {
			for(FieldError error : bindingResult.getFieldErrors()) {			
			log.info("Error field : " + error.getField() + "Error Msg : " + error.getDefaultMessage());
			model.addAttribute(error.getField(), error.getDefaultMessage());
			}
		}
		
	}
	
	private static class DateTestEditor extends PropertyEditorSupport{

		@Override
		public void setAsText(String birthday) throws IllegalArgumentException {
			log.info("DataTestEditor's setAsText invoke..." + birthday);
			LocalDate date = null;
			if(birthday.isEmpty()) {
				date = LocalDate.now();
		}else {
			birthday = birthday.replaceAll("~","-");
			date = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
			setValue(date);
		}
		
	}
	private static class PhoneTestEditor extends PropertyEditorSupport{
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			log.info("PhoneEditor setAsText invoke... " + text);
			String num = null;
			if (text == null || text.trim().isEmpty()) {
				setValue("01000000000");
			} else {
				setValue(text.replaceAll("-", ""));
			}
		}
	}
}
