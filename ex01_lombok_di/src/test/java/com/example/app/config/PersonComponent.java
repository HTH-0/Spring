package com.example.app.config;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PersonComponent {
	private String username;
	private int age;
	private String addr;
	
	PersonComponent(){
		this.username ="";
		this.age = 33;
		this.addr = "인천";
	}
}
