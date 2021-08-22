package com.promising.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/man/")
public class ManagerController {

	

	@GetMapping("/manPage")
	public void monitoringPageGo(Principal principal) {
		
		
	}
	
	
	
}
