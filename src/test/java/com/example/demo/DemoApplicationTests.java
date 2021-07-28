package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootTest
class DemoApplicationTests {

	@RequestMapping("/hello")
	public String hello(){
		return "hello world!";
	}

}
