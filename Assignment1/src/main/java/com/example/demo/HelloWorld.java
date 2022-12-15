package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	 @GetMapping("/get")
	 public String getData()
	 {
		 return "Hello World!!";
	 }
	 

	 @GetMapping("/getData")
	 public String getGreeting()
	 {
		 return "Hava a good data";
	 }
	 
}
